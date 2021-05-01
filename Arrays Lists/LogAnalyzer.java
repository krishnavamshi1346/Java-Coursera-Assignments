
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class LogAnalyzer {
    private ArrayList<LogEntry> record;
    public LogAnalyzer()
    {
    record=new ArrayList<LogEntry>();
    }
    public void readFile(String Filename)
    {
        FileResource fr=new FileResource();
        for(String lines:fr.lines())
        {
            LogEntry le= WebLogParser.parseEntry(lines);
            record.add(le);
            
        }
    }
    public int countUniqueIps()
    {
        ArrayList<String> uniqueIps=new ArrayList<String>();
        
        for(LogEntry le:record)
        {
            String ipaddress=le.getIpAddress();
            if(!uniqueIps.contains(ipaddress))
            {
                uniqueIps.add(ipaddress);
            }
        }
        return uniqueIps.size();    
    }
    public HashMap<String,Integer> countVisitsPerIp()
    {
        HashMap<String,Integer> counts=new HashMap<String,Integer>();
        for(LogEntry le:record)
        {
        String ipaddress=le.getIpAddress();
        if(counts.containsKey(ipaddress))
        {
            counts.put(ipaddress,counts.get(ipaddress)+1);
    
        }
        else{
            counts.put(ipaddress,1);
    
        }
        }
        return counts;
        
    }
}
    


