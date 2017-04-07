
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
/** Class KnuthMorrisPratt **/
public class KMP
{
    /** Failure array **/
    private int[] failure;
    /** Constructor **/
    public KMP(String text, String pat)
    {
        /** pre construct failure array for a pattern **/
        failure = new int[pat.length()];
        fail(pat);
        /** find match **/
        int pos = posMatch(text, pat);
        if (pos == -1)
            System.out.println("\nNo match found");
        else
            System.out.println("\nMatch found at index "+ pos);
    }
    /** Failure function for a pattern **/
    private void fail(String pat)
    {
        int n = pat.length();
        failure[0] = -1;
        for (int j = 1; j < n; j++)
        {
            int i = failure[j - 1];
            while ((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0)
                i = failure[i];
            if (pat.charAt(j) == pat.charAt(i + 1))
                failure[j] = i + 1;
            else
                failure[j] = -1;
        }
    }
    /** Function to find match for a pattern **/
    private int posMatch(String text, String pat)
    {
        int i = 0, j = 0;
        int lens = text.length();
        int lenp = pat.length();
        while (i < lens && j < lenp)
        {
            if (text.charAt(i) == pat.charAt(j))
            {
                i++;
                j++;
            }
            else if (j == 0)
                i++;
            else
                j = failure[j - 1] + 1;
        }
        return ((j == lenp) ? (i - lenp) : -1);
    }
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
    	
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Knuth Morris Pratt Test\n");
        System.out.println("\nEnter Text\n");
        String text = br.readLine();
        System.out.println("\nEnter Pattern\n");
        String pattern = br.readLine();
        KMP kmp = new KMP(text, pattern);        
*/
/*        System.out.println("Knuth Morris Pratt Test\n");
        System.out.println("\nEnter Text\n");
*/      String text = "aaabca";
 //       System.out.println("\nEnter Pattern\n");
        String pattern = "abc";
        KMP kmp = new KMP(text, pattern);        
//        calculatelps(pattern);
    }
    
    
    //https://www.youtube.com/watch?v=tWDUjkMv6Lc      This is more understandable
    static void calculatelps(String pattern){
    	char[] patCharArr = pattern.toCharArray();
    	int j=0;
    	int[] lps=new int[patCharArr.length];
    	lps[0]=0;
    	int i=1;
    	while(i<patCharArr.length){
    		if(patCharArr[j]==patCharArr[i]){
    			lps[i]=j+1;
    			i++;
    			j++;
    		}
    		else{
    			if(j==0){
    				lps[i]=0;
    				i++;
    			}else{
    				j=lps[j-1];
    			}
    		}
    	}
    	
    	System.out.println(lps);
    }
}















