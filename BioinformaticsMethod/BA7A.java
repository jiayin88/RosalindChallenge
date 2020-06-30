package algorithmicTextbookTrack;

import java.io.*;
import java.util.*;

public class BA7A {
	
	
	public static int getDistance(int weightList[][], int x, int y, int size){
		List visited = new ArrayList();
		//Stack visited = new Stack();
		//visited.indexOf(arg0)
		int total = 0;
		int n = 0;
		int check = 0;
		int pt = 0;
		int ptX = 0;
		int ptY = 0;
		
		while(x!=y){
			//System.out.println(weightList[n][0]);
			int num1 = weightList[n][0];
			int num2 = weightList[n][1];
			if((num1 == x || num2 == x) && !visited.contains(x)){//check if x = num1 or num2 (vertices)
				check = weightList[n][2]; //act as a checker.
				total = total + check;
				visited.add(x);
				pt = visited.size()-1;
				ptX = x;
				ptY = n;
				//System.out.println(ptX);
				//kinda update your x pointer
				if(num1 == x){
					x = num2;
				}else{
					x = num1;
				}
				//System.out.println(x);
				if((n+1) == size){
					n = 0;
				}else{
					n++;
				}
				//n++;
			}else if((n+1)==size && x!=y){//check if n dy reach the last element but still not yet reach destination
				x = ptX;
				visited.remove(pt);
				total = total - check;
				if((ptY+1) < size){
					n = ptY+1;
				}
				
			}else{
				n++;
			}
		}
		
		
		return total;
	}
	
	static ArrayList<String> removeDuplicates(ArrayList<String> list) {

		// Store unique items in result.
		ArrayList<String> result = new ArrayList<String>();

		// Record encountered Strings in HashSet.
		HashSet<String> set = new HashSet<String>();

		// Loop over argument list.
		for (String item : list) {

		    // If String is not in set, add it to the list and the set.
		    if (!set.contains(item)) {
			result.add(item);
			set.add(item);
		    }
		}
		return result;
	    }

	public static void main(String[]args) throws IOException{
		//read file
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("bbb.txt")); //read file
			
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list 
		String line;
		int n = Integer.parseInt(br.readLine()); //get the first one..
		int[][] result = new int[n][n]; //this is your distance matrix
		while ((line = br.readLine()) != null) {
			String temp = line.replaceAll("->", " ");
			temp = temp.replaceAll(":"," ");
			sequence.add(temp); 
		}
		
		ArrayList<String> changed = new ArrayList<String>();
		for(String elem:sequence){
			String[] substring = elem.split(" ");
			String temp = "";
			if(Integer.parseInt(substring[0]) > Integer.parseInt(substring[1])){
				temp = substring[1] + " " + substring[0] + " " + substring[2];
			}else{
				temp = substring[0] + " " + substring[1] + " " + substring[2];
			}
			changed.add(temp);
		}
		
		ArrayList<String> unique = removeDuplicates(changed);
		int size = unique.size();
		//System.out.println(size);
		
		int[][]adjList = new int[size][3];
		int i=0;
		for(String elem : unique){
			String[] splitNum = elem.split(" ");
			adjList[i][0] = Integer.parseInt(splitNum[0]);
			adjList[i][1] = Integer.parseInt(splitNum[1]);
			adjList[i][2] = Integer.parseInt(splitNum[2]);
			System.out.println(elem);
			i++;
		}
		
		
		
		//System.out.println(getDistance(adjList,0,1,size));
		//System.out.println(getDistance(adjList,1,2,size));
	}
}
