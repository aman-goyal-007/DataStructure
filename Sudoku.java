import java.util.HashSet;

public class Sudoku {
	static int length=9;
	static int squareOf=3;
	public static void main(String...args){
		
		int[][] n = {
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		/* answer should be
  3 1 6 5 7 8 4 9 2
  5 2 9 1 3 4 7 6 8
  4 8 7 6 2 9 5 3 1
  2 6 3 4 1 5 9 8 7
  9 7 4 8 6 3 1 2 5
  8 5 1 7 9 2 6 4 3
  1 3 8 9 4 7 2 5 6
  6 9 2 3 5 1 8 7 4
  7 4 5 2 8 6 3 1 9*/
		solve(n);
		for(int i=0;i<length;i++){	for(int j=0;j<length;j++){	System.out.print(n[i][j]+"-");	}	System.out.println("");	}
	}
	
	
	
	public static boolean solve(int[][] sudoku){
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(sudoku[i][j]!=0)continue; // means this location is filled up
				for(int k=1;k<=length;k++){
					sudoku[i][j]=k;
					if(isValid(sudoku, i, j) && solve(sudoku)){
						return true;
					}else
						sudoku[i][j]=0;
					
				}
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValid(int[][] sudoku,int i,int j){
		boolean isValid=true;
		HashSet<Integer> set = new HashSet<>();
		for(int m=0;m<length;m++){
			if(set.contains(sudoku[i][m])){
				isValid=false;
				break;
			}
			else{
				if(sudoku[i][m]!=0)
					set.add(sudoku[i][m]);
			}
		}
		if(!isValid) return false;
		set.clear();
		for(int m=0;m<length;m++){
			if(set.contains(sudoku[m][j])){
				isValid=false;
				break;
			}
			else{
				if(sudoku[m][j]!=0)
					set.add(sudoku[m][j]);
			}
		}
		if(!isValid) return false;
		set.clear();
		for(int m=0;m<squareOf;m++){
			for(int n=0;n<squareOf;n++){
				int x=i/squareOf*squareOf+m;
				int y=j/squareOf*squareOf+n;
				if(set.contains(sudoku[x][y])){
					isValid=false;
					break;
				}
				else{
					if(sudoku[x][y]!=0)
						set.add(sudoku[x][y]);
				}
			}
		}
		return isValid;
	}

}
















