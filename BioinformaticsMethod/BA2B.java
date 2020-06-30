package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BA2B {
	
	public static int hammingDistance(String seq1, String seq2){
		/*To use:
		 * int result = hammingDistance(sequence1, sequence2);
		 * System.out.println(result);
		 * */
		char[] dna1 = seq1.toCharArray();
		char[] dna2 = seq2.toCharArray();
		
		int count = 0;
		for(int i=0; i<dna1.length;i++){
			if(dna1[i] != dna2[i]){
				count++;
			}	
		}
		return count;
	}
	
	public static void main(String[]args) throws IOException{
		
		int k = 3;
		
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("bb.txt")); //read file
			
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list 
		String line;
		while ((line = br.readLine()) != null) {
			sequence.add(line); 
		}
		
		String [] arraySeq = sequence.toArray(new String[sequence.size()]); //convert list to array
		String [] pattern = new String[arraySeq.length-k+1];
		for(int i=0;i<pattern.length;i++)
			pattern[i] = arraySeq[0].substring(i,i+k);
		
		int minDistance = k;
		String result = "";
		
		for(int i=0;i<pattern.length;i++){
			for(int j=1;j<arraySeq.length;j++){
				for(int m=0;m<arraySeq[j].length()-k+1;m++){
					String temp = arraySeq[j].substring(m,m+k);
					int tempResult = hammingDistance(temp,pattern[i]);
					if(tempResult <= minDistance){
						minDistance = tempResult;
						result = pattern[i];
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
