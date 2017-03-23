import java.util.LinkedList;
import java.util.Queue;

//BST All Operations
public class BST {

	public static void main(String...args){
		//Testing add and remove
 		Node root=new Node(4, null, null);
		add(root,7);
		add(root,4);
		add(root,8);
		System.out.println("\nPrinting Inorder");
		inOrder(root);
//*		delete(root, 6);
		System.out.println("\nPrinting Inorder");
		inOrder(root);
		

		
/*	//Testing Preorder, postorder
 	System.out.println("\nPrinting Preorder");
		preOrder(root);
		System.out.println("\nPrinting Postorder");
		postOrder(root);
*/		
		
/*		//Testing BFS
		Node root=new Node(5, null, null);
		add(root,10);
		add(root,15);
		add(root,20);
		add(root,25);
		add(root,30);
		add(root,35);
		printBFS(root);
*/		
		
	}
	
	static void add(Node root,int value){
		if(root==null){
			root = new Node(value, null, null);
		}else if(value<root.value){
			if(root.left==null){
				root.left=new Node(value, null, null);
			}
			else
				add(root.left,value);
		}else if(value>root.value){
			if(root.right==null){
				root.right=new Node(value, null, null);
			}
			else
				add(root.right,value);
		}
	}
	
	static Node delete(Node root,int value){
		if(root.value==value){
			if(root.left==null &&root.right==null){ // leaf node case
				return null;
			}else if(root.left!=null && root.right!=null){// in-order successor case
				root.value=inOrderSuccessor(root.right);
				root.right=delete(root.right,root.value);
			}else{// single child case
				if(root.left!=null) return root.left;
				else return root.right;
			}
			
			
			
		}else if(value<root.value){
			root.left = delete(root.left,value);
		}else{
			root.right=delete(root.right,value);
		}
		return root;
	}
	static int inOrderSuccessor(Node node){
		int min=node.value;
		while(node.left!=null){
			min=node.left.value;
			node=node.left;
		}
		return min;
	}
	static void inOrder(Node root){
		if(root==null) return;
		if(root.left!=null){
			inOrder(root.left);
		}
		System.out.print(root.value+":");
		if(root.right!=null){
			inOrder(root.right);
		}
			
	}
	
	static void preOrder(Node root){
		if(root==null) return;
		System.out.print(root.value+":");
		if(root.left!=null){
			preOrder(root.left);
		}
		if(root.right!=null){
			preOrder(root.right);
		}
			
	}
	
	static void postOrder(Node root){
		if(root==null) return;
		if(root.left!=null){
			postOrder(root.left);
		}
		if(root.right!=null){
			postOrder(root.right);
		}
		System.out.print(root.value+":");
			
	}
	
	
	static void printBFS(Node root){
		Queue<Node> queue = new LinkedList<>();
		Node currentNode = null;
		if(root==null) return;
		queue.add(root);
		while(!queue.isEmpty()){
			currentNode=queue.remove();
			System.out.println(currentNode.value);
			if(currentNode.left!=null)
				queue.add(currentNode.left);
			if(currentNode.right!=null)
				queue.add(currentNode.right);
		}
	}
	
}

	

class Node{
	int value;
	Node left;
	Node right;
	Node(int v,Node l,Node r){
		this.value=v;
		this.right=r;
		this.left=l;
	}
}



