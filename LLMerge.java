
public class LLReverse {

	public static void main(String...args){
		Node first = new Node(1, new Node(6,new Node(8,new Node(9,null))));
		Node second = new Node(2, new Node(4,new Node(7,null)));
		Node temp=reverseList(first, second);
		while(true){
			System.out.println(temp.data);
			if(temp.next==null) break;
			else temp = temp.next;
		}
		System.out.println(" Done printing.");
		
	}
	
	public static Node mergeList(Node first,Node second){
		Node result=null;
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
class Node{
	int data;
	Node next;
	Node(int data,Node next){
		this.data=data;
		this.next=next;
	}
}
