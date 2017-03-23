
public class QuickSort {



		public static void main(String...args){
			int[] sortThis = {56,26,93,17,77,31,44,55,20};
			print(sortThis);
			quickSort(sortThis,0,sortThis.length-1);
			print(sortThis);
		}
		
		public static void quickSort(int[] sortThis,int left,int right)
		{
			if(left<right){
				int splitPoint=partition(sortThis,left,right);
				quickSort(sortThis,left,splitPoint);
				quickSort(sortThis,splitPoint+1,right);
				
			}
		
		}
		
		public static int partition(int[] sortThis,int left,int right){
			int pivotVal=sortThis[left];
			int leftMark=left+1;
			int rightMark=right;
			while(true){
				while(leftMark<=rightMark && sortThis[leftMark]<=pivotVal) leftMark++;
				while(leftMark<=rightMark && sortThis[rightMark]>=pivotVal) rightMark--;
				if(leftMark>rightMark)
					break;
				else{
					int temp = sortThis[leftMark];
					sortThis[leftMark]=sortThis[rightMark];
					sortThis[rightMark]=temp;
				}
				
			}
			int temp = sortThis[left];
			sortThis[left]=sortThis[rightMark];
			sortThis[rightMark]=temp;
			print(sortThis);

			return rightMark;
		}
		public static void print(int[] a){
			System.out.println();
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]+"..");
		}
		
	



		
	}











