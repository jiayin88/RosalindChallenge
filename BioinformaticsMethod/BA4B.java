package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class BA4B {
	
	public static String convertDnaToProtein(String seq){
		/*To use:
		 * for(int i=0; i<dna.length();i=i+3){
			String temp = dna.substring(i,i+3);
			protein = protein + convertDnaToProtein(temp);
		}
		*/
		
		Hashtable<String, String> codonTable = new Hashtable<String, String>();
		
		codonTable.put("ATT","I"); codonTable.put("ATC","I"); codonTable.put("ATA","I");
		
		codonTable.put("CTT","L"); codonTable.put("CTC","L"); codonTable.put("CTA","L"); 
		codonTable.put("CTG","L"); codonTable.put("TTA","L"); codonTable.put("TTG","L");
		
		codonTable.put("GTT","V"); codonTable.put("GTC","V");
		codonTable.put("GTA","V"); codonTable.put("GTG","V");
		
		codonTable.put("TTT","F"); codonTable.put("TTC","F");
		
		codonTable.put("ATG","M");
		
		codonTable.put("TGT","C"); codonTable.put("TGC","C");
		
		codonTable.put("GCT","A"); codonTable.put("GCC","A");
		codonTable.put("GCA","A"); codonTable.put("GCG","A");
		
		codonTable.put("GGT","G"); codonTable.put("GGC","G");
		codonTable.put("GGA","G"); codonTable.put("GGG","G");
		
		codonTable.put("CCT","P"); codonTable.put("CCC","P");
		codonTable.put("CCA","P"); codonTable.put("CCG","P");
		
		codonTable.put("ACT","T"); codonTable.put("ACC","T");
		codonTable.put("ACA","T"); codonTable.put("ACG","T");

		codonTable.put("TCT","S"); codonTable.put("TCC","S"); codonTable.put("TCA","S");
		codonTable.put("TCG","S"); codonTable.put("AGT","S"); codonTable.put("AGC","S");
		
		codonTable.put("TAT","Y"); codonTable.put("TAC","Y");
		
		codonTable.put("TGG","W");
		
		codonTable.put("CAA","Q"); codonTable.put("CAG","Q");
		
		codonTable.put("AAT","N"); codonTable.put("AAC","N");
		
		codonTable.put("CAT","H"); codonTable.put("CAC","H");
		
		codonTable.put("GAA","E"); codonTable.put("GAG","E");
		
		codonTable.put("GAT","D"); codonTable.put("GAC","D");
		
		codonTable.put("AAA","K"); codonTable.put("AAG","K");
		
		codonTable.put("CGT","R"); codonTable.put("CGC","R"); codonTable.put("CGA","R");
		codonTable.put("CGG","R"); codonTable.put("AGA","R"); codonTable.put("AGG","R");
		
		codonTable.put("TAA","*"); //can be * 
		codonTable.put("TAG","*");//can be *
		codonTable.put("TGA","*");//can be *
		
		String convert = codonTable.get(seq);
		
		return convert;
	}
	
	public static String reverseComplement (String dna){
		/*To use:
		 * System.out.println(reverseComplement(dna));
		 * */
		String complement = "";
		String rev = "";
		//finding complement of the sequence
		for(int i=0;i<dna.length();i++){
			
			if(dna.charAt(i) == 'A'){
				complement = complement + "T";
			}
			if(dna.charAt(i) == 'a'){
				complement = complement + "t";
			}
			if(dna.charAt(i) == 'T'){
				complement = complement + "A";
			}
			if(dna.charAt(i) == 't'){
				complement = complement + "a";
			}
			if(dna.charAt(i) == 'C'){
				complement = complement + "G";
			}
			if(dna.charAt(i) == 'c'){
				complement = complement + "g";
			}
			if(dna.charAt(i) == 'G'){
				complement = complement + "C";
			}
			if(dna.charAt(i) == 'g'){
				complement = complement + "c";
			}
		}
		
		for(int x=(dna.length()-1);x>=0;x--){
			rev = rev + complement.charAt(x);
		}
		
		return rev;
	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("bbb.txt")); //read file
		String dna = br.readLine();
		String pattern = br.readLine();
		int length = pattern.length()*3;
		
		
		//forward and reverse. this one only reverse!
		
		for(int i=0;i<dna.length()-length+1;i++){
			String temp = dna.substring(i,i+length);
			String revTemp = reverseComplement(temp);
			String revProt = "";
			String protein = "";
			for(int j=0; j<temp.length();j=j+3){
				String temp2 = temp.substring(j,j+3);
				protein = protein + convertDnaToProtein(temp2);
				String revTemp2 = revTemp.substring(j,j+3);
				revProt = revProt + convertDnaToProtein(revTemp2);
			}
			if(protein.equals(pattern)|| revProt.equals(pattern)){
				System.out.println(temp);
			}
		}
		br.close();
	}
}
