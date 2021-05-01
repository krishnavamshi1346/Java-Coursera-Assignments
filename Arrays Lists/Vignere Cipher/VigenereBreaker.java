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
    
}
