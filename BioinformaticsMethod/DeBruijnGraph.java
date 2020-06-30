package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DeBruijnGraph {

	
	public static void main(String[]args) throws IOException{
		
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("rr.txt")); //read file
			
		ArrayList<String> list = new ArrayList<String>(); //put into a list since we don't know how many kMers given
		String line;
		while ((line = br.readLine()) != null) {
			list.add(line); //adding kMers into the list
		}
		
		String [] dna = list.toArray(new String[list.size()]); //convert list to array
		int k = dna[0].length(); //length of each sequence
		
		
		ArrayList<String> sequence = new ArrayList<String>();
		ArrayList<String> sequenceTemp = new ArrayList<String>();
		
		for(int y=0;y<dna.length;y++){
			for(int i=0;i<1;i++){
				//going to separate it
				String temp = dna[y].substring(i,i+(k-1));
				sequence.add(temp); //add all k-mers into the list
				
				String temp2 = dna[y].substring((i+1),(i+k));
				sequenceTemp.add(temp2);
			}
		}
		
		String [] kMer = sequence.toArray(new String[sequence.size()]); //convert list to array
		String [] resultKMer = sequenceTemp.toArray(new String[sequenceTemp.size()]);
		
		//printing out the kMer
				String tempKMer = "";
				for(int i=0;i<kMer.length;i++){
					if(kMer[i].isEmpty()){
						continue;
					}
					tempKMer = resultKMer[i];
					for(int j=(i+1);j<kMer.length;j++){
						if(kMer[i].equals(kMer[j]) && (j+1) < kMer.length && !kMer[i].isEmpty() && !kMer[j].isEmpty()){
							tempKMer = tempKMer + "," + resultKMer[j];
							kMer[j] = "";
						}
					}
					System.out.println(kMer[i] + " -> " + tempKMer);
					tempKMer = "";
				}
		
		
		
	}
}
