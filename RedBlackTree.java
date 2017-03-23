
public class RedBlackTree {
	class Node{
		int key;
		Node left;
		Node right;
		Node parentNode;
		char color;
		Node(int key,Node parentNode){
			this.key=key;
			this.left=null;
			this.right=null;
			this.color='R';
			this.parentNode=parentNode;
		}
	}

	static Node root;
	public static void main(String...args){
		RedBlackTree bst = new RedBlackTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		bst.inorderRec(root);
		System.out.println("Aman");
	}
	void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            if(root.parentNode==null)System.out.println(root.key+" Color :"+root.color+" Parent Node: NULL");
            else System.out.println(root.key+" Color :"+root.color+" Parent Node: "+root.parentNode.key);
            inorderRec(root.right);
        }
    }
	void insert(int key){
		Node insertedNode=null; 
//		root = insertRec(key, root, null);
		insertedNode = insertRec(key, root,null,-1);
		handleClause3and4(insertedNode);
	}
	
	Node insertRec(int key,Node root,Node parentNode,int lorR){
		Node inserted=null;
		Node parent=null;
		if(root==null)
		{
			root=new Node(key,parentNode);
			if(parentNode==null){
				this.root=root;
				root.color='B';
			}else{
				if(lorR==0)parentNode.left=root;
				else parentNode.right=root;
			}
			return root;
		}else{
			while(true){
				if(key<root.key) {
					parent=root;
					root=root.left;
					lorR=0;
				}
				else if(key>root.key) {
					parent=root;
					root=root.right;
					lorR=1;
				}
				if(root==null) break;
			}
			root =insertRec(key,root,parent,lorR);
			
		}
		return root;
	}
	
	
	/*Node insertRec(int key,Node root,Node parentNode){
		if(root==null)
		{
			root=new Node(key,parentNode);
			if(parentNode==null) root.color='B';
			handleClause3and4(root);
			return root;
		}else{
			if(key<root.key)
				root.left =insertRec(key,root.left,root);
			else if(key>root.key)
				root.right =insertRec(key,root.right,root);
		}
		return root;
	}	*/

	void handleClause3and4(Node node){
		/*
		 * If parent node is Black then no problem because addition of red node(default) not violating rule 3(no 2 continuous red nodes are possible)
		 * If parent is Red. Then there are below 2 actions.
		 * 	1. If red node's red parent's sibling is red, then recolours the parent and sibling of parent to red 
		 * 	2. Restructuring required in  this case
		 */
		Node parentNode=node.parentNode;
		if(parentNode!=null && parentNode.color=='R'){
			Node sibling=getSibling(parentNode);
			if(sibling!=null && sibling.color=='R'){ // recolours in this case
				parentNode.color='B';
				sibling.color='B';
				if(parentNode.parentNode!=root)
					parentNode.parentNode.color='R';
			}
			else if(sibling == null || sibling.color=='B'){ // restructure in this case
				adjustAfterInsertion(node,parentNode);
			}
		}

	}
	
	
	void adjustAfterInsertion(Node node,Node parentNode){
		/*
		 * 4 possible cases:
		 * Left, Right,Left-Right, Right-Left
		 */
		Node grandParent=parentNode.parentNode;
		
		if(parentNode==grandParent.left && node==parentNode.left){//Right Rotation
			parentNode.parentNode=grandParent.parentNode;
			grandParent.left=parentNode.right;
			parentNode.right=grandParent;
			grandParent.parentNode=parentNode;
			grandParent.color='R';
		}
		else if(parentNode==grandParent.left && node==parentNode.right){// Left-Right
			node.left=parentNode;
			node.right=grandParent;
			node.parentNode=grandParent.parentNode;
			grandParent.color='R';
			grandParent.left=null;
			grandParent.parentNode=node;
			parentNode.right=null;
			parentNode.parentNode=node;
		}
		else if(parentNode==grandParent.right &&  node==parentNode.right){// Left rotation
			parentNode.parentNode=grandParent.parentNode;
			grandParent.color='R';
			grandParent.right=parentNode.left;
			parentNode.left=grandParent;
			grandParent.parentNode=parentNode;
		}
		else if(parentNode==grandParent.right &&  node==parentNode.left){// Right-Left rotation
			node.parentNode=grandParent.parentNode;
			node.left=grandParent;
			node.right=parentNode;
			grandParent.color='R';
			grandParent.right=null;
			grandParent.parentNode=node;
			parentNode.left=null;
			parentNode.parentNode=node;
		}
		
		
		
		
		grandParent=parentNode.parentNode;
		if(grandParent==null) {
			parentNode.color='B';
			root=parentNode;
		}
	}
	
	Node getSibling(Node node){
		Node parentNode=node.parentNode;
		Node sibling;
		if(parentNode==null) return null;
		if(node==parentNode.right) sibling=parentNode.left;
		else sibling=parentNode.right;
		return sibling;
	}
}

