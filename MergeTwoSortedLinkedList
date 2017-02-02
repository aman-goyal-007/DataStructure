public class MergeTwoSortedLinkedList {
	
    public static void main (String[] args)
    {
    	LinkedNode first = new LinkedNode(1,new LinkedNode(2,new LinkedNode(4,new LinkedNode(5,new LinkedNode(10,new LinkedNode(15,new LinkedNode(16,null)))))));
    	LinkedNode second = new LinkedNode(3,new LinkedNode(11,new LinkedNode(19,null)));
    	merge(first,second);
    }
    
    static void merge(LinkedNode one,LinkedNode two){
    	
    	LinkedNode dummy = new LinkedNode(0, null);
    	LinkedNode root=dummy;
    	while(one!=null && two!=null){
    		if(one.value<=two.value){
    			dummy.next=one;
    			one=one.next;
    			dummy=dummy.next;
    		}else{
    			dummy.next=two;
    			two=two.next;
    			dummy=dummy.next;
    		}
    	}
    	while(one!=null){
			dummy.next=one;
			one=one.next;
			dummy=dummy.next;
    	}
    	while(two!=null){
			dummy.next=two;
			two=two.next;
			dummy=dummy.next;
    	}
    	while(root.next!=null){
    		System.out.println(root.value);
    		root=root.next;
    	}
    }
    
    static LinkedNode reverse(LinkedNode root){
    	LinkedNode current=root;
    	LinkedNode prev=null;
    	LinkedNode next=null;
    	
    	while(current!=null){
    		next=current.next;
    		current.next=prev;
    		prev=current;
    		current=next;
    	}
    	return prev;
    	
    }
    
  }


class LinkedNode{
	int value;
	LinkedNode next;
	LinkedNode(int value,LinkedNode next){
		this.value=value;
		this.next=next;
	}
}
