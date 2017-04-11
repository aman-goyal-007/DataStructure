import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Here we will perform all possible operations on tree
 * LevelOrderTraversal
 * LevelOrderTraversal in spiral
 */
public class Tree {
	public static void main(String...args){
		NodeTree seven = new NodeTree(7,null,null);
		NodeTree six = new NodeTree(6,null,null);
		NodeTree five = new NodeTree(5,null,null);
		NodeTree four = new NodeTree(4,null,null);
		NodeTree two = new NodeTree(2,seven,six);
		NodeTree three = new NodeTree(3,five,four);
		NodeTree root = new NodeTree(1,two,three);
		printLevelOrder(root);
		printSpiral(root);
		
	}
	
	
	static void printLevelOrder(NodeTree root){
		System.out.println("Printing level order");
		Queue<NodeTree> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			NodeTree temp = queue.poll();
			if(temp.left !=null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
			System.out.print(temp.data +"|");
		}
	}
	
	static void printSpiral(NodeTree root){
		System.out.println("\nPrinting level order in spiral form");

		boolean isTrue=true;
		Queue<NodeTree> queue=new LinkedList<>();
		Stack<NodeTree> stack=new Stack<>(); 
		stack.add(root);
		while(!queue.isEmpty() || !stack.isEmpty()){
			if(!queue.isEmpty()){
				NodeTree temp = queue.poll();
				if(temp.left !=null)
					stack.add(temp.left);
				if(temp.right != null)
					stack.add(temp.right);
				System.out.print(temp.data +"|");
			}else{
				NodeTree temp = stack.pop();
				if(temp.left !=null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
				System.out.print(temp.data +"|");
			}
			
		}
	}
	
	
}
class NodeTree{
	int data;
	NodeTree left;
	NodeTree right;
	NodeTree(int data,NodeTree left,NodeTree right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
}

