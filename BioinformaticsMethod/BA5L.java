package bioinformaticsMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class BA5L {
public static TreeMap<String,Integer> blosum62 = new TreeMap<String,Integer>();
	
	private static String s="";
	private static String t="";
	
	public static void getBlosum62() {
		blosum62.put("AA",4);blosum62.put("AC",0);blosum62.put("AD",-2);blosum62.put("AE",-1);blosum62.put("AF",-2);blosum62.put("AG",0);blosum62.put("AH",-2);blosum62.put("AI",-1);
		blosum62.put("AK",-1);blosum62.put("AL",-1);blosum62.put("AM",-1);blosum62.put("AN",-2);blosum62.put("AP",-1);blosum62.put("AQ",-1);blosum62.put("AR",-1);blosum62.put("AS",1);
		blosum62.put("AT",0);blosum62.put("AV",0);blosum62.put("AW",-3);blosum62.put("AY",-2);blosum62.put("CA",0);blosum62.put("CC",9);blosum62.put("CD",-3);blosum62.put("CE",-4);
		blosum62.put("CF",-2);blosum62.put("CG",-3);blosum62.put("CH",-3);blosum62.put("CI",-1);blosum62.put("CK",-3);blosum62.put("CL",-1);blosum62.put("CM",-1);blosum62.put("CN",-3);
		blosum62.put("CP",-3);blosum62.put("CQ",-3);blosum62.put("CR",-3);blosum62.put("CS",-1);blosum62.put("CT",-1);blosum62.put("CV",-1);blosum62.put("CW",-2);blosum62.put("CY",-2);
		blosum62.put("DA",-2);blosum62.put("DC",-3);blosum62.put("DD",6);blosum62.put("DE",2);blosum62.put("DF",-3);blosum62.put("DG",-1);blosum62.put("DH",-1);
		blosum62.put("DI",-3);blosum62.put("DK",-1);blosum62.put("DL",-4);blosum62.put("DM",-3);blosum62.put("DN",1);blosum62.put("DP",-1);blosum62.put("DQ",0);
		blosum62.put("DR",-2);blosum62.put("DS",0);blosum62.put("DT",-1);blosum62.put("DV",-3);blosum62.put("DW",-4);blosum62.put("DY",-3);blosum62.put("EA",-1);
		blosum62.put("EC",-4);blosum62.put("ED",2);blosum62.put("EE",5);blosum62.put("EF",-3);blosum62.put("EG",-2);blosum62.put("EH",0);blosum62.put("EI",-3);
		blosum62.put("EK",1);blosum62.put("EL",-3);blosum62.put("EM",-2);blosum62.put("EN",0);blosum62.put("EP",-1);blosum62.put("EQ",2);blosum62.put("ER",0);
		blosum62.put("ES",0);blosum62.put("ET",-1);blosum62.put("EV",-2);blosum62.put("EW",-3);blosum62.put("EY",-2);blosum62.put("FA",-2);blosum62.put("FC",-2);
		blosum62.put("FD",-3);blosum62.put("FE",-3);blosum62.put("FF",6);blosum62.put("FG",-3);blosum62.put("FH",-1);blosum62.put("FI",0);blosum62.put("FK",-3);
		blosum62.put("FL",0);blosum62.put("FM",0);blosum62.put("FN",-3);blosum62.put("FP",-4);blosum62.put("FQ",-3);blosum62.put("FR",-3);blosum62.put("FS",-2);
		blosum62.put("FT",-2);blosum62.put("FV",-1);blosum62.put("FW",1);blosum62.put("FY",3);blosum62.put("GA",0);blosum62.put("GC",-3);blosum62.put("GD",-1);
		blosum62.put("GE",-2);blosum62.put("GF",-3);blosum62.put("GG",6);blosum62.put("GH",-2);blosum62.put("GI",-4);blosum62.put("GK",-2);blosum62.put("GL",-4);
		blosum62.put("GM",-3);blosum62.put("GN",0);blosum62.put("GP",-2);blosum62.put("GQ",-2);blosum62.put("GR",-2);blosum62.put("GS",0);blosum62.put("GT",-2);
		blosum62.put("GV",-3);blosum62.put("GW",-2);blosum62.put("GY",-3);blosum62.put("HA",-2);blosum62.put("HC",-3);blosum62.put("HD",-1);blosum62.put("HE",0);
		blosum62.put("HF",-1);blosum62.put("HG",-2);blosum62.put("HH",8);blosum62.put("HI",-3);blosum62.put("HK",-1);blosum62.put("HL",-3);blosum62.put("HM",-2);
		blosum62.put("HN",1);blosum62.put("HP",-2);blosum62.put("HQ",0);blosum62.put("HR",0);blosum62.put("HS",-1);blosum62.put("HT",-2);blosum62.put("HV",-3);
		blosum62.put("HW",-2);blosum62.put("HY",2);blosum62.put("IA",-1);blosum62.put("IC",-1);blosum62.put("ID",-3);blosum62.put("IE",-3);blosum62.put("IF",0);
		blosum62.put("IG",-4);blosum62.put("IH",-3);blosum62.put("II",4);blosum62.put("IK",-3);blosum62.put("IL",2);blosum62.put("IM",1);blosum62.put("IN",-3);
		blosum62.put("IP",-3);blosum62.put("IQ",-3);blosum62.put("IR",-3);blosum62.put("IS",-2);blosum62.put("IT",-1);blosum62.put("IV",3);blosum62.put("IW",-3);
		blosum62.put("IY",-1);blosum62.put("KA",-1);blosum62.put("KC",-3);blosum62.put("KD",-1);blosum62.put("KE",1);blosum62.put("KF",-3);blosum62.put("KG",-2);
		blosum62.put("KH",-1);blosum62.put("KI",-3);blosum62.put("KK",5);blosum62.put("KL",-2);blosum62.put("KM",-1);blosum62.put("KN",0);blosum62.put("KP",-1);
		blosum62.put("KQ",1);blosum62.put("KR",2);blosum62.put("KS",0);blosum62.put("KT",-1);blosum62.put("KV",-2);blosum62.put("KW",-3);blosum62.put("KY",-2);
		blosum62.put("LA",-1);blosum62.put("LC",-1);blosum62.put("LD",-4);blosum62.put("LE",-3);blosum62.put("LF",0);blosum62.put("LG",-4);blosum62.put("LH",-3);
		blosum62.put("LI",2);blosum62.put("LK",-2);blosum62.put("LL",4);blosum62.put("LM",2);blosum62.put("LN",-3);blosum62.put("LP",-3);blosum62.put("LQ",-2);
		blosum62.put("LR",-2);blosum62.put("LS",-2);blosum62.put("LT",-1);blosum62.put("LV",1);blosum62.put("LW",-2);blosum62.put("LY",-1);blosum62.put("MA",-1);
		blosum62.put("MC",-1);blosum62.put("MD",-3);blosum62.put("ME",-2);blosum62.put("MF",0);blosum62.put("MG",-3);blosum62.put("MH",-2);blosum62.put("MI",1);
		blosum62.put("MK",-1);blosum62.put("ML",2);blosum62.put("MM",5);blosum62.put("MN",-2);blosum62.put("MP",-2);blosum62.put("MQ",0);blosum62.put("MR",-1);
		blosum62.put("MS",-1);blosum62.put("MT",-1);blosum62.put("MV",1);blosum62.put("MW",-1);blosum62.put("MY",-1);blosum62.put("NA",-2);blosum62.put("NC",-3);
		blosum62.put("ND",1);blosum62.put("NE",0);blosum62.put("NF",-3);blosum62.put("NG",0);blosum62.put("NH",1);blosum62.put("NI",-3);blosum62.put("NK",0);
		blosum62.put("NL",-3);blosum62.put("NM",-2);blosum62.put("NN",6);blosum62.put("NP",-2);blosum62.put("NQ",0);blosum62.put("NR",0);blosum62.put("NS",1);
		blosum62.put("NT",0);blosum62.put("NV",-3);blosum62.put("NW",-4);blosum62.put("NY",-2);blosum62.put("PA",-1);blosum62.put("PC",-3);blosum62.put("PD",-1);
		blosum62.put("PE",-1);blosum62.put("PF",-4);blosum62.put("PG",-2);blosum62.put("PH",-2);blosum62.put("PI",-3);blosum62.put("PK",-1);blosum62.put("PL",-3);
		blosum62.put("PM",-2);blosum62.put("PN",-2);blosum62.put("PP",7);blosum62.put("PQ",-1);blosum62.put("PR",-2);blosum62.put("PS",-1);blosum62.put("PT",-1);
		blosum62.put("PV",-2);blosum62.put("PW",-4);blosum62.put("PY",-3);blosum62.put("QA",-1);blosum62.put("QC",-3);blosum62.put("QD",0);blosum62.put("QE",2);
		blosum62.put("QF",-3);blosum62.put("QG",-2);blosum62.put("QH",0);blosum62.put("QI",-3);blosum62.put("QK",1);blosum62.put("QL",-2);blosum62.put("QM",0);
		blosum62.put("QN",0);blosum62.put("QP",-1);blosum62.put("QQ",5);blosum62.put("QR",1);blosum62.put("QS",0);blosum62.put("QT",-1);blosum62.put("QV",-2);
		blosum62.put("QW",-2);blosum62.put("QY",-1);blosum62.put("RA",-1);blosum62.put("RC",-3);blosum62.put("RD",-2);blosum62.put("RE",0);blosum62.put("RF",-3);
		blosum62.put("RG",-2);blosum62.put("RH",0);blosum62.put("RI",-3);blosum62.put("RK",2);blosum62.put("RL",-2);blosum62.put("RM",-1);blosum62.put("RN",0);
		blosum62.put("RP",-2);blosum62.put("RQ",1);blosum62.put("RR",5);blosum62.put("RS",-1);blosum62.put("RT",-1);blosum62.put("RV",-3);blosum62.put("RW",-3);
		blosum62.put("RY",-2);blosum62.put("SA",1);blosum62.put("SC",-1);blosum62.put("SD",0);blosum62.put("SE",0);blosum62.put("SF",-2);blosum62.put("SG",0);
		blosum62.put("SH",-1);blosum62.put("SI",-2);blosum62.put("SK",0);blosum62.put("SL",-2);blosum62.put("SM",-1);blosum62.put("SN",1);blosum62.put("SP",-1);
		blosum62.put("SQ",0);blosum62.put("SR",-1);blosum62.put("SS",4);blosum62.put("ST",1);blosum62.put("SV",-2);blosum62.put("SW",-3);blosum62.put("SY",-2);
		blosum62.put("TA",0);blosum62.put("TC",-1);blosum62.put("TD",-1);blosum62.put("TE",-1);blosum62.put("TF",-2);blosum62.put("TG",-2);blosum62.put("TH",-2);
		blosum62.put("TI",-1);blosum62.put("TK",-1);blosum62.put("TL",-1);blosum62.put("TM",-1);blosum62.put("TN",0);blosum62.put("TP",-1);blosum62.put("TQ",-1);
		blosum62.put("TR",-1);blosum62.put("TS",1);blosum62.put("TT",5);blosum62.put("TV",0);blosum62.put("TW",-2);blosum62.put("TY",-2);blosum62.put("VA",0);
		blosum62.put("VC",-1);blosum62.put("VD",-3);blosum62.put("VE",-2);blosum62.put("VF",-1);blosum62.put("VG",-3);blosum62.put("VH",-3);blosum62.put("VI",3);
		blosum62.put("VK",-2);blosum62.put("VL",1);blosum62.put("VM",1);blosum62.put("VN",-3);blosum62.put("VP",-2);blosum62.put("VQ",-2);blosum62.put("VR",-3);
		blosum62.put("VS",-2);blosum62.put("VT",0);blosum62.put("VV",4);blosum62.put("VW",-3);blosum62.put("VY",-1);blosum62.put("WA",-3);blosum62.put("WC",-2);
		blosum62.put("WD",-4);blosum62.put("WE",-3);blosum62.put("WF",1);blosum62.put("WG",-2);blosum62.put("WH",-2);blosum62.put("WI",-3);blosum62.put("WK",-3);
		blosum62.put("WL",-2);blosum62.put("WM",-1);blosum62.put("WN",-4);blosum62.put("WP",-4);blosum62.put("WQ",-2);blosum62.put("WR",-3);blosum62.put("WS",-3);
		blosum62.put("WT",-2);blosum62.put("WV",-3);blosum62.put("WW",11);blosum62.put("WY",2);blosum62.put("YA",-2);blosum62.put("YC",-2);blosum62.put("YD",-3);
		blosum62.put("YE",-2);blosum62.put("YF",3);blosum62.put("YG",-3);blosum62.put("YH",2);blosum62.put("YI",-1);blosum62.put("YK",-2);blosum62.put("YL",-1);
		blosum62.put("YM",-1);blosum62.put("YN",-2);blosum62.put("YP",-3);blosum62.put("YQ",-1);blosum62.put("YR",-2);blosum62.put("YS",-2);blosum62.put("YT",-2);blosum62.put("YV",-1);blosum62.put("YW",2);blosum62.put("YY",7);
	}
	
	public static void getSequence(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		String p;
		String temp="";
		
		while((p=br.readLine()) != null) {
			if(p.startsWith(">")) {
				s = temp;
				temp = "";
			}else {
				temp += p;
			}
		}
		t = temp;
		br.close();
		
	}

	public static void editDistanceAlignment() {
	    int cost = -5;
	    int leftCell;
	    int topCell;
	    int cornerCell;
	    int m = s.length()+1;
	    int n = t.length()+1;
	    
	    int[][] T = new int[m][n];
	    int[][] backtrack = new int[m][n];
	    
	    for(int i = 1; i < m; ++i) {
	      T[i][0] = T[i-1][0] + cost;
	    }
	    for(int j = 1; j < n; ++j) {
	      T[0][j] = T[0][j-1] + cost;
	    }
	    
	    for(int i = 1; i < m; ++i) {
	      for(int j = 1; j < n; ++j) {
	        leftCell = T[i][j-1] + cost;
	        topCell = T[i-1][j] + cost;
	        String prot = s.charAt(i-1) + "" + t.charAt(j-1);
	        cornerCell = T[i-1][j-1] + blosum62.get(prot);
	        
	        T[i][j] = leftCell;
	        backtrack[i][j] = 1;
	        if(topCell > T[i][j]) {
	          T[i][j] = topCell;
	          backtrack[i][j] = 2;
	        }
	        if(cornerCell > T[i][j]) {
	          T[i][j] = cornerCell;
	          backtrack[i][j] = 3;
	        }
	      }
	    }
	    
	    String align1 = "";
	    String align2 = "";
	    
	    int i = m-1;
	    int j = n-1;
	    
	    while(i != 0 || j != 0) {
	    	if(backtrack[i][j] == 1) {
	    		align1 = "-" + align1;
	    		align2 = t.charAt(j-1) + align2;
	    		j--;
	    	}else if(backtrack[i][j] == 2) {
	    		align1 = s.charAt(i-1) + align1;
	    		align2 = "-" + align2;
	    		i--;
	    	}else if(backtrack[i][j] == 3) {
	    		align1 = s.charAt(i-1) + align1;
	    		align2 = t.charAt(j-1) + align2;
	    		i--;j--;
	    	}else {
	    		if(i<=0) {
	    			align1 = "-" + align1;
		    		align2 = t.charAt(j-1) + align2;
		    		i=0;
	    			j--;
	    		}else if(j<=0) {
	    			align1 = s.charAt(i-1) + align1;
		    		align2 = "-" + align2;
		    		j=0;
	    			i--;
	    		}
	    	}
	    	
	    }
	    
	    System.out.println(T[m-1][n-1]);
	    System.out.println(align1);
	    System.out.println(align2);
	}
	
	public static void main(String[]args) throws IOException{
		getBlosum62();
		getSequence("aa.txt");
		editDistanceAlignment();
	}
}
