
public class MergeSort {

	public static void main(String...args){
		int[] sortThis = {14,3,5,18};
		print(sortThis);
		divide(sortThis, 0, sortThis.length-1);
		print(sortThis);
	}
	
	public static void divide(int[] sortThis,int lo,int hi){
		int middle=(lo+hi)/2;
		if(lo<hi){
			divide(sortThis,lo,middle);
			divide(sortThis,middle+1,hi);
			merge(sortThis,lo,middle,hi);
		}
	}
	
	public static void merge(int[] sortThis,int lo,int mid,int hi){
		int[] tempArray = new int[hi-lo+1];
		int pos=0;
		int lpos=lo;
		int rpos=mid+1;
		while(lpos<=mid && rpos<=hi){
			if(sortThis[lpos]<sortThis[rpos])
				tempArray[pos++]=sortThis[lpos++];
			else
				tempArray[pos++]=sortThis[rpos++];
		}
		while(lpos<=mid)
			tempArray[pos++]=sortThis[lpos++];
		
		while(rpos<=hi)
			tempArray[pos++]=sortThis[rpos++];
		
		for(int i=0;i<pos;i++){
			sortThis[lo+i]=tempArray[i];
		}
	}
	
	public static void print(int[] a){
		System.out.println();
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"..");
	}
	
}




class A{
	public Number check(Number a) throws Exception{
		return a;
	}
}

class B extends A{
	
	@Override
	public Integer check(Number a) throws Exception{
		return 0;
	}
	
}









