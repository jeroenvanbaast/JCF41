/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.Comparator;

/**
 *
 * @author Jeroen
 */
public class huffmanCompare implements Comparator<letter>{
    
    @Override
     public int compare(letter o1, letter o2) {
        if (o1.getFrequency() > o2.getFrequency()) {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    
}
