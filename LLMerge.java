//Merge a Linked List
public class LLMerge {

	public static void main(String...args){
		MyLLNode first = new MyLLNode(1, new MyLLNode(6,new MyLLNode(8,new MyLLNode(9,null))));
		MyLLNode second = new MyLLNode(2, new MyLLNode(4,new MyLLNode(7,null)));
		MyLLNode temp=mergeList(first, second);
		while(true){
			System.out.println(temp.data);
			if(temp.next==null) break;
			else temp = temp.next;
		}
		System.out.println(" Done printing.");
		
	}
	
	public static MyLLNode mergeList(MyLLNode first,MyLLNode second){
		MyLLNode result=null;
		if(first==null) return second;
		else if(second==null) return first;
		if(first.data<=second.data){
			result=first;
			result.next=mergeList(first.next, second);
		}else{
			result=second;
			result.next=mergeList(first, second.next);
		}
		return result;
	}
}
class MyLLNode{
	int data;
	MyLLNode next;
	MyLLNode(int data,MyLLNode next){
		this.data=data;
		this.next=next;
	}
}
