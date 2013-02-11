/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engtest;

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
public class MainFrameTest {

    public MainFrameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLoginBtnPressed method, of class MainFrame.
     */
    @Test
    public void testGetLoginBtnPressed() {
        System.out.println("getLoginBtnPressed");
        MainFrame instance = new MainFrame();
        int expResult = 1;
        MainFrame.jButton1.doClick();
        int result = instance.getLoginBtnPressed();
        assertEquals(expResult, result);
    }

}