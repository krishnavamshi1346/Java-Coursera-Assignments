
/**
 * Write a description of UniqueIpTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class UniqueIpTester {
    public void testUniqueIp()
    {
        LogAnalyzer la=new LogAnalyzer();
        HashMap<String,Integer> count_ips=new HashMap<String,Integer>();
        la.readFile("weblog2-short_log");
        int uniqueips=la.countUniqueIps();
        System.out.println("Unique Ips Count is"+uniqueips);
        count_ips=la.countVisitsPerIp();
        System.out.println(count_ips);

        
        
        
        
    }

}
