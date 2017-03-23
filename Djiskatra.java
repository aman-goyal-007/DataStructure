
public class Djiskatra {

    static final int V=9;
	 int minDistance(int dist[], Boolean sptSet[])
	    {
	        // Initialize min value
	        int min = Integer.MAX_VALUE, min_index=-1;
	 
	        for (int v = 0; v < V; v++)
	            if (sptSet[v] == false && dist[v] <= min)
	            {
	                min = dist[v];
	                min_index = v;
	            }
	 
	        return min_index;
	    }
	 void dijkstra(int graph[][], int src)
	    {
	        int dist[] = new int[V]; // The output array. dist[i] will hold
	                                 // the shortest distance from src to i
	 
	        // sptSet[i] will true if vertex i is included in shortest
	        // path tree or shortest distance from src to i is finalized
	        Boolean sptSet[] = new Boolean[V];
	 
	        for(int i=0;i<V;i++){
	        	dist[i]=Integer.MAX_VALUE;
	        	sptSet[i]=false;
	        }
	        dist[src]=0;
	        for(int count=0;count<V-1;count++){
	        	int u=minDistance(dist, sptSet);
	        	sptSet[u]=true;
	        	for(int v=0;v<V;v++){
	        		if(!sptSet[v] && graph[u][v]!=0&&
	        		dist[u]!=Integer.MAX_VALUE &&
	        		dist[u]+graph[u][v]<dist[v])
	        		dist[v]=dist[u]+graph[u][v];
	        	}
	        }
	 
	        // print the constructed distance array
	        printSolution(dist, V);
	    }
	 
	    // A utility function to print the constructed distance array
	    void printSolution(int dist[], int n)
	    {
	        System.out.println("Vertex   Distance from Source");
	        for (int i = 0; i < V; i++)
	            System.out.println(i+" \t\t "+dist[i]);
	    }
	public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 0, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 14, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
       Djiskatra t = new Djiskatra();
        t.dijkstra(graph, 0);
    }
	
}
