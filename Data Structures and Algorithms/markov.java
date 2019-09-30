/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Markov Finder
 */

public class markov 
{
	public static void main(String[] args) {
	    int[][] A = {
	            {3, 4, 8, 9, 3},
	            {2, 10, 4, 2, 1},
	            {8, 1, 4, 8, 0},
	            {3, 5, 2, 12, 3},
	            {8, 1, 1, 2, 2},
	    };

	    int target = 19;

	    for (int i = 1; i < A.length; i++)
	        for (int j = 0; j < A[i].length; j++)
	            A[i][j] += A[i - 1][j];


	    for (int i1 = 0; i1 < A.length; i1++) {
	        for (int i2 = i1 + 1; i2 < A.length; i2++) {
	            int j1=0, j2=0, s=0;

	            while(j2<A[i1].length) {
	                while(s<target && j2<A[i1].length) {
	                    s += A[i2][j2] - (i1 > 0 ? A[i1-1][j2] : 0);
	                    j2++;
	                    if (s==target)
	                        System.out.println(String.format("Found between (%d,%d) and (%d,%d)", i1, j1, i2, j2-1));
	                }
	                while(s>=target) {
	                    s -= A[i2][j1] - (i1 > 0 ? A[i1-1][j1] : 0);
	                    j1++;
	                    if (s==target)
	                        System.out.println(String.format("Found between (%d,%d) and (%d,%d)", i1, j1, i2, j2));
	                }
	            }
	        }
	    }
	}
}
