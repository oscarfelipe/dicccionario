/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.concurrent.Task;
import model.Palabra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

/**
 *
 * @author oscar
 */
public class DBControllerTest {
    
    public DBControllerTest() {
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
     * Test of open method, of class DBController.
     */
    @Test
    public void testOpen() throws Exception {
        System.out.println("open");
        SqlJetDb expResult = null;
        SqlJetDb result = DBController.open();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class DBController.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        DBController.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beginReadTransaction method, of class DBController.
     */
    @Test
    public void testBeginReadTransaction() throws Exception {
        System.out.println("beginReadTransaction");
        DBController.beginReadTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startWriteTransaction method, of class DBController.
     */
    @Test
    public void testStartWriteTransaction() throws Exception {
        System.out.println("startWriteTransaction");
        DBController.startWriteTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitTransaction method, of class DBController.
     */
    @Test
    public void testCommitTransaction() throws Exception {
        System.out.println("commitTransaction");
        DBController.commitTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPalabra method, of class DBController.
     */
    @Test
    public void testAddPalabra() throws Exception {
        System.out.println("addPalabra");
        Palabra palabra = null;
        long expResult = 0L;
        long result = DBController.addPalabra(palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllWords method, of class DBController.
     */
    @Test
    public void testGetAllWords() throws Exception {
        System.out.println("getAllWords");
        ISqlJetCursor expResult = null;
        ISqlJetCursor result = DBController.getAllWords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createWorkerToSave method, of class DBController.
     */
    @Test
    public void testCreateWorkerToSave() throws Exception {
        System.out.println("createWorkerToSave");
        Palabra palabra = null;
        Task expResult = null;
        Task result = DBController.createWorkerToSave(palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}