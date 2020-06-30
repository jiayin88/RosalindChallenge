package algorithmicTextbookTrack;

public class BA5B {
	public static void main(String[]args){
	
		int n = 18;
		int m = 10;
		
		int down [][] = { // n x (m+1)
				{2, 1, 2, 2, 0, 2, 2, 2, 3, 3, 1 },
				{4, 2, 3, 3, 2, 2, 0, 0, 3, 3, 0 },
				{0, 2, 1, 4, 0, 1, 1, 2, 3, 3, 1 },
				{3, 0, 1, 4, 1, 1, 4, 4, 2, 1, 1 },
				{2, 1, 3, 4, 1, 2, 3, 0, 1, 1, 2 },
				{3, 0, 3, 3, 0, 0, 1, 3, 4, 2, 1 },
				{4, 1, 2, 3, 2, 0, 0, 2, 4, 3, 2 },
				{1, 0, 3, 4, 3, 1, 2, 2, 3, 2, 3 },
				{4, 1, 4, 0, 2, 3, 4, 0, 4, 3, 2 },
				{3, 0, 3, 2, 0, 0, 2, 2, 1, 4, 2 },
				{3, 2, 1, 0, 0, 3, 4, 4, 1, 0, 1 },
				{1, 4, 4, 2, 4, 1, 3, 4, 0, 3, 3 },
				{3, 1, 1, 2, 0, 4, 4, 2, 0, 3, 3 },
				{0, 3, 3, 4, 0, 3, 4, 4, 2, 0, 3 },
				{4, 4, 4, 0, 0, 4, 0, 4, 4, 0, 2 },
				{4, 0, 4, 4, 1, 1, 1, 4, 2, 3, 2 },
				{4, 4, 1, 1, 2, 1, 2, 4, 0, 4, 2 },
				{2, 3, 3, 2, 0, 1, 0, 4, 0, 2, 3 }
						};
		
		int right[][] = { //(n+1) x m
				{4, 2, 0, 2, 4, 1, 3, 0, 2, 0 },
				{2, 4, 0, 1, 0, 0, 4, 4, 0, 3 },
				{1, 2, 2, 4, 1, 3, 3, 3, 0, 1 },
				{2, 2, 2, 0, 2, 2, 4, 4, 4, 1 },
				{1, 2, 1, 2, 2, 0, 1, 2, 4, 0 },
				{2, 0, 0, 4, 4, 0, 1, 3, 0, 0 },
				{1, 2, 0, 1, 4, 3, 1, 4, 2, 0 },
				{0, 1, 4, 3, 1, 2, 2, 3, 3, 0 },
				{3, 1, 4, 2, 4, 1, 0, 4, 1, 2 },
				{1, 2, 0, 2, 3, 3, 3, 0, 0, 4 },
				{1, 1, 4, 3, 0, 1, 4, 1, 1, 0 },
				{4, 4, 1, 2, 1, 2, 0, 2, 4, 2 },
				{4, 4, 4, 4, 4, 2, 2, 4, 4, 3 },
				{3, 1, 3, 3, 0, 3, 1, 0, 4, 1 },
				{1, 3, 1, 2, 3, 1, 2, 1, 4, 1 },
				{3, 4, 2, 4, 1, 3, 0, 4, 3, 0 },
				{0, 2, 4, 2, 4, 1, 0, 3, 1, 2 },
				{1, 4, 2, 3, 0, 4, 3, 4, 4, 2 },
				{4, 0, 0, 4, 0, 3, 0, 0, 4, 3 }
						};
		
		int result [][] = new int[n+1][m+1];
		
		//initialize first columns
		int temp = 0;
		for(int i=1;i<(n+1);i++){
			temp = temp + down[i-1][0];
			result[i][0] = temp;
		}
		//System.out.println(result[n][0]);
		
		//initialize first rows
		temp = 0;
		for(int j=1;j<(m+1);j++){
			temp = temp + right[0][j-1];
			result[0][j] = temp;
		}
		//System.out.println(result[0][m]);
		
		for(int i=1;i<(n+1);i++){
			for(int j=1;j<(m+1);j++){
				int numDown = result[i-1][j] + down[i-1][j];
				int numRight = result[i][j-1] + right[i][j-1];
				
				if(numDown>numRight)
					result[i][j] = numDown;
				else
					result[i][j] = numRight;
			}
		}
		System.out.println(result[n][m]);
	}
}