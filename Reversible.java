import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Reversible {

	static HashSet<Integer> includedNumber=new HashSet<Integer>();
    public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
        int testcases=sc.nextInt();
		List<Integer> output=new ArrayList<Integer>();
		for(int j=0;j<testcases;j++){
			int maxValue=sc.nextInt();
			int n=0;
			isReversible(maxValue);
			output.add(n);
		}
		for(Integer i:output)
			System.out.println(i);
    }
    static void isReversible(int i){
    	int count=0;
    	 switch (i % 4) {
         case 0:
         case 2:
             count += 20 * (30^ (i / 2 - 1));
             break;
         case 1:
             count += 100 * 500^( i / 4 -1);
             break;
         case 3:
             break;
     }
    	 System.out.println(count);
	}
}

