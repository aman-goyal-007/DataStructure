import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Here we will build suffix array first and then LCP using suffix array(Pending  Kasai's algorithm)
 * Suffix array building : http://www.geeksforgeeks.org/suffix-array-set-2-a-nlognlogn-algorithm/
 * Kasai's Algo: http://www.geeksforgeeks.org/%C2%AD%C2%ADkasais-algorithm-for-construction-of-lcp-array-from-suffix-array/
 *
 *
 *Suffix array usign Kasai algo is not completed yet
 */



class Suffix implements Comparable<Suffix>{

	int index;
	int[] rank;
	Suffix(){
		index=0;
		rank=new int[2];
	}
	@Override
	public int compareTo(Suffix o) {
		int i=(this.rank[0]==o.rank[0])?((this.rank[1]==o.rank[1])?0:(this.rank[1]<o.rank[1])?-1:1):((this.rank[0]<o.rank[0])?-1:1);
		return i;
	}
	
	@Override
	public String toString(){
		return index+"^"+rank[0]+"^"+rank[1];
	}
	
}

// We can use suffix array to serach any string using binary search;
public class SuffixArrayAndLCP {
	static int length;
	static int[] first;
	static int[] second;
	static int[] sortedIndex;
	static String[] strArray;
	static String[] solutionArray;
	public static void main(String...args){
		String str=new String("banana");
    	try{
	    	BufferedReader reader = new BufferedReader(new FileReader("D:/a.txt"));
	    	//str=reader.readLine();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		Suffix[] indexArr = suffixArray(str);
	}
	
	public static Suffix[] suffixArray(CharSequence S) {
		length=S.length();
	    Suffix[] suffixArr = new Suffix[length];
	    for(int i=0;i<length;i++)
	    	suffixArr[i]=new Suffix();
	    for(int i=0;i<length;i++){
	    	suffixArr[i].index=i;
	    	suffixArr[i].rank[0]=S.charAt(i)-'a';
	    	suffixArr[i].rank[1]=((i+1)<length)?S.charAt(i+1)-'a':-1;
	    }
	    Arrays.sort(suffixArr);
	    int ind[] = new int[length];
	    for(int k=4;k<2*length;k=k*2){
	    	int rank=0;
	    	suffixArr[0].rank[0]=0;
	    	int prevRank=suffixArr[0].rank[0];
	    	for(int i=1;i<length;i++){
	    		if((suffixArr[i].rank[0]==prevRank) && (suffixArr[i].rank[1]==suffixArr[i-1].rank[1])){
	    			prevRank=suffixArr[i].rank[0];
	    			suffixArr[i].rank[0]=rank;
	    		}
	    		else{
	    			prevRank=suffixArr[i].rank[0];
	    			suffixArr[i].rank[0]=++rank;
	    		}
	    		 ind[suffixArr[i].index] = i;
	    	}
	    	for(int i=0;i<length;i++){
	    		int nextindex = suffixArr[i].index + k/2;
	    		suffixArr[i].rank[1] = (nextindex < length)?
	    				suffixArr[ind[nextindex]].rank[0]: -1;
	             }
	    	Arrays.sort(suffixArr);
	    }
	    for(Suffix s:suffixArr)
	    	System.out.println(s);
	    
	    
	    return suffixArr;
	  }
	
}
