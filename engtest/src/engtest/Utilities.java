/*
 * Klasi pou ilopiountai kapies methodoi pou xeirizontai antikoimena "Item"
 * kathws kai arxeia eikonas gia tin eisagwgi stin vasi dedomenos (BufferedImage <--> byte array)
 */

package engtest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author CFatseas, GPanetsos
 */
public class Utilities {

    /*
     * alazei to megethos tis eikonas se gia na xwraei stin othoni
     * aneksartita twn arxikwn tis diastasewn
     * width=epithimito platos
     * height=epithimito ypsos
     */
    public static BufferedImage scaleImage(BufferedImage img, int width, int height) {
        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();
        if (imgWidth*height < imgHeight*width) {
            width = imgWidth*height/imgHeight;
        } else {
            height = imgHeight*width/imgWidth;
        }
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImage.createGraphics();
        try {
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g.setBackground(Color.BLACK);
            g.clearRect(0, 0, width, height);
            g.drawImage(img, 0, 0, width, height, null);
        } finally {
            g.dispose();
        }
        return newImage;
    }

    /*
     *  bufferedimage --> byte array 
     */
    public static byte[] img2Byte(BufferedImage img) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        byte[] newImg = baos.toByteArray();
        baos.close();
        return newImg;
    }

    /*
     *  byte array --> bufferedimage 
     */
    public static BufferedImage byte2Img(byte[] img) throws IOException{
        return ImageIO.read(new ByteArrayInputStream(img));
    }

    /*
     * I methodos pou proetimazei kai ektelei to SQL query
     * epistrefei ena antikoimeno klasis Item me ta dedomena kathe eggrafis stin vasi
     * Orismata einai o typos euresis (kata titlo(3), dimiourgo(2), katigoria(1) kai ola mazi(0))
     * episis stis periptwseis 1, 2, 3 apaitite kai i leksi "filtrarismatos"
     */
    public static Item[] getItems(String filter, int type){
        String tSql = "update Items set TTL=?,Birth=?  where ID=?";
        String sql = null;
        PreparedStatement preparedStatement = null;
        Connection conn = DbConn.connect();
        switch (type){
            case 0:
                sql = "select * from Items";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 1:
                sql = "select * from Items where Category=?";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    preparedStatement.setString(1, filter);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                sql = "select * from Items where User=?";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    preparedStatement.setString(1, filter);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                sql = "select * from Items where locate(?,Name)";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    preparedStatement.setString(1, filter);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                sql = "select * from Items";
                try {
                    preparedStatement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            
        }
        ResultSet set = null;
        int lim = 0;
        try {
            set = preparedStatement.executeQuery();
            set.last();
            lim = set.getRow();
        } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Item[] item = new Item[lim];
        try {
            int cnt =0;
            set.beforeFirst();
            while (set.next()){
                item[cnt] = new Item();
                item[cnt].setCreator(set.getString("Creator"));
                item[cnt].setUser(set.getString("User"));
                item[cnt].setId(set.getInt("Id"));
                item[cnt].setCategory(set.getString("Category"));
                item[cnt].setDescription(set.getString("Description"));
                item[cnt].setTitle(set.getString("Name"));
                item[cnt].setPrice(set.getInt("Price"));
                item[cnt].setBirth(set.getDate("Birth"));
                item[cnt].setTime(set.getInt("TTL"));
                item[cnt].setTime(item[cnt].findRealTime());
                BufferedImage image = null;
                try {
                    image = byte2Img(set.getBytes("Img"));
                } catch (IOException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                item[cnt].setImage(image);


                try {
                    preparedStatement = conn.prepareStatement(tSql);
                    preparedStatement.setInt(1, item[cnt].getTime());
                    Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    preparedStatement.setDate(2, sqlDate);
                    preparedStatement.setInt(3, item[cnt].getId());
                    preparedStatement.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                }
                cnt++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConn.disconnect(conn);
        return item;
 
    }

}
