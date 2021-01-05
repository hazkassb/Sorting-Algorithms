package selectionSort;

import java.util.Arrays;

/**
 * 
 * @author HamzaKassomou
 *
 * Implements the selection sort algorithm		==> Time Complexity: O(n^2)
 */

public class SelectionSort {
	/** Sort the array using selection sort algorithm. 
	 * @pre table contains Comparable objects. 
	 * @post table is sorted. 
	 * @param table The array to be sorted 
	 */ 
	public static <T extends Comparable<T>> void sort(T[] table) { 
		
		int n = table.length; 
		
		for (int fill = 0; fill < n - 1; fill++) { 
			// Invariant: table[0 . . . fill – 1] is sorted. 
			int posMin = fill; 
			
			for (int next = fill + 1; next < n; next++) { 
				// Invariant: table[posMin] is the smallest item in 
				// table[fill . . . next ‐ 1].
				if (table[next].compareTo(table[posMin]) < 0) { 
					posMin = next; 	
				} 
				
				// assert: table[posMin] is the smallest item in 
				// table[fill . . . n ‐ 1]. 
				// Exchange table[fill] and table[posMin]. 
				T temp = table[fill]; 
				table[fill] = table[posMin]; 
				table[posMin] = temp; 
//				System.out.println(Arrays.deepToString(table)); uncomment this line to trace number of swaps
				// assert: table[fill] is the smallest item in 
				// table[fill . . . n ‐ 1]. 
			}
			// assert: table[0 . . . n ‐ 1] is sorted.
		}
	}
	
	
	
	//LET'S TEST THE METHOD WITH SOME INTEGERS
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {40, 35, 80, 75, 90, 70, 75, 50, 22};
		
//		System.out.println("Before: "+ Arrays.deepToString(arr));
		
		SelectionSort.sort(arr);
		
		System.out.println("After: "+ Arrays.deepToString(arr));
	}
	

}
