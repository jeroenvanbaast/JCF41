/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeroen
 */
public class bestandmaken {
    
    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private letter letter;

    public bestandmaken() {
    }

    public void saveCode(String HuffCode) throws FileNotFoundException {
        fos = new FileOutputStream("huffCodeText.bin");
        PrintWriter out = new PrintWriter(fos);
        out.println(HuffCode);
        out.flush();
    }

    public void saveDefaultText(String text) throws FileNotFoundException {
        fos = new FileOutputStream("DefaultText.txt");
        PrintWriter out = new PrintWriter(fos);
        out.println(text);
        out.flush();

    }

    public void saveHuffTree(letter letter) throws IOException {
        fos = new FileOutputStream("letter.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(letter);
        oos.flush();
    }

    public letter getHuffTree() throws IOException {
        try {
            fis = new FileInputStream("letter.ser");
            ois = new ObjectInputStream(fis);
            letter = (letter) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bestandmaken.class.getName()).log(Level.SEVERE, null, ex);
        }
        return letter;
    }

    
    public String getEncodedText(){
        String encodedText = "";
        String currentLine;
        try {
            FileReader fr = new FileReader("huffCodeText.bin");
            BufferedReader br = new BufferedReader(fr);
            while ((currentLine = br.readLine()) != null) {
                encodedText = encodedText + currentLine;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(bestandmaken.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(bestandmaken.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encodedText;
    }
}
