
public class QuickSort3Way {

	public static void main(String...args){
		int[] array = {3,4,1,7,4};
		sort(array,0,array.length-1);
		print(array);
	}
	static void print(int[] array){
		for(int i:array)
			System.out.println(i);
	}
	static void sort(int[] array,int lo,int hi){
		if(hi<=lo) return;
		int i=lo;
		int lt=lo;
		int gt=hi;
		
		int v=array[lo]; // pivot point
		while(i<=gt){
			if(v==array[i])i++;
			else if(array[i]<v){
				int j=array[i];
				array[i]=array[lt];
				array[lt]=j;
				i++;
				lt++;
			}else{
				int j=array[i];
				array[i]=array[gt];
				array[gt]=j;
				gt--;
			}
		}
		sort(array,lo,lt-1);
		sort(array,gt+1,hi);
		
		
	}
}
