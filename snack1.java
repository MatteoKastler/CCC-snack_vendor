import java.util.Scanner;

public class snack1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int [] input = null;
		int[] coinValues = new int[]{
				200, 100, 50, 20, 10, 5, 2, 1
		};
		
		try{
			String[] stringputs = in.nextLine().split(" ");
			input = new int[stringputs.length];
			
			for(int i = 0; i < stringputs.length; i++){
				input[i] = Integer.parseInt(stringputs[i]);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		int coins = 0;
		
		
		for(int i = 0; i < input[1]; i++){
			coins += input[i+2];
		}
		
		int missing = input[0] - coins;
		int changeOnCrack = missing*-1;
		
		int[] coinsAmount = new int[8];
		
		while(changeOnCrack > 0 ){
			for(int i = 0; i < coinValues.length; i++){
				coinsAmount[i] = (int) (changeOnCrack / coinValues[i]);
				changeOnCrack -= coinsAmount[i]*coinValues[i];
			}
		}
		
		if(missing < 0){
			System.out.print("CHANGE ");
			for(int i = coinsAmount.length-1; i >= 0; i--){
				System.out.print(coinsAmount[i] + " ");
			}
		} else {
			System.out.println("MISSING " + missing);
		}
		
		
		
		in.close();
	}
}
