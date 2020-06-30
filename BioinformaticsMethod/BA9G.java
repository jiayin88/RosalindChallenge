package algorithmicTextbookTrack;

import java.io.*;
import java.util.Arrays;

public class BA9G {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("bbb.txt")); //read file
		String line = br.readLine();
		br.close();
		String[] sequence = new String[line.length()];
		String[] sorted = new String[line.length()];
		for(int i=0;i<line.length();i++){
			String temp = line.substring(i,line.length());
			sequence[i] = temp;
			sorted[i] = temp;
		}
		
		Arrays.sort(sorted);
		
		for(int i=0;i<sorted.length;i++){
			for(int j=0;j<sequence.length;j++){
				if(sequence[j].equals(sorted[i])){
					System.out.print(j + ", ");
				}
			}
		}
	}
}
