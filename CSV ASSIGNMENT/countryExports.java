
/**
 * Write a description of countryExports here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class countryExports {
    public void countryInfo(CSVParser parser,String country)
    {
        for(CSVRecord record:parser)
        {
            String con=record.get("Country");
            if(con.contains(country))
        {
        System.out.print(con+":");
        String export=record.get("Exports");
        System.out.print(export+" : ");
        String value=record.get("Value (dollars)");
        System.out.println(value+"  ");
        }
        }
        
    }
    public void listExportersTwoProducts (CSVParser parser,String export1,String export2)
    {
        for(CSVRecord record:parser)
        {
            String export=record.get("Exports");
            if(export.contains(export1) && export.contains(export2))
            {
                String con=record.get("Country");

                System.out.println(con+"  ");
            }
        }
    }
    public void numberOfExporters(CSVParser parser,String export1)
    {
        int count=0;
        for(CSVRecord record:parser)
        {
            String export=record.get("Exports");
            if(export.contains(export1) )
            {
                count+=1;
                
            }
        }
        System.out.println(count);
    }
public void tester()
{
    FileResource fr=new FileResource();
    CSVParser parser=fr.getCSVParser();
    //countryInfo(parser,"Malaysia");
    //listExportersTwoProducts(parser,"coffee","vanilla");
    System.out.print("Number of Countries with export Coffee is ");
    numberOfExporters(parser,"coffee");
    
    
}
}
