/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engtest;

import java.util.Date;
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
public class ItemTest {

    Item testItem = new Item();

    public ItemTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        testItem.setId(1);
        testItem.setCreator("x");
        testItem.setTitle("x");
        testItem.setCategory("x");
        testItem.setDescription("x");
        testItem.setTime(1);
        Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        testItem.setBirth(sqlDate);
        testItem.setUser("x");
        testItem.setPrice(1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Item.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 1;
        int result = testItem.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Item.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        testItem.setId(id);
        assertEquals(0, testItem.getId());
    }

    /**
     * Test of getCreator method, of class Item.
     */
    @Test
    public void testGetCreator() {
        System.out.println("getCreator");
        String expResult = "x";
        String result = testItem.getCreator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCreator method, of class Item.
     */
    @Test
    public void testSetCreator() {
        System.out.println("setCreator");
        String creator = "";
        testItem.setCreator(creator);
        assertEquals("", testItem.getCreator());
    }

    /**
     * Test of getTitle method, of class Item.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "x";
        String result = testItem.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Item.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        testItem.setTitle(title);
        assertEquals("",testItem.getTitle());
    }

    /**
     * Test of getCategory method, of class Item.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        String expResult = "x";
        String result = testItem.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategory method, of class Item.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        testItem.setCategory(category);
        assertEquals("", testItem.getCategory());
    }

    /**
     * Test of getDescription method, of class Item.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "x";
        String result = testItem.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Item.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        testItem.setDescription(description);
        assertEquals("", testItem.getDescription());
    }

    /**
     * Test of getTime method, of class Item.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        int expResult = 1;
        int result = testItem.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTime method, of class Item.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int time = 0;
        testItem.setTime(time);
        assertEquals(0, testItem.getTime());
    }

    /**
     * Test of getBirth method, of class Item.
     */
    @Test
    public void testGetBirth() {
        System.out.println("getBirth");
        Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Date expResult = sqlDate;
        Date result = testItem.getBirth();
        assertEquals(expResult, result);
    }

   

    /**
     * Test of getUser method, of class Item.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String expResult = "x";
        String result = testItem.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUser method, of class Item.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        testItem.setUser(user);
        assertEquals("", testItem.getUser());
    }

    /**
     * Test of getPrice method, of class Item.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        int expResult = 1;
        int result = testItem.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Item.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 0;
        testItem.setPrice(price);
        assertEquals(0, testItem.getPrice());
    }

    /**
     * Test of findRealTime method, of class Item.
     */
    @Test
    public void testFindRealTime() {
        System.out.println("findRealTime");
        int expResult = 1;
        int result = testItem.findRealTime();
        assertEquals(expResult, result);
    }

}