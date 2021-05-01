import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb = new StringBuilder();
        for(int i = whichSlice; i < message.length(); i += totalSlices){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
       
    

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker();
        for ( int i=0; i<klength; i++){
            String SliceEach = sliceString(encrypted, i, klength);
            int newKey = cc.getKey(SliceEach);
            key[i] = newKey;
        }

        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
                FileResource f = new FileResource();
       String textToStr = f.asString();
       int[] applykey = tryKeyLength(textToStr,5,'e');
       VigenereCipher vignere = new VigenereCipher(applykey);
       System.out.println(vignere.decrypt(textToStr));

    }
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> dictionaryList=new HashSet<String>();
        for(String line:fr.lines())
        {
            String lineLower = line.toLowerCase();
            dictionaryList.add(lineLower);

        }
        return dictionaryList;

    }
    public int countWords(String message, HashSet<String> dictionary){
        String[] messageSplit = message.split("\\W+");
        int commonWords = 0;
        for(int i=0; i < messageSplit.length; i++){
            String word = messageSplit[i].toLowerCase();
            if (dictionary.contains(word)){
                commonWords++;
            }
        }
        return commonWords;
    }
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int max = 0;
        String perfectDecrypted = "";
        for(int i=1; i<=100; i++){
            int[] keys = tryKeyLength(encrypted, i, 'e' );
            VigenereCipher vignere = new VigenereCipher(keys);
            String decrypted = vignere.decrypt(encrypted);
            int wordsCounted = countWords(decrypted, dictionary);
            if(wordsCounted > max){
                max = wordsCounted;
                perfectDecrypted = decrypted;
                //validKey = keys;
            }
        }
        System.out.println("This file contains " + max + " valid words.");
        return perfectDecrypted;
    }
    public void breakVigenere2(){
        FileResource text = new FileResource("messages/secretmessage2.txt");
        FileResource fr = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(fr);
        String testingFile = text.asString();
        String perfectDecryption = breakForLanguage(testingFile, dictionary);
        System.out.println(perfectDecryption);
    }

    
}
