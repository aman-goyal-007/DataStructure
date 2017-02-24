
/*
Minimum number of jumps to reach end
Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)

*/


static int minJumps(int arr[], int n) // n is array size
	{
	    int[] jumps = new int[n];  
	    
	    jumps[0]=0;
	    for(int j=1;j<n;j++) jumps[j]=Integer.MAX_VALUE;
	    for(int i=0;i<n;i++){
	    	for(int j=i;j<=arr[i];j++){
	    		if(i+j<n){
	    			if(jumps[i+j]>jumps[i]+1){
	    				jumps[i+j]=jumps[i]+1;
	    			}
	    		}else{
	    			return jumps[i]+1;
	    		}
	    		
	    		
	    		
	    	}
	    		
	    }
	    
	    return jumps[n-1];
	}
