package mergeSort;

/**
 * 
 * @author HamzaBoubacar
 *
 *	Implements the recursive merge sort algorithm. In this version, copies
 *	of the sub-arrays are made, sorted, and then merged
 */

public class MergeSort {
	
	/** Merge two sequences
	 * @pre leftSequence and rightSequence are sorted
	 * @post outputSequence is the merged result and is sorted
	 * @param outputSequence The destination
	 * @param leftSequence The left input
	 * @param rightSequence The right sequence
	 */
	private static <T extends Comparable<T>> void merge(T[] outputSequence, 
														T[] leftSequence,
														T[] rightSequence) {
		
//		Index into the left input sequence
		int i = 0;
		
//		Index into the right input sequence
		int j = 0;
		
//		Index into the output sequence
		int k  = 0;
		
//		While there is data in both input sequences
		while(i < leftSequence.length && j < rightSequence.length) {
			//Find the smaller and insert it into the output sequence
			if(leftSequence[i].compareTo(rightSequence[j]) < 0) {
				outputSequence[k] = leftSequence[i];
				k++;
				i++;
			} else {
				outputSequence[k] = rightSequence[j];
				k++;
				j++;
			}
			
		}
		
		// assert: ont of the sequences has more items to copy
		// Copy remaining input from left sequence into the output.
		while(i < leftSequence.length) {
			outputSequence[k++] = leftSequence[i++];
		}
		
		// Copy remaining input from right sequence into the output.
		while(j < rightSequence.length) {
			outputSequence[k++] = rightSequence[j++];
		}
	}
	
	
	
	/** Sort the array using the merge sort algorithm
	 * @pre: table contains the Comparable objects
	 * @post: table is sorted
	 * @param table The array to be sorted
	 */
	public static <T extends Comparable<T>> T[] sort(T[] table) {
//		A table of size less than or equal to one element is sorted already
		
		if(table.length > 1) {
			// Split table into two halves
			int halfSize = table.length / 2;
			T[] leftTable =  (T[]) new Comparable[halfSize];
			T[] rightTable = (T[]) new Comparable[table.length -  halfSize];
			System.arraycopy(table, 0, leftTable, 0, halfSize);
			System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);
			
			// Sort the halves
			sort(leftTable);
			sort(rightTable);
			
			// Merge the halved
			merge(table, leftTable, rightTable);
		}
		
		return table;
	}
	
	public static <T> String toString(T[] table) {
		String result = "";
		for(T  t: table) {
			result += String.valueOf(t) + " ";
		}
		
		return result;
	}
	
	
//	Testing the merge sort algorithm
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		Integer[] arr = {55, 50, 10, 40, 80, 60, 90, 100, 70, 80, 20, 50, 22};
		
		String str = toString(sort(arr));
		System.out.println(str);
	}
	
}
