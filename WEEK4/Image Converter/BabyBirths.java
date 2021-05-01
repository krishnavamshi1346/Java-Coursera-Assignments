
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class BabyBirths {
    public void printNames(FileResource fr)
    {
        //FileResource fr=new FileResource();
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            int numBorn=Integer.parseInt(rec.get(2));
            System.out.println("Name :"+rec.get(0)+" Gender : "+rec.get(1)+" Num Born:"+ rec.get(2));
        }
    
    }
    public void printCount(FileResource fr)
    {
        
        int total=0;
        int numBoys=0,numGirls=0;
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            int numBorn=Integer.parseInt(rec.get(2));
            total+=numBorn;
            if(rec.get(1).equals("M"))
            {
            numBoys+=numBorn;
            }
            if(rec.get(1).equals("F"))
            {
            numGirls+=numBorn;
            }
            
        }
            System.out.println("Total count"+total);
            System.out.println("Boys count"+numBoys);
            System.out.println("Girls count"+numGirls);
    
    }
    public void getRank(FileResource fr,String name,String gender)
    {
        
        int total=0;
        //int numBoys=0,numGirls=0;
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            //int numBorn=(rec.get(1));
            if(rec.get(1).equals(gender))
            {
                total+=1;
            if(rec.get(0).equals(name))
            {
                System.out.println("Rank is"+total);
                break;
            }
            
            
        }
    }
}
    public void testing()
    {
        FileResource fr=new FileResource();
        printNames(fr);
        printCount(fr);
        getRank(fr,"Mason","M");
    }
    
}
