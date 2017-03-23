import java.util.LinkedList;


	/* Longest Increment Sequence using Dynamic Programming*/

class LIS
{
	
	
	
	public static void main(String...args){
		int[] array={10,2,20,3,30,4,5};
		getLIS(array);
	}
	
	
	static void getLIS(int[] array){
		int length=array.length;
		LinkedList[] listArray = new LinkedList[length];
		for(int i=0;i<length;i++)
			listArray[i] = new LinkedList<Integer>();
		listArray[0].add(array[0]);
		System.out.println(listArray[0]);
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++){
				int element=array[i];
				if((Integer)listArray[j].peekLast()<element && (listArray[i].size()<(listArray[j].size()))){
					listArray[i].clear();
					listArray[i].addAll(listArray[j]);
				}
			}
			listArray[i].add(array[i]);
			System.out.println(listArray[i]);
		}
	}
	
}


