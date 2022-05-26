/*
 * A1HizonAdrian
 * Comp 2140 Section A01
 * Instructor: Ackora
 * Assignment #1
 * Author: Adrian Hizon, 7867173
 * Date: Feb. 21, 2021
 * 
 * Purpose: Create a merge sort, quick sort, and radix sort then compare their runtimes.
 */

import java.util.*;

public class A1HizonAdrian {
	final static int ARRAY_SIZE = 60000;
	final static int NUM_SWAPS = (int) (0.25 * ARRAY_SIZE);
	final static int NUM_SORTS = 100;
	
	public static void main(String[] args) {
		testSorts(ARRAY_SIZE, NUM_SWAPS, NUM_SORTS);
	}

	public static String printArray(int[] a) {
		String s = "{" + a[0];
		for(int i = 1; i < a.length; i++) {
			s += ", " + a[i];
		}
		s += "}";
		return s;
	}
	
	public static void mergeSort(int[] a) {
		int[] tempArray = new int[a.length];
		mergeSort(a, 0, a.length, tempArray);
	}
	
	private static void mergeSort(int[] a, int start, int end, int[] temp) {
		if( (end - start) > 1) {
			int mid = start + ((end - start)/2);
			mergeSort(a, start, mid, temp);
			mergeSort(a, mid, end, temp);
			merge(a, start, mid, end, temp);
		}
	}
	
	private static void merge(int[] a, int start, int mid, int end, int[] temp) {
		int currL = start;
		int currR = mid;
		for(int i = start; i < end; i++) {
			if( (currL < mid) && ((currR >= end) || (a[currL] < a[currR])) ) {
				temp[i] = a[currL];
				currL++;
			}
			else {
				temp[i] = a[currR];
				currR++;
			}
		}
		System.arraycopy(temp, start, a, start, end - start);
	}
	
	public static void mergeSortInefficient(int[] a) {
		mergeSortInefficient(a, 0, a.length);
	}
	
	private static void mergeSortInefficient(int[] a, int start, int end) {
		if( (end - start) > 1) {
			int mid = start + ((end - start)/2);
			mergeSortInefficient(a, start, mid);
			mergeSortInefficient(a, mid, end);
			int[] tempArray = merge(a, start, mid, end);
			for(int i = 0; i < tempArray.length; i ++) {
				a[i + start] = tempArray[i];
			}
		}
	}
	
