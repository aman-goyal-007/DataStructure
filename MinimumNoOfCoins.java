
import java.util.ArrayList;
import java.util.Collections;

public class MinimumNoOfCoins {
	static ArrayList<Integer> denomination = new ArrayList<Integer>();
	public static void main(String[] args) {
		denomination.add(1000);
		denomination.add(500);
		denomination.add(100);
		denomination.add(50);
		denomination.add(20);
		denomination.add(10);
		denomination.add(5);
		denomination.add(2);
		denomination.add(1);
		checkMinDenomication(331);
	}
	static void checkMinDenomication(int amount){
		for(Integer den:denomination){
			if(amount==0) break;
			int no=amount/den;
			if(no>0){
				int reduceAmount=no*den;
				amount=amount-reduceAmount;
				System.out.println("Denomication: "+den+" Count: "+no+" Remaining amount:"+amount);
			}
		}
	}

}
