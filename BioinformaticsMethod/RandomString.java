package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class RandomString {
	public static void main(String[]args) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("aaa.txt")); //read file
			
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list 
		String line;
		while ((line = br.readLine()) != null) {
			sequence.add(line); 
		}
		
		String [] array = sequence.toArray(new String[sequence.size()]); //convert list to array
		
		int length = Integer.parseInt(array[0]);
		int GCcount = 0;
		int ATcount = 0;
		
		for(int i=0;i<array[1].length();i++){
			if(array[1].charAt(i)== 'A' || array[1].charAt(i)== 'T'){
				ATcount++;
			}
			if(array[1].charAt(i)== 'C' || array[1].charAt(i)== 'G'){
				GCcount++;
			}
		}
		
		String[] numSplit = array[2].split(" ");
		double[] probability = new double[numSplit.length];
		for(int i=0;i<probability.length;i++){
			probability[i] = Double.parseDouble(numSplit[i]);
		}
		
		DecimalFormat df = new DecimalFormat("#.####");
		
		for(int i=0;i<probability.length;i++){
			double GC = probability[i]/2;
			double AT = (1-probability[i])/2;
			double total = Math.pow(GC, GCcount)*Math.pow(AT, ATcount);
			double result = (length+1-array[1].length())*total;
			String format = df.format(result);
			System.out.print(format + " ");
		}
	}

}
