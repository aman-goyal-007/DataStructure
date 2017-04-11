
public class LLReverse {

	public static void main(String...args){
		MyNode head = new MyNode(1, new MyNode(2,new MyNode(3,new MyNode(4,new MyNode(5,null)))));
		
		head=reverse(head,3);
		MyNode temp=head;
		while(true){
			System.out.println(temp.data);
			if(temp.next==null) break;
			else temp = temp.next;
		}
		System.out.println(" Done printing.");
		
	}
	static MyNode reverse(MyNode node,int n){
		MyNode current,previous,next;
		current=node;
		previous=null;
		next=null;
		int count=0;
		while(count<n &&current != null){
			next = current.next;
			current.next=previous;
			previous=current;
			current=next;
			count++;
		}
		if(next!=null) node.next=reverse(next, n);
		return previous;
	}
}



class MyNode{
	int data;
	MyNode next;
	MyNode(int data,MyNode next){
		this.data=data;
		this.next=next;
	}
}
