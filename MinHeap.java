
public class MinHeap {

	int[] array;
	final int MAXSIZE;
	int size=0;
	public MinHeap(final int max) {
		MAXSIZE=max;
		array = new int[MAXSIZE];
		for(int i=0;i<MAXSIZE;i++)
			array[i]=-1;
	}
	
	public static void main(String...args){
		MinHeap minHeap = new MinHeap(20);
		minHeap.insert(4);
		minHeap.insert(5);
		minHeap.insert(7);
		minHeap.insert(90);
		minHeap.insert(6);
		minHeap.insert(100);
		System.out.println("Heap Print");
		minHeap.print();
		System.out.println("Deleting...");
		minHeap.delete();
		System.out.println("Heap Print");
		minHeap.print();

	}
	
	//will always delete root element
	void delete(){
		if(size==0)
			return;
		array[1]=array[size];
		array[size]=0;
		size--;
		minHeapify(1);
		
	}
	void insert(int element){
		array[++size]=element;
		int currentIndex = size;
		int parentIndex = parent(currentIndex);
		while(array[currentIndex]<parentIndex){
			swap(currentIndex,parentIndex);
			currentIndex=parentIndex;
		}
	}
	
	void swap(int first,int second){
		array[first]+=array[second];
		array[second]=array[first]-array[second];
		array[first]-=array[second];
	}
	int parent(int index){
		return index/2;
	}
	void print(){
		for(int i=1;i<=size;i++)
			System.out.println(array[i]);
	}

	void minHeapify(int heapifyIndex){
		int leftIndex=2*heapifyIndex;
		int rightIndex=2*heapifyIndex+1;
		int min=heapifyIndex;
		if(array[leftIndex]<array[min] && array[leftIndex] != -1)
			min=leftIndex;
		if(array[rightIndex]<array[min] && array[rightIndex] != -1)
			min=rightIndex;
		if(heapifyIndex!=min)
		{
			swap(heapifyIndex,min);
			minHeapify(min);
		}else return;
		
	}
	
	
	
}
