import java.util.Scanner;

public class Arm {

	public static void main(String[] args) {
		String[] inputArr = getInput();
		
		int roboX = inputArr[1].charAt(0)-'A'+1;
		int roboY = strToInt(inputArr[1].substring(1));

		int endX = inputArr[2].charAt(0)-'A'+1;
		int endY = strToInt(inputArr[2].substring(1));
		
		int brokenDirection = strToInt(inputArr[3]);
		
		int time = 0;
		
		while(!(roboX == endX && roboY == endY)){
			time++;
			
			if(roboX < endX && roboY < endY){
				roboX ++;
				roboY ++;
				if(brokenDirection == 7) time++;
			}else if(roboX > endX && roboY < endY){
				roboX --;
				roboY ++;
				if(brokenDirection == 5) time++;
			}else if(roboX < endX && roboY > endY){
				roboX ++;
				roboY --;
				if(brokenDirection == 1) time++;
			}else if(roboX > endX && roboY > endY){
				roboX --;
				roboY --;
				if(brokenDirection == 3) time++;
			}
			else if(roboX < endX){
				roboX ++;
				if(brokenDirection == 0) time++;
			}
			else if(roboY < endY){
				roboY ++;
				if(brokenDirection == 6) time++;
			}
			else if(roboX > endX){
				roboX --;
				if(brokenDirection == 4) time++;
			}
			else if(roboY > endY){
				roboY --;
				if(brokenDirection == 2) time++;
			}
		}
		System.out.println(time);
		
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
