
import java.util.ArrayList;
import java.util.List;

public class CoinChange {
   public static void main(String[] args) {
        int[] denomination = {1,2,3};
        howManyWays(denomination,4);
        minNoOfCoinsRequired(denomination,4);
    }

//bottom up tabulation approach
    /*
    In this approach we are using table of previous solution.

1
2	4
3							0	1	2	3	4
							1	1	1	1	1
							1	1	2	2	3
							1	1	2	3	4
     */
    public static void howManyWays(int[] denomination, int total){
        int table[] = new int[total+1];
        table[0] = 1;
        for(int i=0;i<denomination.length;i++){
            for(int j=denomination[i];j<=total;j++){
                table[j] += table[j-denomination[i]];
            }
           // printArr(table);
        }
        System.out.println("Total no of ways : "+table[total]);
    }

    /*

    http://www.ccs.neu.edu/home/jaa/CSG713.04F/Information/Handouts/dyn_prog.pdf


    Recursively Define the Value of the Optimal Solution. First, we define in English the quantity
we shall later define recursively. Let C[p] be the minimum number of coins of denominations d1, d2, . . . , dk
needed to make change for p cents. In the optimal solution to making change for p cents, there must exist
some first coin di
, where di ≤ p. Furthermore, the remaining coins in the optimal solution must themselves
be the optimal solution to making change for p − di cents, since coin changing exhibits optimal substructure
as proven above. Thus, if di
is the first coin in the optimal solution to making change for p cents, then
C[p] = 1 +C[p−di
]; i.e., one di coin plus C[p−di
] coins to optimally make change for p−di cents. We don’t
know which coin di
is the first coin in the optimal solution to making change for p cents; however, we may
check all k such possibilities (subject to the constraint that di ≤ p), and the value of the optimal solution
must correspond to the minimum value of 1 + C[p − di
], by definition. Furthermore, when making change
for 0 cents, the value of the optimal solution is clearly 0 coins. We thus have the following recurrence.
Claim 2 C[p] = 
0 if p = 0
mini:di≤p{1 + C[p − di
]} if p > 0
     */
    public static void  minNoOfCoinsRequired(int[] denomination, int total){
        int[] solutionArr = new int[total+1];
        Arrays.fill(solutionArr,Integer.MAX_VALUE);
        solutionArr[0] = 0;
        int setOfCoin[] = new int[total+1];

        for(int i=1;i<=total;i++){
            for(int j=0;j<denomination.length;j++){
                if(denomination[j]<=i) {
                    if(solutionArr[i - denomination[j]]!= Integer.MAX_VALUE && ((solutionArr[i-denomination[j]]+1)<solutionArr[i])) {
                        solutionArr[i] = Integer.min(solutionArr[i - denomination[j]] + 1, solutionArr[i]);
                        setOfCoin [i]=j;
                    }
                }
            }
        }

        System.out.println("Minimum no of coins required : "+solutionArr[total]);


        // Printing set of required coins
        System.out.println("Set of coins to get the change of : "+total);
        while(total>0){
            System.out.println(setOfCoin[total]);
            total = total-denomination[setOfCoin[total]];
        }
    }

    public static void printArr(int[] arr){
        for(int a=0;a<arr.length;a++) System.out.print(arr[a]+" ");
        System.out.println("");
    }
}


