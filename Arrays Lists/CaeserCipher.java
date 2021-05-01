
/**
 * Write a description of CaeserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class CaeserCipher {
    public String encrypt(int key,String input)
    {
        String upper=input.toUpperCase();
        StringBuilder encrypted=new StringBuilder(upper);
        //encrypted=encrypted.toUpperCase();
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
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
    public int[] countOccurence(String message)
    {
    String alph="abcdefghijklmnopqrstuvwxyz";
    int counts[]=new int[26];
    for(int k=0;k<message.length();k++)
    {
        char ch=Character.toLowerCase(message.charAt(k));
        int idx=alph.indexOf(ch);
        if(idx!=-1){
        counts[idx]+=1;
                    }
    
    }
    return counts;
     }
     public int maxIndex(int[] freqs)
     {
         int max=0,index=-1;
         for(int i=0;i<freqs.length;i++)
         {
             if(freqs[i]>max)
             {
                max=freqs[i];
                index=i;
                }
             
            }
            return index;
        }
     public String decrypt(String encrypted)
     {
       int[] freqs=countOccurence(encrypted);
       int maxDex=maxIndex(freqs);
       int dkey=maxDex-4;
       if(maxDex<4)
       {
        maxDex=26-(4-maxDex);
        }
        return encrypt(26-dkey,encrypted).toString();
        }
        public void decryptTest()
        {
           FileResource fr=new FileResource();
        String message=fr.asString();
        String decrypt_message=decrypt(message);
        System.out.println("Decrypted Message is "+decrypt_message);
        
        }
    public void Testing()
    {
        int key=17;
        FileResource fr=new FileResource();
        String message=fr.asString();
        String encrypted=encrypt(key,message);
        System.out.println("Encrypted Message is "+encrypted);
        String decrypted=encrypt(26-key,encrypted);
        System.out.println("Decrypted Message is "+decrypted);
        
        
    }
    

}
