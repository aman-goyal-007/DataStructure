import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//considering that source is 0 and destination(sink node) is V-1
// Ford-Fulkerson algorithm ( based on residual graph ) http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
public class MinimumCutMaximumFlow {
	static int V=6;
	public static void main(String...args){
		int[][] graph={{0,16,13,0,0,0},
					   {0,0,10,12,0,0},
					   {0,4,0,0,14,0},
					   {0,0,9,0,0,20},
					   {0,0,0,7,0,4},
					   {0,0,0,0,0,0}
		};
		maximumFlow(graph);
	}
	
	// will return if sink node(end node) is able to reach from source need in given residual graph.
	static boolean bfs(int[][] graph,int[] parent){
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0]=true;
		parent[0]=-1;
		while(!queue.isEmpty()){
			int idx = queue.poll();
			for(int i=0;i<V;i++){
				if(visited[i]==false && graph[idx][i]!=0){
					queue.add(i);
					parent[i]=idx;
					visited[i]=true;
				}
			}
		}
		return (visited[V-1]==true);
	}
	
	static void maximumFlow(int[][] graph){
		int[][] residualGraph = new int[V][V];
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				residualGraph[i][j] = graph[i][j];
			}
		}
		int[] parent = new int[V];
		int MAXFLOW=0;
		
		//run only while there is a flow from source to sink node
		while(bfs(residualGraph,parent)){
			
			int costOfCurrentFlow=Integer.MAX_VALUE;
			// We have to identify minimum in this path because that's what can be carried from source to sink node
			for(int i=V-1;i>0;i=parent[i]){
				int m=parent[i];
				costOfCurrentFlow = Math.min(costOfCurrentFlow, residualGraph[m][i]);
			}
			
			//Now update the residual graph and reverse edges
			for(int i=V-1;i>0;i=parent[i]){
				int m=parent[i];
				residualGraph[m][i] -= costOfCurrentFlow;
				residualGraph[i][m] += costOfCurrentFlow;
			}
			MAXFLOW += costOfCurrentFlow;
			
			
			
		}
		
		System.out.println(" Maximum possible flow for given graph is:"+MAXFLOW);
	}
}
