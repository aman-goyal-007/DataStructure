

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {

	LinkedList list[]=null;
	int noOfVert=0;
	public BFSGraph(int v) {
		noOfVert=v;
		list = new LinkedList[5];
		for(int i=0;i<noOfVert;i++)
			list[i] = new LinkedList();
	}
	void addEdge(int v,int n){
		list[v].add(n);
	}
	boolean isCyclic(int v){
		
		return false;
	}
	void BFS(int s){
		boolean visited[] = new boolean[noOfVert];
		LinkedList queue = new LinkedList();
		visited[s]=true;
		queue.add(s);
		while(!queue.isEmpty()){
			s=(Integer)queue.poll();
			System.out.println(s);
			Iterator i=list[s].iterator();
			while(i.hasNext()){
				int n=(Integer)i.next();
				if(!visited[n]){
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	void DFS(int s,boolean[] visited){
		visited[s]=true;
		System.out.println(s);
		Iterator iter=list[s].iterator();
			while(iter.hasNext()){
				int n=(Integer)iter.next();
				if(!visited[n])
					DFS(n, visited);
			}
	}
	
	public static void main(String[] args) {
		BFSGraph graph = new BFSGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.BFS(2);
		boolean[] visited = new boolean[4];
		graph.DFS(2, visited);
	}

}
