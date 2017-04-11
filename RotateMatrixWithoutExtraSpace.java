
public class RotateMatrixWithoutExtraSpace {

	static int length=0;
	public static void main(String...args){
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		length=matrix.length;
		length--;
		rotateBy90Degree(matrix);
	}
	
	static void rotateBy90Degree(int[][] matrix){
		System.out.println("Before Rotation");
		printMatrix(matrix);
		rotate(matrix,0,0,0,-1);
		for(int i=0;i<=(length/2);i++){
			for(int j=1;j<(length-i);j++){
				rotate(matrix,i,j,0,-1);
			}
		}
		System.out.println("After Rotation");
		printMatrix(matrix);
	}
	static void rotate(int[][] matrix,int i,int j,int count,int data){
		if(count==(length+1)){
			matrix[i][j]=data;
			return;
		}
		else{
			int _i=length-j;
			int _j=i;
			int element=matrix[i][j];
			rotate(matrix,_i,_j,++count,element);
			matrix[_i][_j]=element;
		}
	}
	static void printMatrix(int[][] matrix){
		for(int i=0;i<=length;i++){
			for(int j=0;j<=length;j++){
				System.out.print(matrix[i][j]+"|");
			}
			System.out.println();
		}
	}
}
