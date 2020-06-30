package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*Implement greedy sorting algorithm
 * Given: A signed permutation P.
 * Return: The sequence of permutations corresponding to applying GreedySorting to P, ending with the identity permutation.
 */
public class BA6A {
	
	public static void main(String[]args) throws IOException{
		//get the sequence
		BufferedReader br = new BufferedReader(new FileReader("dad.txt")); //read file
		String line = br.readLine();
		//to write into a file
				File file = new File("result.txt");
				if (!file.exists()){
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
		
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
		
/*		String tempLine = "(";
		for(int i=0;i<num.length;i++){
			if(num[i]>0)
				tempLine = tempLine + "+" + num[i] + " ";
			else
				tempLine = tempLine + num[i]+ " ";
		}
		tempLine = tempLine + ")";
		bw.write(tempLine);
		bw.newLine();
		tempLine = "";
*/		
		int count = 0;
		//to perform swapping process
		for(int i=1;i<=num.length;i++){ //loop to search first number
			for(int j=(i-1);j<num.length;j++){
				if(Math.abs(num[j])==i && j!=(i-1)){ //if smallest num(i) is not at the first position
					
					int L = i-1;
					//System.out.println(L);
					for(int k=j;k>=i;k--){ //perform swapping of numbers
						if(L < k){
							int temp = num[k];
							num[k] = -num[L];
							num[L] = -temp;
							L++;
						}
						else if(L == k){
							num[k] = -num[k];
						}
						else{
							continue;
						}
					}
					
		/*			String tempLine1 = "(";
					for(int a=0;a<num.length;a++){
						if(num[a]>0)
							tempLine1 = tempLine1 + "+" + num[a] + " ";
						else
							tempLine1 = tempLine1 + num[a]+ " ";
					}
					tempLine1 = tempLine1 + ")";
					bw.write(tempLine1);
					bw.newLine();
					tempLine1 = "";
		*/			count++;
				}
				
			}
			
			if(num[i-1]<0){
				num[i-1] = -num[i-1];
		/*		String tempLine1 = "(";
				for(int a=0;a<num.length;a++){
					if(num[a]>0)
						tempLine1 = tempLine1 + "+" + num[a] + " ";
					else
						tempLine1 = tempLine1 + num[a]+ " ";
				}
				tempLine1 = tempLine1 + ")";
				bw.write(tempLine1);
				bw.newLine();
				tempLine1 = "";
		*/		//count++;
			}
		}
		
		bw.close();
		br.close();
		System.out.println(count-1);
	}
}
