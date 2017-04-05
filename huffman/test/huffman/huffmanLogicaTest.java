/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
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
public class huffmanLogicaTest
{
    
    public huffmanLogicaTest()
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
     * Test of frequency method, of class huffmanLogica.
     */
    @Test
    public void testFrequency()
    {
        String input = "Eerie eyes seen near lake.";
        huffmanLogica h = new huffmanLogica(input);
        h.frequency();
        List<letter> letters= new LinkedList<letter>();
        letters.add(new letter(" ", 4));
        letters.add(new letter("a", 2));
        letters.add(new letter("r", 2));
        letters.add(new letter("s", 2));
        letters.add(new letter("E", 1));
        letters.add(new letter("e", 8));
        letters.add(new letter("i", 1));
        letters.add(new letter("y", 1));
        letters.add(new letter("k", 1));
        letters.add(new letter("l", 1));
        letters.add(new letter("n", 2));
        letters.add(new letter(".", 1));
        System.out.println(letters.toString());
        System.out.println(h.getLetters().toString());
        assertEquals(letters.toString(),h.getLetters().toString());
    }

    /**
     * Test of sorteerOpFrequency method, of class huffmanLogica.
     */
    @Test
    public void testSorteerOpFrequency()
    {
        String input = "Eerie eyes seen near lake.";
        huffmanLogica h = new huffmanLogica(input);
        h.sorteerOpFrequency();
        PriorityQueue priority = new PriorityQueue<>(12, new huffmanCompare());
        priority.add(new letter(" ", 4));
        priority.add(new letter("a", 2));
        priority.add(new letter("r", 2));
        priority.add(new letter("s", 2));
        priority.add(new letter("E", 1));
        priority.add(new letter("e", 8));
        priority.add(new letter("i", 1));
        priority.add(new letter("y", 1));
        priority.add(new letter("k", 1));
        priority.add(new letter("l", 1));
        priority.add(new letter("n", 2));
        priority.add(new letter(".", 1));
        String test = h.getPriority().toString();
        assertEquals(priority.toString(),test);
    }

    /**
     * Test of maakBoom method, of class huffmanLogica.
     */
    @Test
    public void testMaakBoom()
    {
        String input = "Eerie eyes seen near lake.";
        huffmanLogica h = new huffmanLogica(input);
        h.maakHufcode();
        letter test = (letter) h.getPriority().peek();
        assertEquals(26,test.getFrequency());
    }

    /**
     * Test of doorloopBoom method, of class huffmanLogica.
     */
    @Test
    public void testDoorloopBoom()
    {
        String input = "Eerie eyes seen near lake.";
        huffmanLogica h = new huffmanLogica(input);
        h.maakHufcode();
        HashMap<String,String> leafs = new HashMap();
        leafs.put(" ","001");
        leafs.put("a","111");
        leafs.put("r","101");
        leafs.put("s","1001");
        leafs.put("E","00010");
        leafs.put("e","01");
        leafs.put("y","00000");
        leafs.put("i","00001");
        leafs.put("k","1100");
        leafs.put("l","00011");
        leafs.put("n","1000");
        leafs.put(".","1101");
        assertEquals(leafs.toString(),h.getLeafs().toString());
    }

    /**
     * Test of makeCode method, of class huffmanLogica.
     */
    @Test
    public void testMakeCode()
    {
        String input = "Eerie eyes seen near lake.";
        huffmanLogica h = new huffmanLogica(input);
        String test = "000100110100001010010100000011001001100101011000001100001111101001000111111100011101";
        assertEquals(test,h.makeCode());
    }

    /**
     * Test of decode method, of class huffmanLogica.
     */
    @Test
    public void testDecode()
    {
        String input = "Eerie eyes seen near lake.";
        huffmanLogica h = new huffmanLogica(input);
        letter test = (letter) h.getPriority().peek();
        String testString = "Eerie eyes seen near lake.";
        assertEquals(testString,h.decode(test, "000100110100001010010100000011001001100101011000001100001111101001000111111100011101"));
    } 
    
     @Test
    public void testEend(){
        String input = "eend";
        huffmanLogica h = new huffmanLogica(input);
        letter test = (letter) h.getPriority().peek();
        String uitkomst = "eend";
        assertEquals(uitkomst,h.decode(test, "001110"));
    }
    
}
