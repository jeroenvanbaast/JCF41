/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author jeroen
 */
public class compere implements Comparator<String>
{
    Map<String, Integer> map;

    public compere(Map<String, Integer> map) {
        this.map = map;
    }


    @Override
    public int compare(String o1, String o2) {
        if(map.get(o1) >= map.get(o2)){
            return 1;
        }else{
            return -1;
        }
    }
}
