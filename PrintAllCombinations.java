//Print all combinations using bit 
public class PrintAllCombinations {

	public static void main(String...args){
		String str="abc";
		double length=str.length();
		double pow=Math.pow(2d, length);
		pow--;
		int i=1;
		while(i<=pow){
			getCombination(i, str);
			i++;
		}
	}
	static void getCombination(int i,String str){
		int j=0;
		String s="";
		while(i>0){
			if((i&1)==1){
				s=s+str.charAt(j);
			}
			j++;
			i>>=1;
		}
		System.out.println(s);
	}
}
