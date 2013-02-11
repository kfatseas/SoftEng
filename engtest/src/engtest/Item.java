/*
 * Klasi "Item" 
 * Periexei tis plirofories kathe antikoimenou
 */

package engtest;

import java.awt.image.BufferedImage;
import java.util.Date;


/**
 *
 * @author CFatseas, GPanetsos
 */
public class Item {
    private int id;
    private String creator;
    private String title;
    private String category;
    private String description;
    private int time;
    private Date birth;
    private BufferedImage image;
    private String user;
    private int price;
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getCreator(){
        return creator;
    }

    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public int getTime(){
        return time;
    }
    
    public void setTime(int time){
        this.time = time;
    }
    
    public Date getBirth(){
        return birth;
    }

    public void setBirth(Date birth){
        this.birth = birth;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    /*
     * Enimerwnei ton apomeinanta xrono mexri tin liksi tis dimoprasias
     */
    public int findRealTime(){
        Date now = new Date();
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        long millisec = sqlDate.getTime() - birth.getTime();
        this.time -= (int) ((((millisec/1000)/60)/60)/24);
        return time;
    }
}
