package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BA3A {
	public static void main(String[]args) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("t2.txt")); //read file
		BufferedWriter bw = new BufferedWriter(new FileWriter("ttt.txt"));
		
		String line;
		int length = Integer.parseInt(br.readLine());
		String seq = "";
		while ((line = br.readLine()) != null) {
			seq = seq + line; 
		}
		ArrayList<String> dna =new ArrayList<String>();  
		for(int i=0;i<=seq.length()-length;i++){
			String temp = seq.substring(i, i+length);
			dna.add(temp);
		}
		Collections.sort(dna);
		int count = 0;
		for(String counter: dna){
			bw.write(counter);
			bw.newLine();
			System.out.println(counter);
			count++;
		}
		bw.close();
		System.out.println(count);
	}
}
