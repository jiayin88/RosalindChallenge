package algorithmicTextbookTrack;

public class BA1N {
	public static void main(String[]args){
		String dna = "TGAGAGCAACA";
		int n = dna.length();
		int diff = 3;
		
		System.out.println(n);
		
		String[] nucleotide = {"A","C","G","T"};
		String[] kMer = new String[(int) Math.pow(4, n)];
		int num = 0;
	
		for(int a=0;a<4;a++)//1
			for(int b=0;b<4;b++)//2
				for(int c=0;c<4;c++)//3
					for(int d=0;d<4;d++)//4
						for(int e=0;e<4;e++)//5
							for(int f=0;f<4;f++)//6
								for(int g=0;g<4;g++)//7
									for(int h=0;h<4;h++)//8
										for(int i=0;i<4;i++)//9
											for(int j=0;j<4;j++)//10
												for(int k=0;k<4;k++)//10
											{
				//								kMer[num] = nucleotide[a]+nucleotide[b]+nucleotide[c]+nucleotide[d]+nucleotide[e]+nucleotide[f]+nucleotide[g]+nucleotide[h];
												kMer[num] = nucleotide[a]+nucleotide[b]+nucleotide[c]+nucleotide[d]+nucleotide[e]+nucleotide[f]+nucleotide[g]+nucleotide[h]+nucleotide[i]+nucleotide[j]+nucleotide[k];
												num++;
											}
		
		char[] dna1 = dna.toCharArray();
		
		for (int i1=0;i1<kMer.length;i1++){
			char[] dna2 = kMer[i1].toCharArray();
			int count = 0;
			for(int j1=0; j1<dna1.length;j1++){
				if(dna1[j1] != dna2[j1]){
					count++;
				}	
			}
			if(count<=diff){
				System.out.println(kMer[i1]);
			}
		}
		
		
	}

}
