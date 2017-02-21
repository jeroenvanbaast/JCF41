/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jeroen
 */
public class TestPreformance
{
    private Woorden w = new Woorden();
    private int nummer;
    
    public TestPreformance(int Nr)
    {
        nummer = Nr;
    }
    public void preformenceTestConcordatie()
    {
        w.concordatie(generateRandomWords(nummer));
    }  
    
    public void preformenceTestAantal()
    {
        w.pakInput(generateRandomWords(nummer));
        w.aantal();
    }
    
    public void preformenceTestSorteer()
    {
        w.pakInput(generateRandomWords(nummer));
        w.sorteer();
    }
    
    public void preformenceTestFrequentie()
    {
        w.pakInput(generateRandomWords(nummer));
        w.frequentie();
    }
    
    // random wordt generator
    public String generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return Arrays.toString(randomStrings);
    }
}