	private static int[] merge(int[] a, int start, int mid, int end) {
		int[] sortedArray = new int[end - start];
		int currL = start;
		int currR = mid;
		for(int i = 0; i < sortedArray.length; i++) {
			if( (currL < mid) && ((currR >= end) || (a[currL] < a[currR])) ) {
				sortedArray[i] = a[currL];
				currL++;
			}
			else {
				sortedArray[i] = a[currR];
				currR++;
			}
		}
		return sortedArray;
	}
	
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length);
	}
	
	private static void quickSort(int[] a, int start, int end) {
		int sortLength = end - start;
		if(sortLength > 2) {
			int pivotIndex = medianOfThree(a, start, end);
			pivotIndex = partition(a, start, end, pivotIndex);
			quickSort(a, start, pivotIndex);
			quickSort(a, pivotIndex, end);
		}
		else if(sortLength == 2){
			if(a[start] > a[end - 1]) {
				swap(a, start, end - 1);
			}
			return;
		}
	}
	
	public static int medianOfThree(int[] a, int start, int end) {
		int mid = start + ((end - start)/2);
		int right = end - 1;
		while(!(a[start] <= a[mid] && a[mid] <= a[right])) {
			if(a[start] > a[mid]) {
				swap(a, start, mid);
			}
			if(a[mid] > a[right]) {
				swap(a, mid, right);
			}
		}
		return mid;
	}
	
	public static int partition(int[] a, int start, int end, int pivot) {
		int bigStart = start + 1;
		swap(a, start, pivot);
		for(int current = start + 1; current < end; current ++) {
			if(a[current] <= a[start]) {
				swap(a, current, bigStart);
				bigStart++;
			}
		}
		pivot = bigStart - 1;
		swap(a, start, pivot);
		return pivot;
	}
	
	public static void radixSort(int[] a) {
		int maxInt = findMaxInt(a, 0, a.length);
		int numDigits = findNumDigits(maxInt);
		int[] tempArray = new int[a.length];
		radixSort(a, 0, a.length, numDigits, tempArray);
	}
	
	private static void radixSort(int[] a, int start, int end, int digits, int[] temp) {
		if((end - start) > 1) {
			int count[] = new int[10]; 
			count[0] = start;
			
			for(int i = start; i < end; i++) {
				int currentDigit = findDigit(a[i], digits);
				count[currentDigit]++;
			}
			
			for(int i = 1; i < count.length; i++) {
				count[i] += count[i-1];
			}
			
			for(int i = end - 1; i >= start; i--) {
				int currentDigit = findDigit(a[i], digits);
				temp[count[currentDigit] - 1] = a[i];
	            count[currentDigit]--;
			}
			
			for(int i = start; i < end; ++i) {
				a[i] = temp[i];
			}

			for(int m = 0; m < count.length - 1; m++) {
				radixSort(a, count[m], count[m + 1], digits - 1, temp);
			}
			radixSort(a, count[9], end, digits - 1, temp);
		}
	}
	
	public static int findMaxInt(int[] a, int start, int end) {
		int max = 0;
		for(int i = start; i < end; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	public static int findNumDigits(int i) {
		int numDigits = 0;
		while(i > 0) {
			i = i/10;
			numDigits++;
		}
		return numDigits;
	}
	
	public static int findDigit(int i, int pos) {
		int digit = 0;
		digit = (i / (int) Math.pow(10, pos - 1) % 10);
		return digit;
	}
	
	public static void bucketSort(int[] a) {
		
	}
	
	public static boolean verifySort(int[] a) {
		boolean sorted = true;
		for(int i = 1; i < a.length; i++) {
			if(a[i] < a[i - 1]) {
				sorted = false;
			}
		}
		return sorted;
	}
	
	public static void fillArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			a[i] = i;
		}
	}
	
	public static void swap(int[] a, int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}
	
	public static void randomizeArray(int[] a, int n) {
		int randPos1 = 0;
		int randPos2 = 0;
		for(int i = 0; i < n; i++) {
			randPos1 = (int) (Math.random() * a.length);
			do {
				randPos2 = (int) (Math.random() * a.length);
			}
			while(randPos2 == randPos1);
			swap(a, randPos1, randPos2);
		}
	}
	
	public static void testSorts(int arraySize, int numSwaps, int numSorts) {
		int[] testArray = new int[arraySize];
		fillArray(testArray);
		
		long[] mergeTimes = new long[numSorts];
		for(int i = 0; i < numSorts; i++) {
			randomizeArray(testArray, numSwaps);
			long startTime = System.currentTimeMillis();
			mergeSort(testArray);
			long endTime = System.currentTimeMillis();
			if(!(verifySort(testArray))) {
				System.out.println("The array was not sorted during merge sort.");
			}
			mergeTimes[i] = endTime - startTime;
		}
		double mergeSortMean = arithmeticMean(mergeTimes);
		
		long[] mergeIneffTimes = new long[numSorts];
		for(int i = 0; i < numSorts; i++) {
			randomizeArray(testArray, numSwaps);
			long startTime = System.currentTimeMillis();
			mergeSortInefficient(testArray);
			long endTime = System.currentTimeMillis();
			if(!(verifySort(testArray))) {
				System.out.println("The array was not sorted during inefficient merge sort.");
			}
			mergeIneffTimes[i] = endTime - startTime;
		}
		double mergeSortIneffMean = arithmeticMean(mergeIneffTimes);
		
		long[] quickTimes = new long[numSorts];
		for(int i = 0; i < numSorts; i++) {
			randomizeArray(testArray, numSwaps);
			long startTime = System.currentTimeMillis();
			quickSort(testArray);
			long endTime = System.currentTimeMillis();
			if(!(verifySort(testArray))) {
				System.out.println("The array was not sorted quick sort.");
			}
			quickTimes[i] = endTime - startTime;
		}
		double quickSortMean = arithmeticMean(quickTimes);
		
		long[] radixTimes = new long[numSorts];
		for(int i = 0; i < numSorts; i++) {
			randomizeArray(testArray, numSwaps);
			long startTime = System.currentTimeMillis();
			radixSort(testArray);
			long endTime = System.currentTimeMillis(); 
			if(!(verifySort(testArray))) {
				System.out.println("The array was not sorted radix sort.");
			}
			radixTimes[i] = endTime - startTime;
		}
		double radixSortMean = arithmeticMean(radixTimes);
		
		System.out.println("The mean of the merge sort times was: " + mergeSortMean + " ms.");
		System.out.println("The mean of the inefficient merge sort times was: " + mergeSortIneffMean + " ms.");
		System.out.println("The mean of the quick sort times was: " + quickSortMean + " ms.");
		System.out.println("The mean of the radix sort times was: " + radixSortMean + " ms.");
	}
	
	public static double arithmeticMean(long data[]) {
		double sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += (double) data[i];
		}
		return sum / (double) data.length;
	}
	
	/*
	 * Report
	 * 1. Algorithm              | arraySize | time (ms)
	 *    Merge Sort             | 5000      | 0.24
	 *    Merge Sort Inefficient | 5000      | 0.35
	 *    Quick Sort             | 5000      | 0.23
	 *    Radix Sort             | 5000      | 1.84
	 *    Merge Sort             | 10000     | 0.51
	 *    Merge Sort Inefficient | 10000     | 0.71
	 *    Quick Sort             | 10000     | 0.51
	 *    Radix Sort             | 10000     | 1.58
	 *    Merge Sort             | 15000     | 0.75
	 *    Merge Sort Inefficient | 15000     | 1.06
	 *    Quick Sort             | 15000     | 0.79
	 *    Radix Sort             | 15000     | 3.15
	 *    Merge Sort             | 20000     | 0.99
	 *    Merge Sort Inefficient | 20000     | 1.5
	 *    Quick Sort             | 20000     | 1.08
	 *    Radix Sort             | 20000     | 4.0
	 *    Merge Sort             | 25000     | 1.27
	 *    Merge Sort Inefficient | 25000     | 1.88
	 *    Quick Sort             | 25000     | 1.31
	 *    Radix Sort             | 25000     | 4.9
	 *    Merge Sort             | 30000     | 1.43
	 *    Merge Sort Inefficient | 30000     | 2.08
	 *    Quick Sort             | 30000     | 1.63
	 *    Radix Sort             | 30000     | 5.91
	 *    Merge Sort             | 35000     | 1.81
	 *    Merge Sort Inefficient | 35000     | 2.43
	 *    Quick Sort             | 35000     | 1.99
	 *    Radix Sort             | 35000     | 6.73
	 *    Merge Sort             | 40000     | 2.0
	 *    Merge Sort Inefficient | 40000     | 2.63
	 *    Quick Sort             | 40000     | 2.15
	 *    Radix Sort             | 40000     | 7.59
	 *    Merge Sort             | 45000     | 2.29
	 *    Merge Sort Inefficient | 45000     | 2.95
	 *    Quick Sort             | 45000     | 2.57
	 *    Radix Sort             | 45000     | 8.43
	 *    Merge Sort             | 50000     | 2.68
	 *    Merge Sort Inefficient | 50000     | 3.4
	 *    Quick Sort             | 50000     | 2.77
	 *    Radix Sort             | 50000     | 9.46
	 *    Merge Sort             | 55000     | 2.87
	 *    Merge Sort Inefficient | 55000     | 3.66
	 *    Quick Sort             | 55000     | 3.13
	 *    Radix Sort             | 55000     | 10.31
	 *    Merge Sort             | 60000     | 3.19
	 *    Merge Sort Inefficient | 60000     | 3.97
	 *    Quick Sort             | 60000     | 3.36
	 *    Radix Sort             | 60000     | 11.4
	 * 2. Merge sort and quick sort had similar times for arraySize = 10000, numSwaps = 2500.
	 * 3. Merge sort inefficient is slightly longer as it allocates a new array each time it is called.
	 * 4. Radix sort was not faster than merge sort at arraySize = 10000, numSwaps = 2500.
	 * 5. The operations that slow down radix sort are searching sections of an array to place values in buckets
	 */
	
}
