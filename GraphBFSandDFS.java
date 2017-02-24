import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;
//This is for directed graph
public class GraphBFSandDFS {
	
	private int v;
	private LinkedList<Integer> arrayOfList[];
	
	public GraphBFSandDFS(int vertices) {
		v=vertices;
		arrayOfList=new LinkedList[v];
		for(int i=0;i<v;i++)
			arrayOfList[i] = new LinkedList<>();
	}
	
	public void addEdge(int fromVertex,int toVertex){
		arrayOfList[fromVertex].add(toVertex);
	}
	
	
	//This will print BFS from given source
	public void printBFS(int source){
		BitSet visited = new BitSet();
		Queue<Integer> queue = new LinkedList<>();
		
		visited.set(source);
		queue.add(source);
		while(!queue.isEmpty()){
			int element = queue.poll();
			System.out.print(element+"->");
			for(int vertex:arrayOfList[element]){
				if(!visited.get(vertex)){
					queue.add(vertex);
					visited.set(vertex);
				}
			}
		}
	}
	
	//This will print DFS. Internally it will call utility method to print
	public void printDFS(int source){
		BitSet visited = new BitSet();
		printDFSUtil(source, visited);
	}
	public void printDFSUtil(int source,BitSet visited){
		
		visited.set(source);
		System.out.print(source+"->");
		for(int vertex:arrayOfList[source]){
			if(!visited.get(vertex))
				printDFSUtil(vertex, visited);
		}
		
		
	}
	
	public static void main(String...args){
		GraphBFSandDFS graph = new GraphBFSandDFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.println("------------Printing BFS-----------------");
		graph.printBFS(2);
		System.out.println("\n------------Printing BFS Done------------");
		System.out.println("------------Printing DFS-----------------");
		graph.printDFS(2);
		System.out.println("\n------------Printing DFS Done------------");
	}
}
