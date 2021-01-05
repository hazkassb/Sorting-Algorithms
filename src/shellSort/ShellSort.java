package shellSort;

import java.util.Arrays;


/**
 * 
 * @author HamzaKassomou
 * 
 * Implements the shell sort algorithm  ==> O(nlogn) ~= O(n^[3/2]) or better performance
 */

public class ShellSort {
	/** Sort the table using Shell sort algorithm. 
	 * @pre table contains Comparable objects. 
	 * @post table is sorted. 
	 * @param table The array to be sorted 
	 */ 
	public static <T extends Comparable<T>> void sort(T[] table) { 
		// Gap between adjacent elements. 
		int gap = table.length / 2;
		
		while (gap > 0) { 
			for (int nextPos = gap; nextPos < table.length; nextPos++) { 
				// Insert element at nextPos in its subarray. 
				insert(table, nextPos, gap);
			} // End for. 
			
			// Reset gap for next pass. 
			if (gap == 2) { 
				gap = 1; 	
			} else { 
				gap = (int) (gap / 2.2);
			}
	
		} // End while.
	
	}	//End sort.
	
	
	/** Inserts element at nextPos where it belongs in array. 
	 * @pre Elements through nextPos ‐ gap in subarray are sorted. 
	 * @post Elements through nextPos in subarray are sorted.
	 * @param table The array being sorted 
	 * @param nextPos The position of element to insert 
	 * @param gap The gap between elements in the subarray
	 */
	private static <T extends Comparable<T>> void insert(T[] table, int nextPos, int gap) {
		T nextVal = table[nextPos]; 
		// Element to insert. 
		// Shift all values > nextVal in subarray down by gap. 
		while ((nextPos > gap - 1) && (nextVal.compareTo (table [nextPos - gap]) < 0)) {  // First element not shifted. 
			table[nextPos] = table[nextPos - gap];  // Shift down. 
			nextPos -= gap;  // Check next position in subarray.
		} 
		
		table[nextPos] = nextVal;  // Insert nextVal."
	}
	
	
	//LET'S TEST THE METHOD
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {40, 35, 80, 75, 90, 70, 75, 50, 22};
		
		System.out.println("Before: "+ Arrays.toString(arr));
		
		ShellSort.sort(arr);
		
		System.out.println("After: "+ Arrays.toString(arr));
	}	
} 
