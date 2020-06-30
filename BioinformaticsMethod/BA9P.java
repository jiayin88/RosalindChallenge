package algorithmicTextbookTrack;

import java.io.*;
import java.util.ArrayList;

public class BA9P {
	public static void main(String[]args) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("bbb.txt")); //read file
			
		ArrayList<String> sequence = new ArrayList<String>(); //put into a list for everything b4 "-"
		String line;
		int count = 0;
		while ((line = br.readLine()) != null) {
			if(line.equals("-")){
				count = sequence.size();
				break;
			}else{
					sequence.add(line);
			}
		}
		//put it into its respective array index
		String[] color = new String[count];
		int check = 0;
		while((line = br.readLine()) != null){
			String[] temp = line.split(": ");
			int num = Integer.parseInt(temp[0]);
			if(temp[1].equals("red"))
				color[num] = "red";
			else
				color[num] = "blue";
			check++;
		}
		
		//System.out.println(color[0] == null);
		
		//loop through the arraylist to check and thus index it accordingly
		while(check != count){
			for(int i=0;i<color.length;i++){
				if(color[i] != null)
					continue;
				else{
					String temp = sequence.get(i);
					String[] index = temp.split(" -> ");
					String[] value = index[1].split(",");
					int n = 0;
					String tempColor = "";
					for(int j=0;j<value.length;j++){
						int pt = Integer.parseInt(value[j]);
						if(color[pt] == null){
							tempColor = "";
							break;
						}else{
							if(n == 0){
								tempColor = color[pt];
								n++;
							}else if(n == 1 && tempColor.equals(color[pt])){
								continue;
							}else{
								tempColor = "purple";
								break;
							}
						}
					}
					if(!tempColor.isEmpty()){
						color[i] = tempColor;
						check++;
					}
				}
			}
		}
				
		//to print out everything
		for(int i=0;i<color.length;i++){
			System.out.println(i + ": " + color[i]);
		}
		
	}
}
