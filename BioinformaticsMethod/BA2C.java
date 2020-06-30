package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BA2C {
	public static void main(String[]args) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("bb.txt")); //read file
			
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list 
		String line;
		while ((line = br.readLine()) != null) {
			sequence.add(line); 
		}
		
		String dna = sequence.remove(0);
		int length = Integer.parseInt(sequence.remove(0));
		double [][] profile = new double[4][length];
		//create your profile
		for(int x=0;x<4;x++){
			String temp = sequence.remove(0);
			String[] tt = temp.split(" ");
			for(int y=0;y<length;y++){
				//System.out.print(tt[x] + " ");
				profile[x][y] = Double.parseDouble(tt[y]);
			}
			//System.out.println();
		}
		
		//to do the calculation stuff
		String result = "";
		double max = 0;
		for(int i=0;i<dna.length()-length+1;i++){
			String temp = dna.substring(i, i+length);
			String[] rr = temp.split("");
			double check = 1;
			for(int j=0;j<rr.length;j++){
				if(rr[j].equals("A"))
					check = check * profile[0][j];
				else if(rr[j].equals("C"))
					check = check * profile[1][j];
				else if(rr[j].equals("G"))
					check = check * profile[2][j];
				else
					check = check * profile[3][j];
			}
			if(i == 0){
				max = check;
				result = temp;
			}else{
				if(check > max){
					max = check;
					result = temp;
				}
			}
		}
		System.out.println(result);
	}
}
