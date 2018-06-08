package hw2;

import java.util.Random;


public class ComparePerformance {
	

	
	// Standard Insertion Sort
	public static void InsertionSort(int [] array){
		for (int i = 1; i < array.length; i++){
			int tmp = array[i];
			int j;
			for (j = i-1; j >= 0 && tmp < array[j]; j--){
				array[j + 1] = array[j];
			}
			array[j + 1] = tmp;
		}
	}
	
	
	
	// Classic Merge Sort
	 public static void mergeSort(int[] array) {
	        int size = array.length;
	        
	        if (size < 2)
	            return;
	        
	        int mid = size / 2;
	        int leftSize = mid;
	        int rightSize = size - mid;
	        int[] leftHalf = new int[leftSize];
	        int[] rightHalf = new int[rightSize];
	        
	        for (int i = 0; i < mid; i++) {
	            leftHalf[i] = array[i];
	        }
	        
	        for (int i = mid; i < size; i++) {
	            rightHalf[i - mid] = array[i];
	        }
	        
	        mergeSort(leftHalf);
	        mergeSort(rightHalf);
	        mergeEm(leftHalf, rightHalf, array);
	    }

	 
	    public static void mergeEm(int[] leftHalf, int[] rightHalf, int[] array) {
	        int leftSize = leftHalf.length;
	        int rightSize = rightHalf.length;
	        int i = 0, j = 0, k = 0;
	        
	        while (i < leftSize && j < rightSize) {
	            if (leftHalf[i] <= rightHalf[j]) {
	                array[k] = leftHalf[i];
	                i++;
	                k++;
	            } else {
	                array[k] = rightHalf[j];
	                k++;
	                j++;
	            }
	        }
	        
	        while (i < leftSize) {
	            array[k] = leftHalf[i];
	            k++;
	            i++;
	        }
	        
	        while (j < leftSize) {
	            array[k] = rightHalf[j];
	            k++;
	            j++;
	        }
	    }
	
	
	    
	// Creates an arrays of length provided and fills it with random values from -10^6 to 10^6
	public static int [] makeRandIntArray (int length){
		int [] array = new int [length];
		Random random = new Random();
		
		for (int i = 0; i < length; i++){
			array[i] = random.nextInt(2000000) - 1000000;
		}
		
		return array;
	}
	
	
	
	// Creates and returns a copy of the list provided
	public static int [] makeListCopy(int [] list){
		int size = list.length;
		int [] copyOfList = new int [size];
		for (int i = 0; i < size; i++){
			copyOfList[i] = list[i];
		}
		return copyOfList;
	}
	
	
	
