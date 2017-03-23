
import java.util.Scanner;

public class Bleak {

	public static void main(String...args){
			
		   Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			int[] output=new int[t];
			 int m=0;
			while(t>0){
			int number = sc.nextInt();
	            
	        boolean isBreak=false;
			for(int j=1;j<number;j++){
				if(j+getBinarySetCount(j)==number){
					isBreak=true;
					break;
				}
			}
	         output[m++]=isBreak?1:0;  	
			  t--;
			}
			        

			for(int i=0;i<output.length;i++){
			    System.out.println(output[i]);
			}
	}
	
	static int getBinarySetCount(int number){
		int count =0;
		while(number!=0){
		if((number & 1) == 1)count++;
		number = (number >> 1);
		}
		return count;
	}
}
