package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BA2A {
	public static void main(String[]args)throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("ee.txt")); //read file
			
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list 
		String line;
		while ((line = br.readLine()) != null) {
			sequence.add(line); 
		}
		
		String [] array = sequence.toArray(new String[sequence.size()]); //convert list to array
		
		//k-mer length and number of mismatch
		int k = 5;
		int mismatch = 2;
		
		String[] nucleotide = {"A","C","G","T"};
		String[] kMer = new String[(int) Math.pow(4, k)];
		int num = 0;
	
		for(int a=0;a<4;a++)//1
			for(int b=0;b<4;b++)//2
				for(int c=0;c<4;c++)//3
				
					for(int d=0;d<4;d++)//4
						for(int e=0;e<4;e++)//5
						{
					kMer[num] = nucleotide[a]+nucleotide[b]+nucleotide[c]+nucleotide[d]+nucleotide[e];
					//kMer[num] = nucleotide[a]+nucleotide[b]+nucleotide[c]+nucleotide[d]+nucleotide[e]+nucleotide[f]+nucleotide[g]+nucleotide[h];
					//kMer[num] = nucleotide[a]+nucleotide[b]+nucleotide[c]+nucleotide[d]+nucleotide[e]+nucleotide[f]+nucleotide[g]+nucleotide[h]+nucleotide[i]+nucleotide[j]+nucleotide[k1];
					num++;
				}
/*						for(int f=0;f<4;f++)//6
								for(int g=0;g<4;g++)//7
									for(int h=0;h<4;h++)//8
										for(int i=0;i<4;i++)//9
											for(int j=0;j<4;j++)//10
												for(int k1=0;k1<4;k1++)//10
											{
				//								kMer[num] = nucleotide[a]+nucleotide[b]+nucleotide[c]+nucleotide[d]+nucleotide[e]+nucleotide[f]+nucleotide[g]+nucleotide[h];
												kMer[num] = nucleotide[a]+nucleotide[b]+nucleotide[c]+nucleotide[d]+nucleotide[e]+nucleotide[f]+nucleotide[g]+nucleotide[h]+nucleotide[i]+nucleotide[j]+nucleotide[k1];
												num++;
											}
		
*/
		int count = 0;
		int same = 0;
		int length = array.length;
		
		for(int xx=0;xx<kMer.length;xx++){
			char[] dna1 = kMer[xx].toCharArray();
			for(int zz=0;zz<array.length;zz++){
				for(int yy=0;yy<array[zz].length()-k+1;yy++){
					count = 0;
					String pattern = array[zz].substring(yy,yy+k);
					char[] dna2 = pattern.toCharArray();
					for(int n=0; n<dna1.length;n++){
						if(dna1[n] != dna2[n]){
							count++;
						}
					}
					//System.out.println(count);
					if(count <= mismatch){
						same++;
						break;
					}
					count = 0;
				}
			}
			if(same == length){
				System.out.print(kMer[xx] + " ");
			}
			same = 0;
		}
		
	}
}
