/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;

/**
 *
 * @author oscar
 */
public class PalabraTest {
    
    public PalabraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class Palabra.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        ISqlJetCursor cursor = null;
        Palabra expResult = null;
        Palabra result = Palabra.read(cursor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Palabra.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Palabra instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPronunciation method, of class Palabra.
     */
    @Test
    public void testGetPronunciation() {
        System.out.println("getPronunciation");
        Palabra instance = null;
        String expResult = "";
        String result = instance.getPronunciation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefinition method, of class Palabra.
     */
    @Test
    public void testGetDefinition() {
        System.out.println("getDefinition");
        Palabra instance = null;
        String expResult = "";
        String result = instance.getDefinition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSource method, of class Palabra.
     */
    @Test
    public void testGetSource() {
        System.out.println("getSource");
        Palabra instance = null;
        String expResult = "";
        String result = instance.getSource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExample method, of class Palabra.
     */
    @Test
    public void testGetExample() {
        System.out.println("getExample");
        Palabra instance = null;
        String expResult = "";
        String result = instance.getExample();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLanguage method, of class Palabra.
     */
    @Test
    public void testGetLanguage() {
        System.out.println("getLanguage");
        Palabra instance = null;
        long expResult = 0L;
        long result = instance.getLanguage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrade_of_knowledge method, of class Palabra.
     */
    @Test
    public void testGetGrade_of_knowledge() {
        System.out.println("getGrade_of_knowledge");
        Palabra instance = null;
        long expResult = 0L;
        long result = instance.getGrade_of_knowledge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriority method, of class Palabra.
     */
    @Test
    public void testGetPriority() {
        System.out.println("getPriority");
        Palabra instance = null;
        long expResult = 0L;
        long result = instance.getPriority();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}