/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Woorden;

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import timeutil.TimeStamp;
import woordenapplicatie.Woorden;

/**
 *
 * @author jeroen
 */
public class TimeTest
{
    private Woorden w = new Woorden();
    private int nummer = 100000;
    private TimeStamp ts;
    
    public TimeTest()
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
        ts = new TimeStamp();
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
    public void preformenceTestConcordatie()
    {
        ts.setBegin("Start concordatie");        
        w.concordatie(generateRandomWords(nummer));
        ts.setEnd("einde");
        System.out.println(ts);
    }  
    
    /**
     * 
     */
    @Test
    public void preformenceTestAantal()
    {
        w.pakInput(generateRandomWords(nummer));
        ts.setBegin("Start aantal");
        w.aantal();
        ts.setEnd("einde");
        System.out.println(ts);
    }
    
    /**
     * Meet de tijd voor de sorteer methoden
     */
    @Test
    public void preformenceTestSorteer()
    {
        w.pakInput(generateRandomWords(nummer));
        ts.setBegin("Start sorteer");
        w.sorteer();
        ts.setEnd("einde");
        System.out.println(ts);
    }
    
    /** 
     * meet de tijd voor de frequentie methoden
     */
    @Test
    public void preformenceTestFrequentie()
    {
        w.pakInput(generateRandomWords(nummer));
        ts.setBegin("Start frequentie");
        w.frequentie();
        ts.setEnd("einde");
        System.out.println(ts);
    }
    
    public String generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; 
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return Arrays.toString(randomStrings);
    }
}
