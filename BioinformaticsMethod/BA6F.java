package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BA6F {
	public static void main(String[]args) throws IOException{
		//get the sequence
				BufferedReader br = new BufferedReader(new FileReader("dad.txt")); //read file
				String line = br.readLine();
				
				//convert to a string array
				String array [] = line.split(" ");
				
				//convert to int array
				int num [] = new int [array.length];
				for(int i=0;i<num.length;i++){
					if(array[i].charAt(0) == '+')
						num[i] = Integer.parseInt(array[i].substring(1));
					else{
						//System.out.println(array[i]);
						int t = Integer.parseInt(array[i].substring(1));
						num[i] = -t;
					}
				}
				
				int result [] = new int [num.length*2];
				int c = 0;
				for(int j=0;j<num.length;j++){
					
					if(num[j]>0){
						result[c] = (2*num[j])-1;
						result[c+1] = 2*num[j];
					}else{
						result[c] = -2*num[j];
						result[c+1] = (-2*num[j])-1;
					}
					c = c+2;
				}
				
				System.out.print("(");
				for(int i=0;i<result.length;i++){
					System.out.print(result[i]+ " ");
				}
				
	}
}
