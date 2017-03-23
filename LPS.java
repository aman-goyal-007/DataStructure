/*
 Longest Palindrome String and Subsequence code
 */

public class LPS {

	public static void main(String[] args) {
		LongestPalindromeStringNSquare("BANANA");

	}
	
	
	// Longest Palindrome Substring. This algorithm takes N^2 time. There is better solution. Check .....
	static void LongestPalindromeStringNSquare(String checkString){
		int length=checkString.length();
		int maxLen=0;
		int beginsAt=0;
		boolean[][] palindrome = new boolean[length][length];
		for(int i=0;i<length;i++){palindrome[i][i]=true;}
		for(int i=0;i<length-1;i++){
			if(checkString.charAt(i)==checkString.charAt(i+1)){
				palindrome[i][i+1]=true;
				beginsAt=i;
				maxLen=2;
			}
		}
		for(int i=3;i<=length;i++){
			for(int j=0;j<(length-i+1);j++){
				if(checkString.charAt(j)==checkString.charAt(j+i-1) && palindrome[j+1][j+i-2]){
					palindrome[j][j+i-1]=true;
					beginsAt=j;
					maxLen=i;
				}
			}
		}
		
		
		System.out.println(checkString.substring(beginsAt,maxLen+1));
		
	}

}
