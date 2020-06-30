package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BA5C {
	public static void main(String[]args) throws IOException{
		int indel = 1;
		
		
		//get the sequence
		BufferedReader br = new BufferedReader(new FileReader("WW.txt")); //read file
		String sequence1 = br.readLine();
		String sequence2 = br.readLine();

		String[] seq1 = sequence1.split("");
		String[] seq2 = sequence2.split("");
		
		//create look-up table and direction
		//Direction: 4 = diagonal; 5 = up; 6 = right
		int[][] lookUp = new int[seq2.length+1][seq1.length+1];
		int[][] direction = new int[seq2.length+1][seq1.length+1];
		
		//initialize the lookUp and direction tables
		//initialize the first columns
		int penalty = 0;
		for(int i=1;i<=seq2.length;i++){
				//cumulative frequency of penalty
				penalty = penalty - indel;
				lookUp[i][0] = penalty;
				direction[i][0] = 5;
		}
		
		//initialize the first rows
		penalty = 0;
		for(int i=1;i<=seq1.length;i++){
				//cumulative frequency of penalty
				penalty = penalty - indel;
				lookUp[0][i] = penalty;
				direction[0][i] = 6;
		}
		
		for(int x=1;x<(seq2.length+1);x++){
			for(int y=1;y<(seq1.length+1);y++){
				int check;
				if(seq2[x-1].equals(seq1[y-1])){
					check = 1;
				}else{
					check = -1;
				}
				//System.out.println(check);
				int numUp = lookUp[x-1][y] - indel;
				int numRight = lookUp[x][y-1] - indel;
				int numDiagonal = lookUp[x-1][y-1] + check;
				
				//System.out.print(numDiagonal);
				if(numDiagonal>=numRight && numDiagonal>=numUp){
					lookUp[x][y] = numDiagonal;
					direction[x][y] = 4;
					//System.out.print("d");
					//System.out.print(numDiagonal);
				}
				else if(numUp>=numDiagonal && numUp>=numRight){
					lookUp[x][y] = numUp;
					direction[x][y] = 5;
					//System.out.print("u");
					//System.out.print(numUp);
				}
				else if(numRight>=numDiagonal && numRight>=numUp){
					lookUp[x][y] = numRight;
					direction[x][y] = 6;
					//System.out.print("r");
					//System.out.print(numRight);
				}
				else{
					continue;
				}
			}
			//System.out.println();
		}
		
		//perform traceback for it
		//Direction: 4 = diagonal; 5 = up; 6 = right
		int x = seq2.length - 1;
		int y = seq1.length - 1;
		String finalseq1 = seq1[y];
		String finalseq2 = seq2[x];
		while(x != 0 || y!= 0){
			//System.out.print(direction[x][y] + " ");
			if(direction[x][y]==4 && x!=0 && y!=0){//diagonal
				x = x - 1;
				y = y - 1;
				finalseq1 = finalseq1 + seq1[y];
				finalseq2 = finalseq2 + seq2[x];
				continue;
			}
			if(direction[x][y]==4 && (x==0 || y==0)){
				if(x==0){
					y = y-1;
					finalseq1 = finalseq1 + seq1[y];
					finalseq2 = finalseq2 + "-";
				}
				else{
					x = x-1;
					finalseq1 = finalseq1 + "-";
					finalseq2 = finalseq2 + seq2[x];
				}
				continue;
			}
			if(direction[x][y]==5){//up
				x = x - 1;
				finalseq1 = finalseq1 + "-";
				finalseq2 = finalseq2 + seq2[x];
				continue;
			}
			if(direction[x][y]==6){//right
				y = y - 1;
				finalseq1 = finalseq1 + seq1[y];
				finalseq2 = finalseq2 + "-";
				continue;
			}
		}
		
		String check1 = new StringBuffer(finalseq1).reverse().toString();
		String check2 = new StringBuffer(finalseq2).reverse().toString();
		System.out.println(new StringBuffer(finalseq1).reverse().toString());
		System.out.println(new StringBuffer(finalseq2).reverse().toString());
		
		String commonSeq = "";
		for(int i=0;i<check1.length();i++){
			if(check1.charAt(i) == check2.charAt(i) && check1.charAt(i)!= '-' && check2.charAt(i)!='-'){
				commonSeq = commonSeq + check1.charAt(i);
			}
		}
		System.out.println(commonSeq);
		br.close();
		
		
	}
}
