/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeroen
 */
public class huffmanLogica {
    
    private String input;
    private List<letter> letters;
    private PriorityQueue priority;
    private HashMap<String,String> leafs;
    private bestandmaken bestand;
    
    public huffmanLogica(String input)
    {
        leafs = new HashMap();
        this.input = input;
        bestand = new bestandmaken();
        maakHufcode();
        bestandmaken();
        bestanduitlezen();
    }
    
    public void maakHufcode()
    {
        frequency();
        sorteerOpFrequency();
        maakBoom();
        doorloopBoom((letter)priority.peek(),"");
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
    
    public void doorloopBoom(letter letter,String code)
    {
        if(letter.getLeftLetter() != null)
        {
        //    System.out.println(letter);
            doorloopBoom(letter.getLeftLetter(),code + "0");
        }
        if(letter.getRightLetter() != null)
        {
        //    System.out.println(letter);
            doorloopBoom(letter.getRightLetter(), code + "1");
        }
        if(letter.getLeftLetter() == null && letter.getRightLetter() == null)
        {
            leafs.put(letter.getCharacter(), code);
        //    System.out.println(letter);
        }
    }
    
    public String makeCode()
    {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i <input.length(); i++)
        {
            char c = input.charAt(i);
            builder.append(leafs.get(String.valueOf(c)));
        }            
        return builder.toString();
    }
    
    public void bestandmaken()
    {
        try {
            bestand.saveHuffTree((letter)priority.peek());
            bestand.saveCode(makeCode());
            bestand.saveDefaultText(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(huffmanLogica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(huffmanLogica.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void bestanduitlezen()
    {
        try {
            letter boom = bestand.getHuffTree();
            String code = bestand.getEncodedText();
            decode(boom,code);            
        } catch (IOException ex) {
            Logger.getLogger(huffmanLogica.class.getName()).log(Level.SEVERE, null, ex);
        }                   
    }
    
    public String decode(letter boom, String code)
    {
        StringBuilder builder = new StringBuilder();
        letter base = boom;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                base = base.getRightLetter();
            } else if (code.charAt(i) == '0') {
                base = base.getLeftLetter();
            }
            if (base.getLeftLetter() == null && base.getRightLetter() == null) {
                builder.append(base.getCharacter());
                base = boom;
            }
        }   
        System.out.println(builder.toString());
        return builder.toString();        
    }

    public String getInput()
    {
        return input;
    }

    public List<letter> getLetters()
    {
        return letters;
    }

    public PriorityQueue getPriority()
    {
        return priority;
    }

    public HashMap<String, String> getLeafs()
    {
        return leafs;
    }

    public bestandmaken getBestand()
    {
        return bestand;
    }
    
    
    
    
    
}
