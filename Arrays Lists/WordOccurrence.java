
/**
 * Write a description of WordOccurrence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class WordOccurrence {
private ArrayList<String>mywords;
private ArrayList<Integer> myfreq;
public WordOccurrence()
{
    mywords=new ArrayList<String>();
    myfreq=new ArrayList<Integer>();
    
}
void findUnique()
{
    FileResource f=new FileResource();
    for(String s:f.words())
    {
        s.toLowerCase();
        int idx=mywords.indexOf(s);
        if(idx==-1)
        {
            mywords.add(s);
            myfreq.add(1);
            
        }
        else{
            int value=myfreq.get(idx);
            myfreq.set(idx,value+1);
        }
    }
}
public void tester()
{
    findUnique();
    System.out.println(" Size is"+mywords.size());
    for(int i=0;i<mywords.size();i++)
    {
        System.out.println(mywords.get(i)+" "+myfreq.get(i));
    }
}
    
}


