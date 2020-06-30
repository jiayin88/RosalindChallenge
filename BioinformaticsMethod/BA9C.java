package bioinformaticsMethod;

import java.util.*;
import java.io.*;

public class BA9C {
	
	private static ArrayList<String> getSuffixArray(String input) {
		ArrayList<String> str = new ArrayList<String>();
		
		for(int i=input.length()-1;i>=0;i--) {
			String temp = input.substring(i, (input.length()));
			str.add(temp);
		}		
		Collections.sort(str);
		return(str);
	}
	
	private static int  lcp(String one, String two) {
		int min = Math.min(one.length(), two.length());
		for(int i=0;i<min;i++) {
			if(one.charAt(i) != two.charAt(i))
				return i;
		}
		return min;
	}
	
	private static TreeMap<String,ArrayList<String>> getResult(ArrayList<String> suffixArray){
		
		TreeMap<String,ArrayList<String>> result = new TreeMap<>();
		ArrayList<String> value = new ArrayList<>();
		Collections.sort(suffixArray);
		
		for(String i : suffixArray) {
			value = new ArrayList<>();
			String first = i.substring(0, 1);
			if(result.containsKey(first) && !result.isEmpty()) {
				value = result.get(first);
			}
			i = i.substring(1,i.length());
			value.add(i);
			result.put(first, value);
		}
		
		//update result to find common lcp
		TreeSet<String> toremove = new TreeSet<String>();
		TreeMap<String,ArrayList<String>> result2 = new TreeMap<>();

		for(String i : result.keySet()) {
			ArrayList<String> list = result.get(i);
			Collections.sort(list);
			if(list.size()>1) {
				int minLength = lcp(list.get(0),list.get(1));
				for(int j=2;j<list.size();j++) {
					int tempLength = lcp(list.get(j),list.get(j-1));
					if(tempLength<minLength)
						minLength = tempLength;
				}
				if(minLength > 0) {
					ArrayList<String> newlist = new ArrayList<>();
							
					for(String j : list) 
						newlist.add(j.substring(minLength));
							
					String newkey = i + list.get(0).substring(0, minLength);
							
					toremove.add(i);
					result2.put(newkey, newlist);
				}
			}
		}
				
		if(!toremove.isEmpty()) {
			for(String key : toremove)
				result.remove(key);
		}
		result.putAll(result2);
		
		return result;
	}
	
	private static void getSuffixTree(String input) throws IOException {
		
		ArrayList<String> suffixArray = getSuffixArray(input);
				
		TreeMap<String,ArrayList<String>> result = getResult(suffixArray);

		ArrayList<String> edgeArray = new ArrayList<String>();
		
		while(!result.isEmpty()) {
			//do something
			ArrayList<String> temp = getEdge(result.firstKey(),result.get(result.firstKey()));
			edgeArray.addAll(temp);
			result.remove(result.firstKey());
		}
		
		//Collections.sort(edgeArray);
		BufferedWriter bw = new BufferedWriter(new FileWriter("aa_res.txt"));
		for(String i : edgeArray) {
			bw.write(i);
			bw.newLine();
			//System.out.println(i);
		}
		bw.close();
	}
	
	private static ArrayList<String> getEdge(String key,ArrayList<String> entry){
		ArrayList<String> edges = new ArrayList<>();
		
		if(!entry.isEmpty() && entry.size() > 1) {
			//do something
			edges.add(key);
			TreeMap<String,ArrayList<String>> result = getResult(entry);

			ArrayList<String> edgeArray = new ArrayList<String>();
			
			while(!result.isEmpty()) {
				//do something
				ArrayList<String> temp = getEdge(result.firstKey(),result.get(result.firstKey()));
				edgeArray.addAll(temp);
				result.remove(result.firstKey());
			}
			edges.addAll(edgeArray);
			
		}else {
			if(entry.isEmpty())
				edges.add(key);
			else
				edges.add(key + entry.get(0));
		}

		return edges;
	}
	
	public static void main(String[]args) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("aa.txt"));
		
		String s = "";
		String input = "";
		
		while((s = br.readLine())!= null) 
			input = input + s;
		br.close();
		
		getSuffixTree(input);
	}
}
