
import java.util.ArrayList;
import java.util.List;

public class CoinChange {

	public static void main(String...args){
		int[] coins={1,2,3};
		int total=4;
        List<Integer> result = new ArrayList<>();
		printActualSolution(result,total,coins,0);
	}
	
	
	/*private static void printActualSolution(List<Integer> result,int total,int coins[],int pos){
        if(total == 0){
            for(int r : result){
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
        for(int i=pos; i < coins.length; i++){
            if(total >= coins[i]){
                result.add(coins[i]);
                printActualSolution(result,total-coins[i],coins,i);
                result.remove(result.size()-1);
            }
        }
    }*/
	
	
	static void printActualSolution(List<Integer> result,int total,int[] coins,int pos){
		if(total==0){
			for(int i:result)
				System.out.print(i+" ");
			System.out.println("\n");
		}
		
		for(int i=pos;i<coins.length;i++){
			if(total>=coins[i]){
				result.add(coins[i]);
				printActualSolution(result, total-coins[i], coins, i);
				result.remove(result.size()-1);
			}
		}
		
	}

	
}
