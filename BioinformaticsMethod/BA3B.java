package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BA3B {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("t2.txt")); //read file
		String result = br.readLine();
		String line;
		while ((line = br.readLine()) != null) {
			String temp = line.substring(line.length()-1);
			result = result + temp;
		}
		System.out.println(result);
		br.close();
	}
}
