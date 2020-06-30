package algorithmicTextbookTrack;

public class ChangeProblem {
	public static void main(String[]args){
		int number = 17118;
		int[] arrayChange = {24,10,7,5,3,1};
		
		//to identify the highest change
		int highest = 0;
		for(int i : arrayChange){
			if(i > highest)
				highest = i;
		}
		
		System.out.println("Highest : " + highest);
		//to find the change for the first few where result >= highest/2
		int min = Math.floorDiv(highest, 2);
		int ptChange = 0; //act as a pointer
		int resultChange = number; //set it to the biggest change needed
		
		for(int i : arrayChange){
			if(i >= min){
				int temp = Math.floorDiv(number, i);
				if((number%i) == 0){
					resultChange = number/i;
					System.out.println(resultChange);
					System.exit(0);
				}else{
					if(temp <= resultChange){
						ptChange = i;
						resultChange = Math.floorDiv(number, i);
					}
				}
			}
		}
		
			int balance = number - (ptChange * resultChange);
			System.out.println("Current balance :" + balance);
			System.out.println("Current change value :" + resultChange);
			//identify the pointer's value in the arrayChange
			for(int i : arrayChange){
				if(i == ptChange || (balance + i) == number || (balance + i) > number){
					//System.out.println(i);
					continue;
				}
				else{
					if(balance%i == 0){
						resultChange = resultChange + balance/i;
						break;
					}else{
						int temp = Math.floorDiv(balance, i);
						resultChange = resultChange + temp;
						balance = balance - (temp*i);
					}
				}
			}
			System.out.println("Minimum change : " + resultChange);
	}
}
