
/**
 * Write a description of Weather here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
import edu.duke.*;import 
org.apache.commons.csv.*;
public class Weather {

    public CSVRecord hottestHour(CSVParser parser)
    {
        CSVRecord largestSoFar=null;
        for(CSVRecord currentRow:parser)
        {
            if(largestSoFar==null)
            {
                largestSoFar=currentRow;
            }
            else{
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp=Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currentTemp>largestTemp)
                {
                    largestSoFar=currentRow;
                }
                

            }
            
        }
        return largestSoFar;
    }
    public void testHottestInDay()
    {
        FileResource fr=new FileResource("C:/Users/Administrator/Desktop/Coursera Java/CSV ASSIGNMENT/data/2015/weather-2015-01-01.csv");
        CSVRecord largest=hottestHour(fr.getCSVParser()); 
        System.out.println("Hottest Temperature was"+largest.get("TemperatureF"));
        
        
        
    }
}
