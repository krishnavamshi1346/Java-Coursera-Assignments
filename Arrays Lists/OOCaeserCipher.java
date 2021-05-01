
/**
 * Write a description of OOCaeserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class OOCaeserCipher {
    private int key;
    public OOCaeserCipher(int key)
    {
        this.key=key;
    }
    private String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
    

    public String encrypt(String input)
    {
        String upper=input.toUpperCase();
        StringBuilder encrypted=new StringBuilder(upper);
        //encrypted=encrypted.toUpperCase();
        
        for(int i=0;i<input.length();i++)
        {
            char c=encrypted.charAt(i);
            int idx=alphabet.indexOf(c);
            if(idx!=-1)
            {
            char newChar=shiftedAlphabet.charAt(idx);
            if(Character.isLowerCase(input.charAt(i)))
            {
                
                char newChar1=Character.toLowerCase(newChar);
                //System.out.println(newChar+"  "+newChar1);
                encrypted.setCharAt(i,newChar1);
            }
            else{
            encrypted.setCharAt(i,newChar);
            }
            }
            
            
        }
        
        return encrypted.toString();
    }
    
    public void Testing()
    {
        //OOCaeserCipher o=new OOCaeserCipher(10);
        FileResource fr=new FileResource();
        String message=fr.asString();
        String encrypted=encrypt(message);
        System.out.println("Encrypted Message is "+encrypted);
        //String decrypted=encrypt(26-key,encrypted);
        //System.out.println("Decrypted Message is "+decrypted);
        
        
    }
    

}



