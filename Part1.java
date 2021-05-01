
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    	public String findProtein(String dna) {
		int start = dna.indexOf("atg");
		if (start == -1) {
			return "";
		}
		int stop = dna.indexOf("taa", start+3);
		 
		if ((stop - start) % 3 == 0) {
			return dna.substring(start, stop+3);
		}
		else {
			return "";
		}
	}
	   public void testing() {
	       String a1 = "atgaattcctaagg";
		System.out.println("Gene:    "+a1);
		System.out.println(findProtein(a1));

		String a = "cccatggggtttaaataataataggagagagagagagagttt";
		System.out.println("Gene:    "+a);
		System.out.println(findProtein(a));
		String ap = "atggggttt";
		System.out.println("Gene:  "+ap);
		System.out.println(findProtein(ap));
	
	   }
	   public static void main(String args[])
	{
	   Part1 p=new Part1();
	   p.testing();
	   }

}

