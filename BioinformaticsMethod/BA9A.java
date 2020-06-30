package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BA9A {
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("bb.txt")); //read file
		
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list 
		String line;
		while ((line = br.readLine()) != null) 
			sequence.add(line); 
		String [] array = sequence.toArray(new String[sequence.size()]); //convert list to array
		
		
	}
}
