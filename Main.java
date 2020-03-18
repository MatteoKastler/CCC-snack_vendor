import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String [] inputArr = getInput();
		Product [][] snackMatrix = new Product [inputArr[0].charAt(0)-'A'+1][Integer.parseInt(inputArr[0].substring(1))];
		//stelle im input array
		int x = 0;
		
		for(int i = 0; i < snackMatrix.length; i++){
			for(int j = 0; j < snackMatrix[i].length; j++){
				x++;
				snackMatrix[i][j] = new Product(0, strToInt(inputArr[x]));
			}
			
		}
		for(int i = 0; i < snackMatrix.length; i++){
			for(int j = 0; j < snackMatrix[i].length; j++){
				x++;
				snackMatrix[i][j].setStock(strToInt(inputArr[x]));
			}
			
		}
		
		x++;
		
		int amountOrders = strToInt(inputArr[x]);
		int income = 0;

		System.out.println(amountOrders);
		for(int i = 0; i < amountOrders; i++){
			x++;
			int [] usrChoice = new int[2];
			usrChoice[0] = inputArr[x].charAt(0)-'A';
			usrChoice[1] = strToInt(inputArr[x].substring(1))-1;
			
			try{
				snackMatrix[usrChoice[0]] [usrChoice[1]].sell(1);
				income += snackMatrix[usrChoice[0]] [usrChoice[1]].price;
			}catch(RuntimeException e){
				
			}
		}
		System.out.println(income);
		
//		 x = stelle, an der 
//		usrChoice[0] = inputArr[x].charAt(0)-'A';
//		usrChoice[1] = strToInt(inputArr[x].substring(1))-1;
//		System.out.println("usrChoice: " + usrChoice[0] + " " +  usrChoice[1]);
//		
//		x++;
//		
//		int priceUsrChoice = snackMatrix[usrChoice[0]][usrChoice[1]].getPrice();
//		int providedMoney = 0;
//		//add providedMoney
//		for(int i = 0; i < strToInt(inputArr[x]); i++){
//			providedMoney += strToInt(inputArr[x+i+1]);
//		}
//		System.out.println(providedMoney);
//		
//		getChange(priceUsrChoice, providedMoney);
//		
//		for(int i = 0; i < snackMatrix.length; i++){
//			for(int j = 0; j < snackMatrix[i].length; j++){
//				System.out.print(snackMatrix[i][j]);
//			}
//			System.out.println();
//		}
		
	}
	
	static void getChange(int price, int providedMoney){
		int[] coinValues = new int[]{
				200, 100, 50, 20, 10, 5, 2, 1
		};
		
		int missing = price - providedMoney;
		int change = missing*-1;
		System.out.println(change + " " + missing);
		int[] coinsAmount = new int[8];
		
		while(change > 0 ){
			for(int i = 0; i < coinValues.length; i++){
				coinsAmount[i] = (int) (change / coinValues[i]);
				change -= coinsAmount[i]*coinValues[i];
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
		
		
		
		
	}
	static String[] getInput(){
		Scanner in = new Scanner(System.in);

		try{
			String [] str = in.nextLine().split(" ");
			in.close();
			return str;
			
		} catch (Exception e){
			e.printStackTrace();
			return new String[]{};
			
		}
	}
	static int strToInt(String in){
		return Integer.parseInt(in);
	}
}
