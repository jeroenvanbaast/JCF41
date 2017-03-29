/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author Jeroen
 */
public class letter {
    
    private String character;
    private int frequency;
    private letter leftLetter;
    private letter rightLetter;
    private String code;
    
    public letter(String character, int frequency)
    {
        this.character = character;
        this.frequency = frequency;
    }

    public letter(int frequency, letter leftLetter, letter rightLetter)
    {
        this.frequency = frequency;
        this.leftLetter = leftLetter;
        this.rightLetter = rightLetter;
    }
    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "character=" + character + ", frequency=" + frequency + '}';
    }

    public letter getLeftLetter() {
        return leftLetter;
    }

    public letter getRightLetter() {
        return rightLetter;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
    
}
