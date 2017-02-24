
public class LLReverse {

	public static void main(String...args){
		MyNode head = new MyNode(1, new MyNode(2,new MyNode(3,new MyNode(4,null))));
		
		MyNode current,previous,next;
		current=head;
		previous=null;
		next=null;
		while(current != null){
			next = current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		head=previous;
		MyNode temp=head;
		while(true){
			System.out.println(temp.data);
			if(temp.next==null) break;
			else temp = temp.next;
		}
		System.out.println(" Done printing.");
		
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
