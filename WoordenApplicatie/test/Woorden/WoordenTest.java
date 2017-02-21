/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Woorden;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.Woorden;
import woordenapplicatie.compere;

/**
 *
 * @author jeroen
 */
public class WoordenTest
{
    String input =   "Een, twee, drie, vier\n" +
                                "Hoedje van, hoedje van\n" +
                                "Een, twee, drie, vier\n" +
                                "Hoedje van papier\n" ;
    Woorden w;
    public WoordenTest()
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
        w = new Woorden();
    }
    
    @After
    public void tearDown()
    {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void aantal()
    {
        String verwacht = "Aantal woorden: " + 15 + "\nAantal unique woorden: " +  7;
        w.pakInput(input);
        assertEquals(verwacht,w.aantal());
    }
    
    @Test
    public void sorteer()
    {
        w.pakInput(input);
        TreeSet<String> gesorteerd = new TreeSet<String>(); 
        gesorteerd.add("vier");
        gesorteerd.add("van");
        gesorteerd.add("twee");
        gesorteerd.add("papier");
        gesorteerd.add("hoedje");
        gesorteerd.add("een");
        gesorteerd.add("drie");        
        String verwacht = gesorteerd.descendingSet().toString();
        assertEquals(verwacht,w.sorteer());
    }
    
    @Test
    public void frequentie()
    {
        w.pakInput(input);
        HashMap<String,Integer> frequentie = new HashMap<String,Integer>();
        frequentie.put("papier", 1);
        frequentie.put("een", 2);
        frequentie.put("twee", 2);
        frequentie.put("drie", 2);
        frequentie.put("vier", 2);
        frequentie.put("hoedje", 3);
        frequentie.put("van", 3);        
        TreeMap<String,Integer> klaar = new TreeMap<String,Integer>(new compere(frequentie));
        klaar.putAll(frequentie);
        String verwacht = klaar.toString();
        assertEquals(verwacht,w.frequentie());
    }
    
    @Test
    public void concordatie()
    {
        TreeMap<String,Set<Integer>> concordatie = new TreeMap<String,Set<Integer>>();
        concordatie.put("drie", new HashSet<Integer>());
        concordatie.get("drie").add(1);
        concordatie.get("drie").add(3);
        concordatie.put("een", new HashSet<Integer>());
        concordatie.get("een").add(1);
        concordatie.get("een").add(3);
        concordatie.put("hoedje", new HashSet<Integer>());
        concordatie.get("hoedje").add(2);
        concordatie.get("hoedje").add(4);
        concordatie.put("papier", new HashSet<Integer>());
        concordatie.get("papier").add(4);
        concordatie.put("twee", new HashSet<Integer>());
        concordatie.get("twee").add(1);
        concordatie.get("twee").add(3);
        concordatie.put("van", new HashSet<Integer>());
        concordatie.get("van").add(2);
        concordatie.get("van").add(4);
        concordatie.put("vier", new HashSet<Integer>());
        concordatie.get("vier").add(1);
        concordatie.get("vier").add(3);
        String verwacht = concordatie.toString();
        assertEquals(verwacht,w.concordatie(input));
    }
    
    
    
    
    
    
}
