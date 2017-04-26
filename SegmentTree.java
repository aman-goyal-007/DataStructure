/*
 * Segment Tree Code and Lazy Propagation
 * Below link provide very good explanation of this topic. Lazy propagation is another
 * very important concept in case of segment tree.
 * 						https://www.hackerearth.com/practice/notes/segment-tree-and-lazy-propagation/
 * 
 * Advantage: It's useful when number of updates are less. If we have more number of updates, we can use liner way.
 * Complexity: 
 * 				update --> O(logN)
 * 				query --> O(logN)
 * 
 */
public class SegmentTree {
	static int[] segmentTree;
	public static void main(String...args){
		int[] arr={1,3,5,7,9,11};
		segmentTree= new int[arr.length*5];
		constructSegmentTree(arr, 0, arr.length-1, 0);
		int sum = getSum(0, arr.length-1, 0, 1, 0);
		System.out.println("Query Sum -> "+sum);
	}
	
	static int constructSegmentTree(int[] arr,int start,int end,int current){
		if(start==end){
			segmentTree[current]=arr[start];
			return segmentTree[current];
		}
		int mid=start+(end-start)/2;
		//sum of left (2*current+1) and right child(2*current+2)
		segmentTree[current] = constructSegmentTree(arr, start, mid, 2*current+1)+constructSegmentTree(arr, mid+1, end, 2*current+2);
		return segmentTree[current];
	}
	static int getSum(int start,int end,int queryStart,int queryEnd,int current){
		if(queryStart<=start && queryEnd>=end)
			return segmentTree[current];
		if(end<queryStart || start>queryEnd)return 0;
		int mid=start+(end-start)/2;
		return getSum(start, mid, queryStart, queryEnd, 2*current+1)+getSum(mid+1, end, queryStart, queryEnd, 2*current+2);
	}
}
