/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Arrays;
import java.util.Random;
import timeutil.TimeStamp;

/**
 * Class om de tijd te meten voor de functies in de Woorden classe
 * @author jeroen
 */
public class TestPreformance
{
    private Woorden w = new Woorden();
    private int nummer;
    TimeStamp ts;
    
    /**
     * 
     * @param Nr het nummer van woorden dat moet worden gegenereerd
     */
    public TestPreformance(int Nr)
    {
        ts = new TimeStamp();
        nummer = Nr;
    }
    /**
     * Meet de tijd voor de concordatie methoden
     */
    public void preformenceTestConcordatie()
    {
        ts.setBegin("Start concordatie");        
        w.concordatie(generateRandomWords(nummer));
        ts.setEnd("einde");
        System.out.println(ts);
    }  
    
    /**
     * Meet de tijd voor de aantal methoden
     */
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
    public void preformenceTestFrequentie()
    {
        w.pakInput(generateRandomWords(nummer));
        ts.setBegin("Start frequentie");
        w.frequentie();
        ts.setEnd("einde");
        System.out.println(ts);
    }
    
    /**
     * Genereerd random woorden
     * @param numberOfWords het nummer van worden die gegenereerd moeten worden
     * @return de gegenereerde woorden
     */
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
