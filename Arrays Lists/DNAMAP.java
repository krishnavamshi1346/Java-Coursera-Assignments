
/**
 * Write a description of DNAMAP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class DNAMAP {
private    HashMap<String,Integer> dnahashmap;
public DNAMAP()
{
dnahashmap=new HashMap<String,Integer>();
}
public void buildCodon(int start,String dna)
{
    dnahashmap.clear();
    int count=0;
    for(int i=start;i<dna.length()-2;i+=3)
    {
        String codon=dna.substring(i,i+3);
        if(dnahashmap.containsKey(codon))
        {
        dnahashmap.put(codon,dnahashmap.get(codon)+1);
        }
        else
        {
        dnahashmap.put(codon,1);
        count++;
        }
    }
    System.out.println("Unique codons are"+count);
}
public void  printCodon()
{
    for(String s:dnahashmap.keySet())
    {
        System.out.println(s.toUpperCase()+" "+dnahashmap.get(s));
    }
}
public void test(){
        int start = 0;
        String dna = "CGTTCAAGTTCAA";
        dna = dna.toLowerCase();
        buildCodon(start,dna);
        printCodon();   

}
}
