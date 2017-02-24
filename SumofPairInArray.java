import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//Given an array A[] and a number x, check for pair in A[] with sum as x
public class SumofPairInArray {
	
    public static void main (String[] args)
    {
    	int[] contentArray={3,1,2,8,4};
    	checkPairs(contentArray, 5);
    }
    
    
    static void checkPairs(int[] content,int sum){
    	BitSet bitset = new BitSet();
    	int temp=-1;
    	for(int i=0;i<content.length;i++){
    		temp=sum-content[i];
    		if(temp>=0 && bitset.get(temp)){
    			System.out.println("Pair: "+content[i]+","+temp);
    		}
    		bitset.set(content[i]);
    	}
    }
}