	// Make sure the array is actually sorted correctly [Used to test]
	public static boolean isSorted(int [] array){
		for(int i = 0; i < array.length-1; i++){
			if(array[i] > array[i+1]){
				return false;
			}
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		
		// Create our data sets to be sorted
		int [] random1024 = makeRandIntArray(1024);
		int [] random4096 = makeRandIntArray(4096);
		int [] random16384 = makeRandIntArray(16384);
		int [] random65536 = makeRandIntArray(65536);
		int [] random262144 = makeRandIntArray(262144);
		
	
		
	// Merge Sort Tests
		System.out.println("Testing Merge Sort...");
		
		// Test Merge Sort on Size 1024
		int [] copyMerge1024 = makeListCopy(random1024);
		assert !isSorted(copyMerge1024);
		long MergeStart1024 = System.currentTimeMillis();
		mergeSort(copyMerge1024);
		long MergeEnd1024 = System.currentTimeMillis();
		long MergeTime1024 = MergeEnd1024 - MergeStart1024;
		assert isSorted(copyMerge1024);
		
		// Test Merge Sort on Size 4096
		int [] copyMerge4096 = makeListCopy(random4096);
		assert !isSorted(copyMerge4096);
		long MergeStart4096 = System.currentTimeMillis();
		mergeSort(copyMerge4096);
		long MergeEnd4096 = System.currentTimeMillis();
		long MergeTime4096 = MergeEnd4096 - MergeStart4096;
		assert isSorted(copyMerge4096);
		
		// Test Merge Sort on Size 16384
		int [] copyMerge16384 = makeListCopy(random16384);
		assert !isSorted(copyMerge16384);
		long MergeStart16384 = System.currentTimeMillis();
		mergeSort(copyMerge16384);
		long MergeEnd16384 = System.currentTimeMillis();
		long MergeTime16384 = MergeEnd16384 - MergeStart16384;
		assert isSorted(copyMerge16384);
		
		// Test Merge Sort on Size 65536
		int [] copyMerge65536 = makeListCopy(random65536);
		assert !isSorted(copyMerge65536);
		long MergeStart65536 = System.currentTimeMillis();
		mergeSort(copyMerge65536);
		long MergeEnd65536 = System.currentTimeMillis();
		long MergeTime65536 = MergeEnd65536 - MergeStart65536;
		assert isSorted(copyMerge65536);
			
		// Test Merge Sort on Size 262144
		int [] copyMerge262144 = makeListCopy(random262144);
		assert !isSorted(copyMerge262144);
		long MergeStart262144 = System.currentTimeMillis();
		mergeSort(copyMerge262144);
		long MergeEnd262144 = System.currentTimeMillis();
		long MergeTime262144 = MergeEnd262144 - MergeStart262144;
		assert isSorted(copyMerge262144);
	
		
		
	// Hybrid Sort Tests	
		System.out.println("Testing Hybrid Sort...");
		
		// Test Hybrid Sort on size 1024 array 
		int [] copyHyb1024 = makeListCopy(random1024);
		assert !isSorted(copyHyb1024);
		long HybStart1024 = System.currentTimeMillis();
		int [] Hyb1024 = HybridSort.ArrayInsertionSort(copyHyb1024);
		long HybEnd1024 = System.currentTimeMillis();
		long HybTime1024 = HybEnd1024 - HybStart1024;
		assert isSorted(Hyb1024);
		
		// Test Hybrid Sort on size 4096 array 
		int [] copyHyb4096 = makeListCopy(random4096);
		assert !isSorted(copyHyb4096);
		long HybStart4096 = System.currentTimeMillis();
		int [] Hyb4096 = HybridSort.ArrayInsertionSort(copyHyb4096);
		long HybEnd4096 = System.currentTimeMillis();
		long HybTime4096 = HybEnd4096 - HybStart4096;
		assert isSorted(Hyb4096);
		
		// Test Hybrid Sort on size 16384 array 
		int [] copyHyb16384 = makeListCopy(random16384);
		assert !isSorted(copyHyb16384);
		long HybStart16384 = System.currentTimeMillis();
		int [] Hyb16384 = HybridSort.ArrayInsertionSort(copyHyb16384);
		long HybEnd16384 = System.currentTimeMillis();
		long HybTime16384 = HybEnd16384 - HybStart16384;
		assert isSorted(Hyb16384);
		
		// Test Hybrid Sort on size 65536 array 
		int [] copyHyb65536 = makeListCopy(random65536);
		assert !isSorted(copyHyb65536);
		long HybStart65536 = System.currentTimeMillis();
		int [] Hyb65536 = HybridSort.ArrayInsertionSort(copyHyb65536);
		long HybEnd65536 = System.currentTimeMillis();
		long HybTime65536 = HybEnd65536 - HybStart65536;
		assert isSorted(Hyb65536);
		
		// Test Hybrid Sort on size 262144 array 
		int [] copyHyb262144 = makeListCopy(random262144);
		assert !isSorted(copyHyb262144);
		long HybStart262144 = System.currentTimeMillis();
		int [] Hyb262144 = HybridSort.ArrayInsertionSort(copyHyb262144);
		long HybEnd262144 = System.currentTimeMillis();
		long HybTime262144 = HybEnd262144 - HybStart262144;
		assert isSorted(Hyb262144);

		
		
	// Insertion Sort Tests
		System.out.println("Testing Insertion Sort...");
		
		// Test Insertion Sort on Size 1024
		int [] copyIns1024 = makeListCopy(random1024);
		assert !isSorted(copyIns1024);
		long InsStart1024 = System.currentTimeMillis();
		InsertionSort(copyIns1024);
		long InsEnd1024 = System.currentTimeMillis();
		long InsTime1024 = InsEnd1024 - InsStart1024;
		assert isSorted(copyIns1024);
		
		// Test Insertion Sort on Size 4096
		int [] copyIns4096 = makeListCopy(random4096);
		assert !isSorted(copyIns4096);
		long InsStart4096 = System.currentTimeMillis();
		InsertionSort(copyIns4096);
		long InsEnd4096 = System.currentTimeMillis();
		long InsTime4096 = InsEnd4096 - InsStart4096;
		assert isSorted(copyIns4096);
		
		// Test Insertion Sort on Size 16384
		int [] copyIns16384 = makeListCopy(random16384);
		assert !isSorted(copyIns16384);
		long InsStart16384 = System.currentTimeMillis();
		InsertionSort(copyIns16384);
		long InsEnd16384 = System.currentTimeMillis();
		long InsTime16384 = InsEnd16384 - InsStart16384;
		assert isSorted(copyIns16384);
		
		// Test Insertion Sort on Size 65536
		int [] copyIns65536 = makeListCopy(random65536);
		assert !isSorted(copyIns65536);
		long InsStart65536 = System.currentTimeMillis();
		InsertionSort(copyIns65536);
		long InsEnd65536 = System.currentTimeMillis();
		long InsTime65536 = InsEnd65536 - InsStart65536;
		assert isSorted(copyIns65536);
		
		// Test Insertion Sort on Size 262144
		int [] copyIns262144 = makeListCopy(random262144);
		assert !isSorted(copyIns262144);
		long InsStart262144 = System.currentTimeMillis();
		InsertionSort(copyIns262144);
		long InsEnd262144 = System.currentTimeMillis();
		long InsTime262144 = InsEnd262144 - InsStart262144;		
		assert isSorted(copyIns262144);
		
		

		
		
		// Print the time taken in milliseconds for each sort method on lists sizes (1024, 4096, 16384, 65536, and 262144
		System.out.println("===============================================================================================");
		System.out.println("                |     1024     |     4096     |     16384     |     65536     |     262144     ");
		System.out.println("===============================================================================================");
		System.out.format ("Merge  Sort     |" + "%,14d" + "|" + "%,14d" + "|" + "%,15d" + "|" + "%,15d" + "|" + "%,16d%n", MergeTime1024, MergeTime4096, MergeTime16384, MergeTime65536, MergeTime262144);
		System.out.format ("Hybrid Sort     |" + "%,14d" + "|" + "%,14d" + "|" + "%,15d" + "|" + "%,15d" + "|" + "%,16d%n", HybTime1024, HybTime4096, HybTime16384, HybTime65536, HybTime262144);
		System.out.format ("Insert Sort     |" + "%,14d" + "|" + "%,14d" + "|" + "%,15d" + "|" + "%,15d" + "|" + "%,16d%n", InsTime1024, InsTime4096, InsTime16384, InsTime65536, InsTime262144);
		System.out.println("===============================================================================================");
		System.out.println("                                                                                               ");
		System.out.println("===============================================================================================");
		
	}

}
