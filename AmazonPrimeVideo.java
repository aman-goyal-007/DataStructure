import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AmazonPrimeVideo {

	public static void main(String...args){
		int N=5;
		int start=4;
		int[] digiLock={1,2,3};
		String[] friends={"3","5","2 4","2 3","2 5","4 5","4 5","1 5"};
		solve(N,start,digiLock,friends);
	}
	
	public static void solve(int input1,int input2, int[] input3,String[] input4){
		int sol=-1;
		int[][] mat=new int[input1][input1];
		HashSet<Integer>[] paths = new HashSet[input1];
		for(int i=0;i<input1;i++)
			paths[i] = new HashSet<>();
		int start=input2;
		boolean[] visited=new boolean[input1];
		HashSet<Integer> toVisit = new HashSet<>();
		for(int i:input3)
			toVisit.add(i-1);
		for(String s:input4){
			String[] f=s.split(" ");
			if(f.length==2){
				paths[Integer.valueOf(f[0])-1].add(Integer.valueOf(f[1])-1);
				paths[Integer.valueOf(f[1])-1].add(Integer.valueOf(f[0])-1);
			}
		}
		for(Integer node:toVisit){
			int distance=getLengthBFS(paths,input2-1,node);
			if(distance==-1) {
				sol=-1;
				break;
			}else{
				sol=Math.max(sol, distance);
			}
		}
		System.out.println(sol);
	}
	
	public static int getLengthBFS(HashSet<Integer>[] paths,int source,int destination){
		int path=-1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		boolean[] visited=new boolean[paths.length];
		boolean found=false;
		while(queue.size()>0){
			path++;
			int size=queue.size();
			for(int i=0;i<size;i++){
				int idx=queue.poll();
				visited[idx]=true;
				if(idx==destination) {
					found=true;
					return path;
				}
				for(Integer list : paths[idx]){
					if(!visited[list])
						queue.add(list);
				}
			}
		}
		if(!found) return -1;
		else
			return path;
	}
	
}
