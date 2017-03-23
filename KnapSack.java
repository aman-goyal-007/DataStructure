
// 0-1 Knap Sack
public class KnapSack {

	public static void main(String[] args) {
		int[] iWeight={2,2,4,5};
		int[] iValue={3,7,2,9};
		int W=5;
		bottomUpApproach(iWeight, iValue, W);
	}
	
	static void bottomUpApproach(int[] iWeight,int[]iValue,int W){
		int[][] T = new int[iWeight.length+1][W+1];

		for(int i=0;i<=iWeight.length;i++){
			for(int j=0;j<=W;j++){
				if(j==0|| i==0){
					T[i][j]=0;
					continue;
				}
				if(iWeight[i-1]>j) T[i][j]=T[i-1][j];
				else{
					T[i][j]=Math.max(iValue[i-1]+T[i-1][j-iWeight[i-1]], T[i-1][j]);
				}
				
			}
		}
		
		System.out.println("");
		
	}
}
