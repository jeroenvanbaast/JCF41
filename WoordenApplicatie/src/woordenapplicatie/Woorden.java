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
    
    /**
     * Maakt alle input kleine leters en zet é om naar e
     * Deze niewue input wordt omgezet naar een array
     * @param input de ingevoerde tekst door de gebruiker
     */
    public void pakInput(String input)
    {
        input = input.toLowerCase();
        input = input.replaceAll("é","e");
        woorden = input.split("[^a-zA-Z]+");        
    }
    
    /**
     * Deze methode berekend het aantal worden en het aantal unique woorden
     * Er wordt hier gebruik gemaakt van een Set omdat het unique woorden bij moet houden
     * Er is gekozen voor een HashSet omdat deze sneller werkt dan andere sets
     * @return De string voor de output
     */
    public String aantal()
    {
        Set<String> uniqueWoorden= new HashSet<String>();
        for(String s : woorden)
        {
            uniqueWoorden.add(s);
        }   
        return "Aantal woorden: " + woorden.length + "\nAantal unique woorden: " +  uniqueWoorden.size();
    }
    
    /**
     * Deze methoden sorteerd de unique worden in tegengestelde orde
     * Er is gekozen voor een Set omdat het unique worden zijn
     * Er is gekozen voor een TreeSet omdat deze de input automatisch sorteerd
     * @return De string voor de output deze wordt hier ook in omgedraaid
     */
    public String sorteer()
    {
        TreeSet<String> gesorteerd = new TreeSet<String>(); 
        for(String s : woorden)
        {
            gesorteerd.add(s);
        }
        return gesorteerd.descendingSet().toString();
    }
    
    /**
     * Deze methoden geeft de unique worden terug met hoeveelheid dat ze voorkomen
     * Dit gesorteerd op de hoeveelheid dat ze voorkomen
     * Er is gekozen voor een Map omdat hier 2 waardes in kunnen
     * Er is eerst een HashMap aangemaakt omdat de volgorde hier niet uitmaakt en dit sneller is
     * Daarna is het omgezet naar een TreeMap omdat deze de input sorteerd
     * Een TreeMap sorteerd normaal op de Key waarden maar dit is overschreven zodat hij op de Value sorteerd
     * @return De string voor de output
     */
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
    
    /**
     * Deze methoden geeft van elk woord aan in welke regel deze staat
     * Er is gekozen voor een Map omdat er 2 data types in kunnen
     * Er is gekozen voor een HashMap omdat deze sneller is en de volgorde niet uitmaakt
     * In de HashMap is een colection gestopt omdat een woord op meerdere plekken kan voorkomen
     * Er is hier gekozen voor een Set zodat er geen dubbele regels in komen
     * Er is gekozen voor een HashSet omdat de volgorde niet uitmaakt en he sneller is
     * @param input Dit is de input van de gebruiker
     * @return De string voor de output
     */
    public String concordatie(String input)
    {
        HashMap<String,Set<Integer>> concordatie = new HashMap();
        input = input.toLowerCase();
        String[]regels = input.split("\n");
        int regelNummer = 0;
        // Gaat regel voor regel door de input heen
        for(String Regel : regels)
        {
            regelNummer++;
        // Gaat woord voor woord door de regel heen
            for(String Woord: Regel.split("[^a-zA-Z]+"))
            {
                if(!concordatie.containsKey(Woord))
                {
                   HashSet<Integer> test = new HashSet();
                   test.add(regelNummer);
                   concordatie.put(Woord, test);                   
                }   
                else{
                concordatie.get(Woord).add(regelNummer);
                }
            }
        }
        return concordatie.toString();
    }    
    
}
