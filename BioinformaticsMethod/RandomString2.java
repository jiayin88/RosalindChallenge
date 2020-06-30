package algorithmicTextbookTrack;

import java.text.DecimalFormat;

public class RandomString2 {
	public static void main(String[]args){
		int N = 84136;
		double probGC = 0.461387;
		String dna = "ACTGAGAAA";
		
		int GCcount = 0;
		int ATcount = 0;
		
		for(int i=0;i<dna.length();i++){
			if(dna.charAt(i)== 'A' || dna.charAt(i)== 'T'){
				ATcount++;
			}
			if(dna.charAt(i)== 'C' || dna.charAt(i)== 'G'){
				GCcount++;
			}
		}
		
		double GC = probGC/2;
		double AT = (1-probGC)/2;
		
		double total = 1-(Math.pow(GC, GCcount)*(Math.pow(AT, ATcount)));
		double result = 1-(Math.pow(total, N));
		DecimalFormat df = new DecimalFormat("#.###");
		String format = df.format(result);
		System.out.println(format);
	}

}
