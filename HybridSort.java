package hw2;

public class HybridSort {
	
	// Creates a copy of the array between a lo and hi index
	public static int [] copySubArray (int [] array, int lo, int hi){
		int CopySize = hi - lo + 1;
		int [] copy = new int [CopySize];
		int j = 0;
		for (int i = lo; i < hi; i++){
			copy[j] = array[i];
			j++;
		}
		return copy;
	}


	public static int [] ArrayInsertionSort (int [] array){ 
		int hi = array.length / 2;
		int lo = 0;
		
		// If the array is small enough use insertion sort on it
		if(array.length < 33){
			for (int i = 1; i < array.length; i++){
				int tmp = array[i];
				int j;
				for (j = i-1; j >= 0 && tmp < array[j]; j--){
					array[j + 1] = array[j];
				}
				array[j + 1] = tmp;
			}
		return array;
		}
		
		// Array size is > 33 so we can split, recursively call, and merge results
		// Sort First Half
		int [] FirstHalfSorted = copySubArray (array, lo, hi);
		FirstHalfSorted = ArrayInsertionSort (FirstHalfSorted);
		
		// Sort Second Half
		int [] SecondHalfSorted = copySubArray (array, hi + 1, array.length);
		SecondHalfSorted = ArrayInsertionSort (SecondHalfSorted);
		
		// Merge both sorted halves into a single sorted array
		int [] MergedSortedHalves = new int[FirstHalfSorted.length + SecondHalfSorted.length];
		if(array.length >= 33){		
			// Compare each element from both arrays and place the smallest in our merged array until one array is empty
			int i = 0, j = 0, k = 0;
			while (i < FirstHalfSorted.length && j < SecondHalfSorted.length){
				if (FirstHalfSorted[i] < SecondHalfSorted[j]){
					MergedSortedHalves[k] = FirstHalfSorted[i];
					i++;
				} else{
					MergedSortedHalves[k] = SecondHalfSorted[j];
					j++;
				}
				k++;
			}
			
			// If FirstHalfSorted still has contents then add them to the end of the MergedSortedHalves array
			while (i < FirstHalfSorted.length){
				MergedSortedHalves[k] = FirstHalfSorted[i];
				i++;
				k++;
			}
			
			// If SecondHalfSorted still has contents then add them to the end of the MergedSortedHalves array
			while (j < SecondHalfSorted.length){
				MergedSortedHalves[k] = SecondHalfSorted[j];
				j++;
				k++;
			}
		}
		return MergedSortedHalves;
	}
}
