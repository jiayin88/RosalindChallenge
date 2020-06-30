package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BA6B {
	
	public static void main(String[]args) throws IOException{
		
		//get the sequence
				BufferedReader br = new BufferedReader(new FileReader("dad.txt")); //read file
				String line = br.readLine();
				
				//convert to a string array
				String array [] = line.split(" ");
				
				//convert to int array
				int num [] = new int [array.length];
				for(int i=0;i<num.length;i++){
						num[i] = Integer.parseInt(array[i].substring(1));
				}
				
			int count = 0;
			int temp = 0; //as a pointer
			//to check for adjacency
			for(int i=0;i<num.length;i++){
				if((num[i]+1) == temp || (num[i]-1 == temp)){
					//System.out.println(temp);
					temp = num[i];
					continue;
				}
				else if ((num[i]+1) != temp || (num[i]-1 != temp) || num[i] == temp){
					count++;
					temp = num[i];
					System.out.println(temp);
					continue;
				}
				else{
					continue;
				}
			}
			
			System.out.println(count);
	}
}
