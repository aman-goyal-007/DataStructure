import java.util.Stack;

public class Histogram {

	static int length;
	static int[] lcp;
	static int MAX;
	public static void main(String...args){
		lcp=new int[length];
		int i=0;
		lcp[i++]=3;
		lcp[i++]=0;
		lcp[i++]=2;
		lcp[i++]=0;
		lcp[i++]=1;
		lcp[i++]=0;
		lcp[i++]=1;
		lcp[i++]=2;
		length=lcp.length;
		checkHistogram();
		System.out.println(MAX);
	}
	private static void checkHistogram(){
		int[] sol=new int[length-1];
		Stack<Integer> stack = new Stack<Integer>();
		int area=0;
		int i=0;
		while(i<length){
			if(stack.isEmpty()|| lcp[i]>=lcp[stack.peek()]){
				stack.push(i++);
			}
			else{
					int x=stack.pop();
					area=lcp[x]*(stack.isEmpty()?i:i-stack.peek()-1);
					MAX=Math.max(MAX, area);
			}
		}
		while(!stack.isEmpty()){
			int x=stack.pop();
			area=lcp[x]*(stack.isEmpty()?i:i-stack.peek()-1);
			MAX=Math.max(MAX, area);
		}
		
		
	}
}
