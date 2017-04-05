/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeroen
 */
public class letterTest
{
    
    public letterTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }



    /**
     * Test of setCharacter method, of class letter.
     */
    @Test
    public void testSetCharacter()
    {
        letter test = new letter("test",1);
        test.setCharacter("hoi");
        assertEquals("hoi",test.getCharacter());
    } 

    /**
     * Test of setFrequency method, of class letter.
     */
    @Test
    public void testSetFrequency()
    {
        letter test = new letter("test",1);
        test.setFrequency(1);
        assertEquals(1,test.getFrequency());
    }


    /**
     * Test of setCode method, of class letter.
     */
    @Test
    public void testSetCode()
    {
        letter test = new letter("test",1);
        test.setCode("test");
        assertEquals("test",test.getCode());
    }
    
}
