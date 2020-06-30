package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BA6E {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("bb.txt")); //read file
		int len = Integer.parseInt(br.readLine());
		String dna1 = br.readLine();
		String dna2 = br.readLine();
		
		PrintWriter writer = new PrintWriter("resultB6E.txt", "UTF-8");
		
		//steps:
		//1. get all the patterns in dna1
		//2. get the complement patterns in dna1
		//3. get all the patterns in dna2
		//4. get all the complement patterns in dna2
		//4. get all the unique patterns in dna1 and save it into an arraylist
		//5. get all the unique complement patterns in dna1 and save it into another arraylist
		//6. convert all patterns to arraylist pattern.
		
		
		
		for(int i=0;i<dna1.length()-len+1;i++){
			String pattern = dna1.substring(i,i+len);
			String compPattern = "";
			for(int y=0;y<pattern.length();y++){
				if(pattern.charAt(y)=='A')
					compPattern = compPattern + "T";
				else if(pattern.charAt(y)=='T')
					compPattern = compPattern + "A";
				else if(pattern.charAt(y)=='C')
					compPattern = compPattern + "G";
				else
					compPattern = compPattern + "C";
			}
			for(int j=0;j<dna2.length()-len+1;j++){
				String p = dna2.substring(j,j+len);
				if(p.equals(pattern) || p.equals(compPattern))
					writer.println("("+i+", "+j+")");
			}
			
		}
		
		br.close();
		writer.close();
	}
}
