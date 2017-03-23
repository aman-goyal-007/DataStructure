
public class RoadCutting {
	
        // A utility function to get the maximum of two integers
       static int max(int a, int b) { return (a > b)? a : b;}
         
       /* Returns the best obtainable price for a rod of length n and
          price[] as prices of different pieces. This is optimal structure top down approach*/
       static int cutRod(int price[],int n)
       {
          int val[] = new int[n+1];
          val[0] = 0;
          int i, j;
         
          // Build the table val[] in bottom up manner and return the last entry
          // from the table
          for (i = 1; i<=n; i++)
          {
              int max_val = Integer.MIN_VALUE;
              for (j = 0; j < i; j++){
                max_val = max(max_val, price[j] + val[i-j-1]);
                System.out.println("i ->"+i+" calc "+(i-j-1)+" j:"+j);
              }
              val[i] = max_val;
          }
         
          return val[n];
       }
         
       /* Driver program to test above functions */
       public static void main(String args[])
       {
           int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
           int size = arr.length;
           System.out.println("Maximum Obtainable Value is "   + cutRodRecursive(arr, size));
           System.out.println("Maximum Obtainable Value is "   + cutRodAman(arr, size));
                
       }
       
       
       
       static int cutRodRecursive(int price[],int n)
       {
         
    	   if (n <= 0)
               return 0;
          // Build the table val[] in bottom up manner and return the last entry
          // from the table
          int max_val = Integer.MIN_VALUE;
          for (int i = 0; i<n; i++)
          {
                max_val = max(max_val, price[i]+cutRodRecursive(price,n-i-1));
          }
         
          return max_val;
       }
       static int cutRodAman(int price[], int n)
       {
          if (n <= 0)
            return 0;
          int max_val = Integer.MIN_VALUE;
         
          // Recursively cut the rod in different pieces and compare different 
          // configurations
          for (int i = 0; i<n; i++)
                max_val = max(max_val, price[i] + cutRodAman(price, n-i-1));
         
          return max_val;
       }

}
