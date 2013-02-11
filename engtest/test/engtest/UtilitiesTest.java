/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engtest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CFatseas, GPanetsos
 */
public class UtilitiesTest {

    public UtilitiesTest() {
    }

    URL uimg = null;
    BufferedImage image = null;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        try {
            uimg = new URL("http://download-photos-images-pic.bdr130.net/1/26769.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UtilitiesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            image = ImageIO.read(uimg);
        } catch (IOException ex) {
            Logger.getLogger(UtilitiesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of scaleImage method, of class Utilities.
     */
    @Test
    public void testScaleImage() {
        System.out.println("scaleImage");
        int width = 150;
        int height = 150;
        BufferedImage result = Utilities.scaleImage(image, width, height);
        assertEquals(result.getWidth(), 150);
        assertEquals(result.getHeight(), 150);
    }

    /**
     * Test of img2Byte method, of class Utilities.
     */
    @Test
    public void testImg2Byte() throws Exception {
        System.out.println("img2Byte");
        BufferedImage img = image;
        byte expResult0 = (byte) 0xFF;
        byte[] result = Utilities.img2Byte(img);
        assertEquals(expResult0, result[0]);
    }

    /**
     * image byte Array ????? 
     
    @Test
    public void testByte2Img() throws Exception {
        System.out.println("byte2Img");
        byte[] img = null;
        BufferedImage expResult = null;
        BufferedImage result = Utilities.byte2Img(img);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Utilities.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        String filter = "";
        int type = 0;
        Item[] result = Utilities.getItems(filter, type);
        assertEquals(6, result.length);
        filter = "other";
        type = 1;
        result = Utilities.getItems(filter, type);
        assertEquals(3, result.length);
        filter = "diamond";
        type = 3;
        result = Utilities.getItems(filter, type);
        assertEquals(2, result.length);
    }

}