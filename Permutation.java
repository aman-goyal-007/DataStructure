public class Permutation {

	public static void main(String...args){
		char[] c={'a','b','c'};
		printPerm(c, 0, 2);
	}
	static void printPerm(char[] c,int start,int end){
		if(start!=end){
			for(int i=start;i<=end;i++){
				c=swap(c,start,i);
				printPerm(c, start+1, end);
				c=swap(c,start,i);
			}
		}
		else
			System.out.println(c);
	}
	static char[]  swap(char[] c,int i,int j){
		char a=c[i];
		c[i]=c[j];
		c[j]=a;
		return c;
	}
	
}
