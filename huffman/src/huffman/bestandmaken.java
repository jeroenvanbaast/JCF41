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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeroen
 */
public class bestandmaken
{

    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private letter letter;

    public bestandmaken()
    {
    }

    public void saveCode(String huffcode) throws FileNotFoundException, IOException
    {
        BitSet bits = new BitSet();
        for (int i = 0; i < huffcode.length(); i++)
        {
            Character c = huffcode.charAt(i);
            boolean bool = false;
            switch (c)
            {
                case '1':
                    bool = true;
                    break;
                case '0':
                    bool = false;
                    break;
            }
            bits.set(i, bool);
        }
        fos = new FileOutputStream("huffCodeText.bin");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(bits);
        oos.writeInt(huffcode.length());
        oos.close();
    }

    public void saveDefaultText(String text) throws FileNotFoundException
    {
        fos = new FileOutputStream("DefaultText.txt");
        PrintWriter out = new PrintWriter(fos);
        out.println(text);
        out.flush();
    }

    public void saveHuffTree(letter letter) throws IOException
    {
        fos = new FileOutputStream("letter.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(letter);
        oos.flush();
    }

    public letter getHuffTree() throws IOException
    {
        try
        {
            fis = new FileInputStream("letter.ser");
            ois = new ObjectInputStream(fis);
            letter = (letter) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(bestandmaken.class.getName()).log(Level.SEVERE, null, ex);
        }
        return letter;
    }

    public String getEncodedText()
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            fis = new FileInputStream("huffCodeText.bin");
            ois = new ObjectInputStream(fis);
            BitSet set = (BitSet) ois.readObject();
            int length = ois.readInt();
            for (int i = 0; i < length; i++)
            {
                if (set.get(i))
                {
                    sb.append("1");
                } else
                {
                    sb.append("0");
                }
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(bestandmaken.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(bestandmaken.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(bestandmaken.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();

    }

}
