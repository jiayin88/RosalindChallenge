package algorithmicTextbookTrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;


/*Given: 2 amino acid sequence
 * Return: The maximum alignment score of these strings followed by an alignment achieving this maximum score.
 * Use the BLOSUM62 scoring matrix and indel penalty = 5.
 * If multiple alignments achieving the maximum score exist, you may return any one.
 * */
public class BA5E {
	
	public static int BLOSUM62(String seq){
		/*To use:
		 *int number = BLOSUM62(seq);
		}
		*/
		//A  C  D  E  F  G  H  I  K  L  M  N  P  Q  R  S  T  V  W  Y
		Hashtable<String, String> b62Matrix = new Hashtable<String, String>();
		
		b62Matrix.put("AA","4"); b62Matrix.put("AC","0"); b62Matrix.put("AD","-2");
		b62Matrix.put("AE","-1"); b62Matrix.put("AF","-2"); b62Matrix.put("AG","0"); 
		b62Matrix.put("AH","-2"); b62Matrix.put("AI","-1"); b62Matrix.put("AK","-1");
		b62Matrix.put("AL","-1"); b62Matrix.put("AM","-1"); b62Matrix.put("AN","-2");
		b62Matrix.put("AP","-1"); b62Matrix.put("AQ","-1"); b62Matrix.put("AR","-1");
		b62Matrix.put("AS","1"); b62Matrix.put("AT","0"); b62Matrix.put("AV","0"); 
		b62Matrix.put("AW","-3"); b62Matrix.put("AY","-2");
		
		b62Matrix.put("CA","0"); b62Matrix.put("CC","9"); b62Matrix.put("CD","-3");
		b62Matrix.put("CE","-4"); b62Matrix.put("CF","-2"); b62Matrix.put("CG","-3"); 
		b62Matrix.put("CH","-3"); b62Matrix.put("CI","-1"); b62Matrix.put("CK","-3");
		b62Matrix.put("CL","-1"); b62Matrix.put("CM","-1"); b62Matrix.put("CN","-3");
		b62Matrix.put("CP","-3"); b62Matrix.put("CQ","-3"); b62Matrix.put("CR","-3");
		b62Matrix.put("CS","-1"); b62Matrix.put("CT","-1"); b62Matrix.put("CV","-1");
		b62Matrix.put("CW","-2"); b62Matrix.put("CY","-2");
		
		b62Matrix.put("DA","-2"); b62Matrix.put("DC","-3"); b62Matrix.put("DD","6");
		b62Matrix.put("DE","2"); b62Matrix.put("DF","-3"); b62Matrix.put("DG","-1"); 
		b62Matrix.put("DH","-1"); b62Matrix.put("DI","-3"); b62Matrix.put("DK","-1");
		b62Matrix.put("DL","-4"); b62Matrix.put("DM","-3"); b62Matrix.put("DN","1");
		b62Matrix.put("DP","-1"); b62Matrix.put("DQ","0"); b62Matrix.put("DR","-2");
		b62Matrix.put("DS","0"); b62Matrix.put("DT","-1"); 
		b62Matrix.put("DV","-3"); b62Matrix.put("DW","-4"); b62Matrix.put("DY","-3");
		
		b62Matrix.put("EA","-1"); b62Matrix.put("EC","-4"); b62Matrix.put("ED","2");
		b62Matrix.put("EE","5"); b62Matrix.put("EF","-3"); b62Matrix.put("EG","-2"); 
		b62Matrix.put("EH","0"); b62Matrix.put("EI","-3"); b62Matrix.put("EK","1");
		b62Matrix.put("EL","-3"); b62Matrix.put("EM","-2"); b62Matrix.put("EN","0");
		b62Matrix.put("EP","-1"); b62Matrix.put("EQ","2"); b62Matrix.put("ER","0");
		b62Matrix.put("ES","0"); b62Matrix.put("ET","-1"); 
		b62Matrix.put("EV","-2"); b62Matrix.put("EW","-3"); b62Matrix.put("EY","-2");
		
		b62Matrix.put("FA","-2"); b62Matrix.put("FC","-2"); b62Matrix.put("FD","-3");
		b62Matrix.put("FE","-3"); b62Matrix.put("FF","6"); b62Matrix.put("FG","-3"); 
		b62Matrix.put("FH","-1"); b62Matrix.put("FI","0"); b62Matrix.put("FK","-3");
		b62Matrix.put("FL","0"); b62Matrix.put("FM","0"); b62Matrix.put("FN","-3");
		b62Matrix.put("FP","-4"); b62Matrix.put("FQ","-3"); b62Matrix.put("FR","-3");
		b62Matrix.put("FS","-2"); b62Matrix.put("FT","-2");
		b62Matrix.put("FV","-1"); b62Matrix.put("FW","1"); b62Matrix.put("FY","3");
		
		b62Matrix.put("GA","0"); b62Matrix.put("GC","-3"); b62Matrix.put("GD","-1");
		b62Matrix.put("GE","-2"); b62Matrix.put("GF","-3"); b62Matrix.put("GG","6"); 
		b62Matrix.put("GH","-2"); b62Matrix.put("GI","-4"); b62Matrix.put("GK","-2");
		b62Matrix.put("GL","-4"); b62Matrix.put("GM","-3"); b62Matrix.put("GN","0");
		b62Matrix.put("GP","-2"); b62Matrix.put("GQ","-2"); b62Matrix.put("GR","-2");
		b62Matrix.put("GS","0"); b62Matrix.put("GT","-2");
		b62Matrix.put("GV","-3"); b62Matrix.put("GW","-2"); b62Matrix.put("GY","-3");
		
		b62Matrix.put("HA","-2"); b62Matrix.put("HC","-3"); b62Matrix.put("HD","-1");
		b62Matrix.put("HE","0"); b62Matrix.put("HF","-1"); b62Matrix.put("HG","-2"); 
		b62Matrix.put("HH","8"); b62Matrix.put("HI","-3"); b62Matrix.put("HK","-1");
		b62Matrix.put("HL","-3"); b62Matrix.put("HM","-2"); b62Matrix.put("HN","1");
		b62Matrix.put("HP","-2"); b62Matrix.put("HQ","0"); b62Matrix.put("HR","0");
		b62Matrix.put("HS","-1"); b62Matrix.put("HT","-2");
		b62Matrix.put("HV","-3"); b62Matrix.put("HW","-2"); b62Matrix.put("HY","-2");
		
		b62Matrix.put("IA","-1"); b62Matrix.put("IC","-1"); b62Matrix.put("ID","-3");
		b62Matrix.put("IE","-3"); b62Matrix.put("IF","0"); b62Matrix.put("IG","-4"); 
		b62Matrix.put("IH","-3"); b62Matrix.put("II","4"); b62Matrix.put("IK","-3");
		b62Matrix.put("IL","2"); b62Matrix.put("IM","1"); b62Matrix.put("IN","-3");
		b62Matrix.put("IP","-3"); b62Matrix.put("IQ","-3"); b62Matrix.put("IR","-3");
		b62Matrix.put("IS","-2"); b62Matrix.put("IT","-1"); 
		b62Matrix.put("IV","3"); b62Matrix.put("IW","-3"); b62Matrix.put("IY","-1");
		
		b62Matrix.put("KA","-1"); b62Matrix.put("KC","-3"); b62Matrix.put("KD","-1");
		b62Matrix.put("KE","1"); b62Matrix.put("KF","-3"); b62Matrix.put("KG","-2"); 
		b62Matrix.put("KH","-1"); b62Matrix.put("KI","-3"); b62Matrix.put("KK","5");
		b62Matrix.put("KL","-2"); b62Matrix.put("KM","-1"); b62Matrix.put("KN","0");
		b62Matrix.put("KP","-1"); b62Matrix.put("KQ","1"); b62Matrix.put("KR","2");
		b62Matrix.put("KS","0"); b62Matrix.put("KT","-1");
		b62Matrix.put("KV","-2"); b62Matrix.put("KW","-3"); b62Matrix.put("KY","-2");
		
		b62Matrix.put("LA","-1"); b62Matrix.put("LC","-1"); b62Matrix.put("LD","-4");
		b62Matrix.put("LE","-3"); b62Matrix.put("LF","0"); b62Matrix.put("LG","-4"); 
		b62Matrix.put("LH","-3"); b62Matrix.put("LI","2"); b62Matrix.put("LK","-2");
		b62Matrix.put("LL","4"); b62Matrix.put("LM","2"); b62Matrix.put("LN","-3");
		b62Matrix.put("LP","-3"); b62Matrix.put("LQ","-2"); b62Matrix.put("LR","-2");
		b62Matrix.put("LS","-2"); b62Matrix.put("LT","-1");
		b62Matrix.put("LV","1"); b62Matrix.put("LW","-2"); b62Matrix.put("LY","-1");
		
		b62Matrix.put("MA","-1"); b62Matrix.put("MC","-1"); b62Matrix.put("MD","-3");
		b62Matrix.put("ME","-2"); b62Matrix.put("MF","0"); b62Matrix.put("MG","-3"); 
		b62Matrix.put("MH","-2"); b62Matrix.put("MI","1"); b62Matrix.put("MK","-1");
		b62Matrix.put("ML","2"); b62Matrix.put("MM","5"); b62Matrix.put("MN","-2");
		b62Matrix.put("MP","-2"); b62Matrix.put("MQ","0"); b62Matrix.put("MR","-1");
		b62Matrix.put("MS","-1"); b62Matrix.put("MT","-1"); 
		b62Matrix.put("MV","1"); b62Matrix.put("MW","-1"); b62Matrix.put("MY","-1");
		
		b62Matrix.put("NA","-2"); b62Matrix.put("NC","-3"); b62Matrix.put("ND","1");
		b62Matrix.put("NE","0"); b62Matrix.put("NF","-3"); b62Matrix.put("NG","0"); 
		b62Matrix.put("NH","1"); b62Matrix.put("NI","-3"); b62Matrix.put("NK","0");
		b62Matrix.put("NL","-3"); b62Matrix.put("NM","-2"); b62Matrix.put("NN","6");
		b62Matrix.put("NP","-2"); b62Matrix.put("NQ","0"); b62Matrix.put("NR","0");
		b62Matrix.put("NS","1"); b62Matrix.put("NT","0");
		b62Matrix.put("NV","-3"); b62Matrix.put("NW","-4"); b62Matrix.put("NY","-2");
		
		b62Matrix.put("PA","-1"); b62Matrix.put("PC","-3"); b62Matrix.put("PD","-1");
		b62Matrix.put("PE","-1"); b62Matrix.put("PF","-4"); b62Matrix.put("PG","-2"); 
		b62Matrix.put("PH","-2"); b62Matrix.put("PI","-3"); b62Matrix.put("PK","-1");
		b62Matrix.put("PL","-3"); b62Matrix.put("PM","-2"); b62Matrix.put("PN","-2");
		b62Matrix.put("PP","7"); b62Matrix.put("PQ","-1"); b62Matrix.put("PR","-2");
		b62Matrix.put("PS","-1"); b62Matrix.put("PT","-1"); 
		b62Matrix.put("PV","-2"); b62Matrix.put("PW","-4"); b62Matrix.put("PY","-3");
		
		b62Matrix.put("QA","-1"); b62Matrix.put("QC","-3"); b62Matrix.put("QD","0");
		b62Matrix.put("QE","2"); b62Matrix.put("QF","-3"); b62Matrix.put("QG","-2"); 
		b62Matrix.put("QH","0"); b62Matrix.put("QI","-3"); b62Matrix.put("QK","1");
		b62Matrix.put("QL","-2"); b62Matrix.put("QM","0"); b62Matrix.put("QN","0");
		b62Matrix.put("QP","-1"); b62Matrix.put("QQ","5"); b62Matrix.put("QR","1");
		b62Matrix.put("QS","0"); b62Matrix.put("QT","-1");
		b62Matrix.put("QV","-2"); b62Matrix.put("QW","-2"); b62Matrix.put("QY","-1");
		
		b62Matrix.put("RA","-1"); b62Matrix.put("RC","-3"); b62Matrix.put("RD","-2");
		b62Matrix.put("RE","0"); b62Matrix.put("RF","-3"); b62Matrix.put("RG","-2"); 
		b62Matrix.put("RH","0"); b62Matrix.put("RI","-3"); b62Matrix.put("RK","2");
		b62Matrix.put("RL","-2"); b62Matrix.put("RM","-1"); b62Matrix.put("RN","0");
		b62Matrix.put("RP","-2"); b62Matrix.put("RQ","1"); b62Matrix.put("RR","5");
		b62Matrix.put("RS","-1"); b62Matrix.put("RT","-1");
		b62Matrix.put("RV","-3"); b62Matrix.put("RW","-3"); b62Matrix.put("RY","-2");
		
		b62Matrix.put("SA","1"); b62Matrix.put("SC","-1"); b62Matrix.put("SD","0");
		b62Matrix.put("SE","0"); b62Matrix.put("SF","-2"); b62Matrix.put("SG","0"); 
		b62Matrix.put("SH","-1"); b62Matrix.put("SI","-2"); b62Matrix.put("SK","0");
		b62Matrix.put("SL","-2"); b62Matrix.put("SM","-1"); b62Matrix.put("SN","1");
		b62Matrix.put("SP","-1"); b62Matrix.put("SQ","0"); b62Matrix.put("SR","-1");
		b62Matrix.put("SS","4"); b62Matrix.put("ST","1");
		b62Matrix.put("SV","-2"); b62Matrix.put("SW","-3"); b62Matrix.put("SY","-2");
		
		b62Matrix.put("TA","0"); b62Matrix.put("TC","-1"); b62Matrix.put("TD","-1");
		b62Matrix.put("TE","-1"); b62Matrix.put("TF","-2"); b62Matrix.put("TG","-2"); 
		b62Matrix.put("TH","-2"); b62Matrix.put("TI","-1"); b62Matrix.put("TK","-1");
		b62Matrix.put("TL","-1"); b62Matrix.put("TM","-1"); b62Matrix.put("TN","0");
		b62Matrix.put("TP","-1"); b62Matrix.put("TQ","-1"); b62Matrix.put("TR","-1");
		b62Matrix.put("TS","1"); b62Matrix.put("TT","5");
		b62Matrix.put("TV","0"); b62Matrix.put("TW","-2"); b62Matrix.put("TY","-2");
		
		b62Matrix.put("VA","0"); b62Matrix.put("VC","-1"); b62Matrix.put("VD","-3");
		b62Matrix.put("VE","-2"); b62Matrix.put("VF","-1"); b62Matrix.put("VG","-3"); 
		b62Matrix.put("VH","-3"); b62Matrix.put("VI","3"); b62Matrix.put("VK","-2");
		b62Matrix.put("VL","1"); b62Matrix.put("VM","1"); b62Matrix.put("VN","-3");
		b62Matrix.put("VP","-2"); b62Matrix.put("VQ","-2"); b62Matrix.put("VR","-3");
		b62Matrix.put("VS","-2"); b62Matrix.put("VT","0"); 
		b62Matrix.put("VV","4"); b62Matrix.put("VW","-3"); b62Matrix.put("VY","-1");
		
		b62Matrix.put("WA","-3"); b62Matrix.put("WC","-2"); b62Matrix.put("WD","-4");
		b62Matrix.put("WE","-3"); b62Matrix.put("WF","1"); b62Matrix.put("WG","-2"); 
		b62Matrix.put("WH","-2"); b62Matrix.put("WI","-3"); b62Matrix.put("WK","-3");
		b62Matrix.put("WL","-2"); b62Matrix.put("WM","-1"); b62Matrix.put("WN","-4");
		b62Matrix.put("WP","-4"); b62Matrix.put("WQ","-2"); b62Matrix.put("WR","-3");
		b62Matrix.put("WS","-3"); b62Matrix.put("WT","-2");
		b62Matrix.put("WV","-3"); b62Matrix.put("WW","11"); b62Matrix.put("WY","2");
		
		b62Matrix.put("YA","-2"); b62Matrix.put("YC","-2"); b62Matrix.put("YD","-3");
		b62Matrix.put("YE","-2"); b62Matrix.put("YF","3"); b62Matrix.put("YG","-3"); 
		b62Matrix.put("YH","2"); b62Matrix.put("YI","-1"); b62Matrix.put("YK","-2");
		b62Matrix.put("YL","-1"); b62Matrix.put("YM","-1"); b62Matrix.put("YN","-2");
		b62Matrix.put("YP","-3"); b62Matrix.put("YQ","-1"); b62Matrix.put("YR","-2");
		b62Matrix.put("YS","-2"); b62Matrix.put("YT","-2");
		b62Matrix.put("YV","-1"); b62Matrix.put("YW","2"); b62Matrix.put("YY","7");
		
		String convert = b62Matrix.get(seq);
		int num;
		if(convert.charAt(0) == '-'){
			num = Integer.parseInt(convert.substring(1));
			num = -num;
		}
		else
			num = Integer.parseInt(convert);
		return num;
	}
	
