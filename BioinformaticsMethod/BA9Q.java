package algorithmicTextbookTrack;

import java.io.*;
import java.util.Arrays;

public class BA9Q {
	public static void main(String[]args) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("bbb.txt")); //read file
		String line = br.readLine();
		int n = Integer.parseInt(br.readLine());
		//ArrayList<String> sequence = new ArrayList<String>();
		String[] sequence = new String[line.length()];
		String[] sorted = new String[line.length()];
		for(int i=0;i<line.length();i++){
			String temp = line.substring(i,line.length());
			sequence[i] = temp;
			sorted[i] = temp;
		}
		
		Arrays.sort(sorted);
		int[] num = new int[sorted.length];
		
		for(int i=0;i<sorted.length;i++){
			for(int j=0;j<sequence.length;j++){
				if(sequence[j].equals(sorted[i])){
					//System.out.print(j + ", ");
					num[i] = j;
				}
			}
		}
		
		for(int i=0;i<sequence.length;i++){
			if(num[i] % n == 0){
				System.out.println(i + "," + num[i]);
			}
		}
		
	}
}
