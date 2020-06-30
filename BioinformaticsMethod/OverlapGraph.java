package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OverlapGraph {
	public static void main(String[]args) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("qq.txt")); //read file
			
		ArrayList<String> list = new ArrayList<String>(); //put into a list since we don't know how many kMers given
		String line;
		String tempLine = "";
		while ((line = br.readLine()) != null) {
			if(line.charAt(0)== '>'){
				list.add(line); //adding kMers into the list
				tempLine = "";
				//System.out.println(line);
				continue;
			}
		    if(line.charAt(0) != '>' && tempLine.isEmpty()){
				tempLine = tempLine + line;
			}
			else{
				tempLine = tempLine + line;
				list.add(tempLine);
				//System.out.println(tempLine);
			}
		}
		
		String [] dna = list.toArray(new String[list.size()]); //convert list to array
		//int k = dna[1].length(); //length of each sequence
		
		for(int i=1;i<dna.length;i=i+2){
			String temp = dna[i].substring(dna[i].length()-3);
			for(int j=1;j<dna.length;j=j+2){
				String temp2 = dna[j].substring(0,3);
				if(temp.equals(temp2)){
					String dnaTemp1 = dna[i-1].substring(1);
					String dnaTemp2 = dna[j-1].substring(1);
					if(!dnaTemp1.equals(dnaTemp2)){
						System.out.println(dnaTemp1 + " " + dnaTemp2);
					}
				}
			}
		}
	}
}