	public static void main(String[]args) throws IOException{
		
		int indel = 5;
		
		
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
		
		//System.out.println(lookUp[0][seq1.length-1]);
		//to do the nestled loops to fill in the blanks in the tables
		//Direction: 4 = diagonal; 5 = up; 6 = right
		for(int x=1;x<(seq2.length+1);x++){
			for(int y=1;y<(seq1.length+1);y++){
				String check = seq2[x-1] + seq1[y-1];
				//System.out.println(check);
				int numUp = lookUp[x-1][y] - indel;
				int numRight = lookUp[x][y-1] - indel;
				int numDiagonal = lookUp[x-1][y-1] + BLOSUM62(check);
				
				//System.out.print(numDiagonal);
				if(numDiagonal >= numUp){
					if(numDiagonal >= numRight){
						lookUp[x][y] = numDiagonal;
						direction[x][y] = 4;
						//System.out.print("d");
						//System.out.print(numDiagonal);
					}else{
						lookUp[x][y] = numRight;
						direction[x][y] = 6;
						//System.out.print("r");
						//System.out.print(numRight);
					}
				}
				else {
					if(numUp >= numRight){
						lookUp[x][y] = numUp;
						direction[x][y] = 5;
						//System.out.print("u");
						//System.out.print(numUp);
					}else{
						lookUp[x][y] = numRight;
						direction[x][y] = 6;
						//System.out.print("r");
						//System.out.print(numRight);
					}
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
		
		
		int result=0;
		for(int i=0;i<finalseq1.length();i++){
			if(finalseq1.charAt(i)== '-' || finalseq2.charAt(i)== '-'){
				result = result - indel;
			}else{
				String tempSeq = finalseq1.substring(i,i+1) + finalseq2.substring(i,i+1);
				result = result + BLOSUM62(tempSeq);
			}
		}
		
		System.out.println(result);
		System.out.println(lookUp[seq2.length][seq1.length]);
		System.out.println(new StringBuffer(finalseq1).reverse().toString());
		System.out.println(new StringBuffer(finalseq2).reverse().toString());
		
		br.close();
	}

}
