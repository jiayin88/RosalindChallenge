package bioinformaticsMethod;

import java.io.*;
import java.util.*;

public class BA3L {

	
	
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("aa.txt"));
		
		String s = "";
		String[] split = br.readLine().split(" ");
		int k = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		
		s = br.readLine();
		split = s.split("\\|");
		String head = split[0];
		String tail = split[1];
		
		Queue<String> st = new LinkedList<String>();
		while((s=br.readLine())!= null) {
			split = s.split("\\|");
			String one = split[0].substring(0,split[0].length()-1);
			String two = split[0].substring(1,split[0].length());
			if(head.endsWith(one)) {
				head = head + split[0].charAt(split[0].length()-1);
				tail = tail + split[1].charAt(split[1].length()-1);
			}else if(head.startsWith(two)) {
				head = split[0].charAt(0) + head;
				tail = split[1].charAt(0) + tail;
			}else {
				st.add(s);
			}
		}
		br.close();
		System.out.println(head + "\n" + tail);
						
		while(!st.isEmpty()) {
			String a = st.remove();
			split = a.split("\\|");
			String one = split[0].substring(0,split[0].length()-1);
			String two = split[0].substring(1,split[0].length());
			
			if(head.endsWith(one)) {
				head = head + split[0].substring(split[0].length()-1);
				tail = tail + split[1].substring(split[1].length()-1);
			}else if(head.startsWith(two)) {
				head = split[0].charAt(0) + head;
				tail = split[1].charAt(0) + tail;
			}else {
				st.add(a);
			}	
		}
		
		String seq = head.substring(0,k+m) + tail;
		System.out.println(seq);
	}

}
