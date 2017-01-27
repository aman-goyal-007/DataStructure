public class LongestCommonSubarraySum {

	public static void main(String...args){
		int[] arr={-2,-3,4,-1,-2,1,5,-3};
		solution(arr);
		
	}
	
	static void solution(int[] arr){
		int maxPositiveSum=0;
		int maxSum=0;
		for(int i=0;i<arr.length;i++){
			maxPositiveSum=Integer.max(0, maxPositiveSum+arr[i]);
			maxSum=Integer.max(maxSum, maxPositiveSum);
		}
		
		
		System.out.println(maxSum);
	}
	
}
