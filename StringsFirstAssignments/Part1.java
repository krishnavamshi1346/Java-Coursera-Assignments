package StringsFirstAssignments;


/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
 import edu.duke.*;
import java.io.*;
public class Part1 {
   

    public int findStopCodon(String dnaStr,int startIndex,String stopCodon)
    {
     int currIndex=dnaStr.indexOf(stopCodon,startIndex) ;
     while(currIndex!=-1)
     {
         int dif=currIndex-startIndex;
       if(dif%3==0)
       {
       return currIndex;
       }
       else
       {
           currIndex=dnaStr.indexOf(stopCodon,currIndex+1);
       }
       }
       return -1    ;  
      }
      public String findGene(String dna,int where)
      {
          int startIndex=dna.indexOf("ATG",where);
          if(startIndex==-1)
          {
            return "";
            }
            int taaIndex=findStopCodon(dna,startIndex,"TAA");
            int tagIndex=findStopCodon(dna,startIndex,"TAG");
            int tgaIndex=findStopCodon(dna,startIndex,"TGA");
            //int temp=Math.min(taaIndex,tagIndex);
            //int minIndex=Math.min(temp,tgaIndex);
            int minIndex=0;
            if(taaIndex==-1 || tgaIndex!=-1 && (tgaIndex<taaIndex))
            {
            minIndex=tgaIndex;
            }
            else{
            minIndex=taaIndex;
            }
            if(minIndex==-1 || tagIndex!=-1 && (tagIndex<minIndex))
            {
            minIndex=tagIndex;
            }
            if(minIndex==-1)
            {
            
            return "";
            }
            return dna.substring(startIndex,minIndex+3);
        }
        public void printAllGene(String dna)
        {
        int startIndex=0;
        while(true)
        {
         String currentGene=findGene(dna,startIndex);
         if(currentGene.isEmpty())
         {
             break;
            }
         System.out.println(currentGene);
         startIndex=dna.indexOf(currentGene,startIndex)+currentGene.length();
        }
    }
        public void testOn()
        {
            String dna="ATGATCTAATTTATGCTGCAACGGTGAAGA";
            System.out.println("GIVEN GENE IS"+dna);
            System.out.println("DNA IN GIVEN GENE ARE");
            
            printAllGene(dna);
            System.out.println();
            
            String dna1="ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
             System.out.println("GIVEN GENE IS"+dna);
            System.out.println("DNA IN GIVEN GENE ARE");
            
            printAllGene(dna1);
            System.out.println();
            //printAllGene(dna);
        }
        /*public void testFindGene()
        {
        String dna= "ATGCCCGGGAAATAGCCC";
        String gene=findGene(dna);
        System.out.println(gene);
        }*/


}
