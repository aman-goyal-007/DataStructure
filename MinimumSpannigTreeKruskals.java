
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


//NOT COMPLETED YET
//NOT COMPLETED YET
//NOT COMPLETED YET
//NOT COMPLETED YET
//NOT COMPLETED YET
//NOT COMPLETED YET
//NOT COMPLETED YET


public class MinimumSpannigTreeKruskals {
	int V=0;
	ArrayList<Edge> graph = new ArrayList<Edge>();
	ArrayList<Edge> kruskal = new ArrayList<Edge>();
	
	public static void main(String...args){
		MinimumSpannigTreeKruskals mst = new MinimumSpannigTreeKruskals();
		mst.V=9;
		mst.graph.add(new Edge(0,1,4));
		mst.graph.add(new Edge(1,2,8));
		mst.graph.add(new Edge(2,3,7));
		mst.graph.add(new Edge(3,4,9));
		mst.graph.add(new Edge(4,5,10));
		mst.graph.add(new Edge(5,6,2));
		mst.graph.add(new Edge(6,7,1));
		mst.graph.add(new Edge(7,0,8));
		
		mst.graph.add(new Edge(7,1,11));
		mst.graph.add(new Edge(7,8,7));
		mst.graph.add(new Edge(6,8,6));
		mst.graph.add(new Edge(8,2,2));
		mst.graph.add(new Edge(2,5,4));
		mst.graph.add(new Edge(3,5,14));
		Collections.sort(mst.graph);
	//	System.out.println("Actual Graph");
//		mst.printGraph(mst.graph);
		mst.findMST();
	//	System.out.println("Kruskal's MST");
//		mst.printGraph(mst.kruskal);
	}
	
	void findMST(){
		int addedVertices=0;
		boolean visited[] = new boolean[V];
		while(addedVertices<V){
			Edge e=this.graph.remove(0);
			System.out.println(e);
			if(!checkCycle(e,visited)){
				visited[e.getFirst()]=true;
				visited[e.getSecond()]=true;
				this.kruskal.add(e);
				addedVertices++;
			}
//			System.out.println("////////");
//			printGraph(kruskal);
		}
	}
	
	boolean checkCycle(Edge e,boolean[] visited){
		boolean isCycle=false;
		boolean localVisited[] = new boolean[V];
		for(int i=0;i<visited.length;i++)
			localVisited[i]=visited[i];
	//	System.out.println("i");
		for(Edge kEdge:this.kruskal){
			if(localVisited[e.getFirst()]==true && localVisited[e.getSecond()]==true){
				visited[e.getSecond()]=false;
				return true;
			}
			localVisited[kEdge.getSecond()]=false;
			localVisited[kEdge.getFirst()]=false;
			
		}
		return isCycle;
		
	}
	
	void printGraph(ArrayList<Edge> localGraph){
		for(Edge e:localGraph){
			System.out.println(e.getFirst()+","+e.getSecond()+","+e.getWeight());
		}
	}
	
}

class Edge implements Comparable<Edge>{
	private int first;
	private int second;
	private int weight;
	
	public Edge(int first, int second, int weight) {
		super();
		this.first = first;
		this.second = second;
		this.weight = weight;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return (this.weight-o.weight);
	}
	
	@Override
	public boolean equals(Object o){
		Edge p =(Edge)o;
		if(p.first==this.first && p.second==this.second) return true;
		return true;
	}
	
	@Override
	public String toString(){
		return "Edge: "+first+","+second+","+weight;
	}
}
