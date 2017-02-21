/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author jeroen
 */
public class Woorden
{
    private String[] woorden;
    
    public void pakInput(String input)
    {
        input = input.toLowerCase();
        input = input.replaceAll("é","e");
        woorden = input.split("[^a-zA-Z]+");        
    }
    
    public String aantal()
    {
        Set<String> uniqueWoorden= new HashSet<String>();
        for(String s : woorden)
        {
            uniqueWoorden.add(s);
        }   
        return "Aantal woorden: " + woorden.length + "\nAantal unique woorden: " +  uniqueWoorden.size();
    }
    
    public String sorteer()
    {
        TreeSet<String> gesorteerd = new TreeSet<String>(); 
        for(String s : woorden)
        {
            gesorteerd.add(s);
        }
        return gesorteerd.descendingSet().toString();
    }
    
    public String frequentie()
    {
        HashMap<String,Integer> frequentie = new HashMap<String,Integer>();
        for(String s : woorden)
        {
            Integer hoevaak = frequentie.get(s);
            if(hoevaak == null)
            {
                frequentie.put(s, 1);
            }
            else
            {
                frequentie.put(s, hoevaak + 1);
            }
        }
        TreeMap<String,Integer> klaar = new TreeMap<String,Integer>(new compere(frequentie));
        klaar.putAll(frequentie);
        return klaar.toString();
    }
    
    public String concordatie(String input)
    {
        TreeMap<String,Set<Integer>> concordatie = new TreeMap<String,Set<Integer>>();
        input = input.toLowerCase();
        String[]regels = input.split("\n");
        int regelNummer = 0;
        for(String Regel : regels)
        {
            regelNummer++;
            for(String Woord: Regel.split("[^a-zA-Z]+"))
            {
                if(!concordatie.containsKey(Woord))
                {
                   concordatie.put(Woord, new HashSet<Integer>());
                }   
                concordatie.get(Woord).add(regelNummer);
            }
        }
        return concordatie.toString();
    }    
    
}
