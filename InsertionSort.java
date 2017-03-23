public class InsertionSort {

	
	public static void main(String...args){
		
		
		int[] sortThis = {14,33,27,10,35,19,42,44};
		int arrayLength = sortThis.length;
		for(int i=1;i<sortThis.length;i++){
			int ref=sortThis[i];
			int j=i-1;
			while(j>=0 && sortThis[j]>ref){
					sortThis[j+1]=sortThis[j];
					j--;
			}
			sortThis[j+1]=ref;
			print(sortThis);
		}
		System.out.println(sortThis);
		
		
	}
	
	public static void print(int[] a){
		System.out.println();
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"..");
	}
	
}
