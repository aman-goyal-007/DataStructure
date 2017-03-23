
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/* Longest Common Subsequence */
/* Solution api is normal solution without using dynamic algo. Actually recursive solution which is time consuming */
/* lcsDynamic api based on algo which is using matrix*/

public class LCS {

	static LinkedList<String> output = new LinkedList<String>();
	public static void main(String...args){
		char[] first={'A','E','D','F','H','R'};
		char[] second={'A','B','C','D','G','H'};
		System.out.println(Solution(first,second,6,6));
		System.out.println(lcsDynamic(first,second));
	}
	
	static int Solution(char[] first,char[] second,int fLength,int sLength){
		if(fLength==0 || sLength==0) return 0;
		if(first[fLength-1]== second[sLength-1])
			return 1+Solution(first, second, fLength-1, sLength-1);
		else
			return Math.max(Solution(first, second, fLength, sLength-1), Solution(first, second, fLength-1, sLength));
			
	}
	
	 static int lcsDynamic(char str1[],char str2[]){
		 int max=0;
		 int[][] solutionMatrix = new int[str1.length+1][str2.length+1];
		 for(int i=1;i<=str1.length;i++){
			 for(int j=1;j<=str2.length;j++){
				 if(str1[i-1]==str2[j-1]) solutionMatrix[i][j]=(solutionMatrix[i-1][j-1]+1);
				 else solutionMatrix[i][j]=Math.max(solutionMatrix[i-1][j],solutionMatrix[i][j-1]);
				 if(solutionMatrix[i][j]>max) {
					 max=solutionMatrix[i][j];
					 System.out.print(str1[i-1]);
				 }
			 }
		 }
		 System.out.println();

		 
		 return max;
	    
	    }	
	
}
