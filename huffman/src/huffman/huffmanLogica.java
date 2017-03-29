/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Jeroen
 */
public class huffmanLogica {
    
    private String input;
    private List<letter> letters;
    private PriorityQueue priority;
    
    public huffmanLogica(String input)
    {
        this.input = input;
        frequency();
        System.out.println(letters);
        sorteerOpFrequency();
        System.out.println(priority);
        //maakBoom();
        //System.out.println(priority.peek());
        //doorloopBoom((letter)priority.peek());
    }
    
    public void frequency()
    {
        HashMap<String,Integer> letterFrequency = new HashMap<String,Integer>();
        letters= new LinkedList<>();
        for ( String s : input.split("")) {
            Integer count = letterFrequency.get(s);
            if (count == null) {
                letterFrequency.put(s,1);
            }
            else {
                letterFrequency.put(s,count + 1);
            }
        }
         for(HashMap.Entry<String, Integer> entry : letterFrequency.entrySet())
        {
            letter letter = new letter(entry.getKey(),entry.getValue());
            letters.add(letter);
        }
    }
    
    // werkt nog niet zet de spatie met freqenty 4 tussen de 2s
    public void sorteerOpFrequency()
    {
       priority = new PriorityQueue<>(letters.size(), new huffmanCompare());
       for(letter l : letters)
       {
           priority.add(l);
       }
    }
    
    public void maakBoom()
    {
        while(priority.size() > 1)
        {
        letter left = (letter) priority.poll();
        letter right = (letter) priority.poll();
        letter newLetter = new letter(left.getFrequency() + right.getFrequency(),left,right);
        priority.add(newLetter);
        }        
    }
    
    public void doorloopBoom(letter letter)
    {
        if(letter.getLeftLetter() != null)
        {
            System.out.println(letter);
            doorloopBoom(letter.getLeftLetter());
        }
        if(letter.getRightLetter() != null)
        {
            System.out.println(letter);
            doorloopBoom(letter.getRightLetter());
        }
        if(letter.getLeftLetter() == null && letter.getRightLetter() == null)
        {
            System.out.println(letter);
            // done
        }
    }
}
