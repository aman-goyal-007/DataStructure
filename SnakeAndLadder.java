import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

//This problem will be handled using BFS in a graph.
public class SnakeAndLadder {
	final int DESTINATION_BLOCK=30;
	int[] board = new int[DESTINATION_BLOCK]; // //creating vertices
	int[] distanceArray = new int[DESTINATION_BLOCK];

	

	//Initializing the board
	public SnakeAndLadder() {
		//1. First each vertex can reach to next 6 vertex. Creating those edges
		for(int i=0;i<DESTINATION_BLOCK;i++){
				board[i]=i;
		}
		
		//2. Now you can add snakes and ladder by modifying the reachable blocks. Remove existing reachable block and add new reachable.
		//Ladder
		board[2] = 21;
		board[3] = 29;
		board[4] = 7;
		board[10] = 25;
		board[19] = 28;
			 
		//Snakes
		board[26] = 0;
		board[20] = 8;
		board[16] = 3;
		board[18] = 6;
	}
	
	
	public void findMinimumDiceThrows(){
		Queue<Integer> queue = new LinkedList<>();
		BitSet visited = new BitSet();
		queue.add(board[0]);
		while(!queue.isEmpty()){
			int number = queue.peek();
			if(number==(DESTINATION_BLOCK-1))
					break;
			queue.poll();
			int dist = distanceArray[number];
			for(int j=(number);j<(number+6) && j<DESTINATION_BLOCK;j++){
				if(!visited.get(j)){
					distanceArray[board[j]]=dist+1;
				if(board[j]!=j) visited.set(j);	
				visited.set(board[j]);
				queue.add(board[j]);
				}
			}
			
		}
		System.out.println("Here we are :"+distanceArray[29]);
		
		
		
	}
	public static void main(String...args){
		SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
		snakeAndLadder.findMinimumDiceThrows();
	}
	

}
