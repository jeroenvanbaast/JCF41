/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;

/**
 *
 * @author Jeroen
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String input = "Eerie eyes seen near lake.";
        huffmanLogica h = new huffmanLogica(wonderland());
    }
    
    public static String wonderland() throws FileNotFoundException, IOException {
        String alice = "";
        String currentLine;
            FileReader fr = new FileReader("wonderland.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((currentLine = br.readLine()) != null) {
                alice = alice + currentLine;
            }
        return alice;
    }
   
}
