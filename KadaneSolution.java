
import java.util.ArrayList;

public class KadaneSolution {

	public static void main(String...args){
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] prob={-1,3,-5,4,6,-1,2,-7,13,-3};
		int length=prob.length;
		int maxSum=0;
		int maxSumTillNow=0;
		for(int i=0;i<length;i++){
			
			if((maxSum+prob[i])<0)
				maxSum=0;
			
			if((maxSum+prob[i])>maxSum){
				maxSum+=prob[i];
				System.out.println(prob[i]+",");
			}
		}
		System.out.println(maxSum);
	}
}
