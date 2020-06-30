package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*Given: A string Text, a collection of strings Patterns, and an integer d.
 *Return: All positions in Text where a string from Patterns appears as a substring with at most d mismatches.
 * */
public class BA9O {
	
	public static ArrayList<Integer> numberOfPatternOccurence(String pattern, String dna, int mismatch){
		/*This is to find the number of times does a pattern occur in a given string with at most d mismatches
		 * To use:
		 * System.out.println(numberOfPatternOccurence(pattern,dna,mismatch);
		 * */
		
		int length = pattern.length();
		int dnaLength = dna.length();
		
		ArrayList<Integer> tempNum = new ArrayList<Integer>();
		char[] dna1 = pattern.toCharArray();
		
		int count = 0;
		for(int i=0; i<=(dnaLength-length);i++){
			String temp = dna.substring(i,i+length);
			char[] dna2 = temp.toCharArray();
			for(int j=0; j<dna1.length;j++){
				if(dna1[j] != dna2[j]){count++;}	
			}
			if(count<=mismatch){tempNum.add(i);}
			count=0;
		}
		
		return tempNum;
	}
	
	public static void main(String[]args) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("bbb.txt")); //read file
			
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list 
		String line;
		while ((line = br.readLine()) != null) {
			sequence.add(line); 
		}
		
		String [] array = sequence.toArray(new String[sequence.size()]); //convert list to array
		
		String[] pattern = array[1].split(" "); //the pattern of the given question
		int mismatch = Integer.parseInt(array[2]); //the number of mismatch
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0;i<pattern.length;i++){
			temp.addAll(numberOfPatternOccurence(pattern[i], array[0], mismatch));
		}
		
		Collections.sort(temp);
		// Loop through elements.
		for (int i = 0; i < temp.size(); i++) {
		    int value =temp.get(i);
		    System.out.print(value + " ");
		}
		
	}
}
