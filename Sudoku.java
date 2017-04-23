import java.util.Arrays;
import java.util.HashSet;

public class Sudoku {
	static int max=0;
	public static void main(String...args){
		
		int[][] n = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
		};
/*		int[][] n = {
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
*/		/* answer should be
  3 1 6 5 7 8 4 9 2
  5 2 9 1 3 4 7 6 8
  4 8 7 6 2 9 5 3 1
  2 6 3 4 1 5 9 8 7
  9 7 4 8 6 3 1 2 5
  8 5 1 7 9 2 6 4 3
  1 3 8 9 4 7 2 5 6
  6 9 2 3 5 1 8 7 4
  7 4 5 2 8 6 3 1 9*/
//		solve(n);
		System.out.println(SolveMagicSquare(n));
//		for(int i=0;i<4;i++){	for(int j=0;j<4;j++){	System.out.print(n[i][j]+"-");	}	System.out.println("");	}
	}
	
	
	public static int SolveMagicSquare(int[][] input1){
		int length=input1[0].length;
		int squareOf=0;
		for(int i=0;i<length;i++){
			if(length==(i*i)){
				squareOf=i;
				break;
			}
		}
		if(solve(input1,length,squareOf))return 1;
		else return 0;
		
	}
	public static boolean solve(int[][] sudoku,int length,int squareOf){
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(sudoku[i][j]!=0)continue; // means this location is filled up
				for(int k=1;k<=length;k++){
					sudoku[i][j]=k;
					if(isValid(sudoku, i, j,length,squareOf) && solve(sudoku,length,squareOf)){
						return true;
					}else
						sudoku[i][j]=0;
					
				}
				return false;
			}
		}
		return true;
	}
	
	static boolean checkRowValdation(int[][] sudoku,int i,int j,int length,int squareOf){
		HashSet<Integer> set = new HashSet<>();
		for(int m=0;m<length;m++){
			if(set.contains(sudoku[i][m])){
				return false;
			}
			else{
				if(sudoku[i][m]!=0)
					set.add(sudoku[i][m]);
			}
		}
		return true;
	}
	static boolean checkColumnValdation(int[][] sudoku,int i,int j,int length,int squareOf){
		HashSet<Integer> set = new HashSet<>();
		for(int m=0;m<length;m++){
			if(set.contains(sudoku[m][j])){
				return false;
			}
			else{
				if(sudoku[m][j]!=0)
					set.add(sudoku[m][j]);
			}
		}
		return true;
	}
	static boolean checkBlockValdation(int[][] sudoku,int i,int j,int length,int squareOf){
		HashSet<Integer> set = new HashSet<>();
		for(int m=0;m<squareOf;m++){
			for(int n=0;n<squareOf;n++){
				int x=i/squareOf*squareOf+m;
				int y=j/squareOf*squareOf+n;
				if(set.contains(sudoku[x][y])){
					return false;
				}
				else{
					if(sudoku[x][y]!=0)
						set.add(sudoku[x][y]);
				}
			}
		}
		return true;
	}
	public static boolean isValid(int[][] sudoku,int i,int j,int length,int squareOf){
		boolean isValid=true;
		isValid=checkRowValdation(sudoku, i, j,length,squareOf);
		if(!isValid) return false;
		isValid=checkColumnValdation(sudoku, i, j,length,squareOf);
		if(!isValid) return false;
		isValid=checkBlockValdation(sudoku, i, j,length,squareOf);
		if(!isValid) return false;
		
		isValid=validateSwap(sudoku, (i/squareOf)*squareOf, (j/squareOf)*squareOf,length,squareOf);
		if(!isValid) return false;

		return isValid;
	}
	
	
	/*
	 * This is to verify if adjacent blocks are swapped, condition should not break.
	 * This is as per Tech Gig problem ( Deloitte challenge )
	 * https://www.techgig.com/codegladiators/question/OTEwM0AjJEAjJDEyMTI5NUAjJEAjJDQzNjAwNzVAIyRAIyQxNDkyOTI4OTgy/1
	 */
	public static boolean validateSwap(int[][] sudoku,int i,int j,int length,int squareOf){
		boolean isValid=true;
	//	System.out.println("Aman "+max++);
		if(i+squareOf<length){
		//	System.out.println("Aaa "+i+","+j);
			isValid=swapAndVerifyRow(sudoku, i, j, i+squareOf, j,length,squareOf);
			if(!isValid) return false;
			isValid=swapAndVerifyColumn(sudoku, i, j, i+squareOf, j,length,squareOf);
			if(!isValid) return false;
		}
		if(j+squareOf<length){
			isValid=swapAndVerifyRow(sudoku, i, j, i, j+squareOf,length,squareOf);
			if(!isValid) return false;
			isValid=swapAndVerifyColumn(sudoku, i, j, i, j+squareOf,length,squareOf);
			if(!isValid) return false;
		}
		if(i!=0){
			isValid=swapAndVerifyRow(sudoku, i, j, i-squareOf, j,length,squareOf);
			if(!isValid) return false;
			isValid=swapAndVerifyColumn(sudoku, i, j, i-squareOf, j,length,squareOf);
			if(!isValid) return false;
		}
		if(j!=0){
			isValid=swapAndVerifyRow(sudoku, i, j, i, j-squareOf,length,squareOf);
			if(!isValid) return false;
			isValid=swapAndVerifyColumn(sudoku, i, j, i, j-squareOf,length,squareOf);
			if(!isValid) return false;
		}
		return isValid;
	}
	
	public static boolean swapAndVerifyRow(int[][] sudoku,int a,int b,int c,int d,int length,int squareOf){
		boolean isValid=true;
		HashSet<Integer> set = new HashSet<>();
		if(a==c) return true;
		//Row validation logic
		for(int i=0;i<squareOf;i++){
			set.clear();
			for(int j=0;j<length;j++){
				if(sudoku[a][j]!=0)
					set.add(sudoku[a][j]);
			}
			for(int j=b;j<b+squareOf;j++){
				set.remove(sudoku[a][j]);
			}
			for(int j=d;j<d+squareOf;j++){
				if(set.contains(sudoku[c][j])){
					return false;
				}else{
					if(sudoku[c][j]!=0)
						set.add(sudoku[c][j]);
				}
			}
			a++;
			c++;
		}
		
		return isValid;
	}
	public static boolean swapAndVerifyColumn(int[][] sudoku,int a,int b,int c,int d,int length,int squareOf){
		boolean isValid=true;
		if(b==d) return true;
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<squareOf;i++){
			set.clear();
			for(int j=0;j<length;j++){
				if(sudoku[j][b]!=0)
					set.add(sudoku[j][b]);
			}
			for(int j=a;j<a+squareOf;j++){
				set.remove(sudoku[j][b]);
			}
			for(int j=c;j<c+squareOf;j++){
				if(set.contains(sudoku[j][d])){
					return false;
				}else{
					if(sudoku[j][d]!=0)
						set.add(sudoku[j][d]);
				}
			}
			b++;
			d++;
		}
		return isValid;
	}

}
















