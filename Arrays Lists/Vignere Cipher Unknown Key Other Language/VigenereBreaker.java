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
        public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
                        'p','q','r','s','t','u','v','w','x','y','z'};
        for( int i=0; i<chars.length; i++){
            characters.put(chars[i],0);
        }
        for (String word : dictionary){
           for( char s : characters.keySet()){
               if (word.contains(Character.toString(s))){
                   characters.put(s, characters.get(s)+1);
                }
            }
        }
        int maxValue = 0;
        for(char s : characters.keySet()){
            int value = characters.get(s);
            if (value > maxValue){
                maxValue = value;
            }
        }
        for(char s : characters.keySet()){
            if (characters.get(s) == maxValue){
                return s;
            }
        }
        return 'a';
    }
    
    private HashMap<String, HashSet<String>> langList(){
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        FileResource English = new FileResource("dictionaries/English");
        languages.put("English", readDictionary(English));
        FileResource Danish = new FileResource("dictionaries/Danish");
        languages.put("Danish", readDictionary(Danish));
        FileResource Dutch = new FileResource("dictionaries/Dutch");
        languages.put("Dutch", readDictionary(Dutch));
        FileResource French = new FileResource("dictionaries/French");
        languages.put("French", readDictionary(French));
        FileResource German = new FileResource("dictionaries/German");
        languages.put("German", readDictionary(German));
        FileResource Italian = new FileResource("dictionaries/Italian");
        languages.put("Italian", readDictionary(Italian));
        FileResource Portuguese = new FileResource("dictionaries/Portuguese");
        languages.put("Portuguese", readDictionary(Portuguese));
        FileResource Spanish = new FileResource("dictionaries/Spanish");
        languages.put("Spanish", readDictionary(Spanish));
        return languages;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
        for (String s : languages.keySet()){
            HashSet lang = languages.get(s);
            String decrypted = breakForLanguage(encrypted,lang);
            int wordCount = countWords(decrypted, lang);
            System.out.println("LANGUAGE CHOSEN = " + s);
            System.out.println("Decrypted message  ="+ decrypted);
            System.out.println("Words counted = "+ wordCount);
        }
    }
    public void breakVigenere3(){
        FileResource text = new FileResource("messages/secretmessage3.txt");
        langList();
        String testingFile = text.asString();
        breakForAllLangs(testingFile, langList());
        }
}


    

