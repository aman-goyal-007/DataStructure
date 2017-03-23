
/*Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert str1 into str2.

Insert
Remove
Replace
All of the above operations are of equal cost.
*/
public class EditDistance {

	public static void main(String[] args) {
		  String str1 = "azced";
	        String str2 = "abcdef";
	        System.out.println(dynamicEditDistance(str1.toCharArray(), str2.toCharArray()));
	}
	 static int dynamicEditDistance(char[] str1, char[] str2){
	        int temp[][] = new int[str1.length+1][str2.length+1];
	        for(int i=0;i<str1.length+1;i++){
	        	temp[0][i]=i;
	        	temp[i][0]=i;
	        }
	        for(int i=1;i<=str1.length;i++){
	        	for(int j=1;j<=str2.length;j++){
	        		if(str1[i-1]==str2[j-1]) temp[i][j]=temp[i-1][j-1];
	        		else temp[i][j]=1+min(temp[i-1][j-1],temp[i-1][j],temp[i][j-1]);
	        	}
	        }
	        printActualEdits(temp, str1, str2);
	        return temp[str1.length][str2.length];
	        
	    }
	  static int min(int a,int b, int c){
	        int l = Math.min(a, b);
	        return Math.min(l, c);
	    }
	 static void printActualEdits(int T[][], char[] str1, char[] str2) {
	        int i = T.length - 1;
	        int j = T[0].length - 1;
	        while(true) {
	            if (i == 0 || j == 0) {
	                break;
	            }
	            if (str1[i-1] == str2[j-1]) {
	                i = i-1;
	                j = j-1;
	            } else if (T[i][j] == T[i-1][j-1] + 1){
	                System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
	                i = i-1;
	                j = j-1;
	            } else if (T[i][j] == T[i-1][j] + 1) {
	                System.out.println("Delete in string1 " + str1[i-1]);
	                i = i-1;
	            } else if (T[i][j] == T[i][j-1] + 1){
	                System.out.println("Delete in string2 " + str2[j-1]);
	                j = j -1;
	            } else {
	                throw new IllegalArgumentException("Some wrong with given data");
	            }

	        }
	    }
}
