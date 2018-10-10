import java.util.Random;
import java.util.Scanner;

public class Sorting {
	
	static void printArray(int array[]) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	static void bubbleSort(int array[]) {
		int n = array.length;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	static void msSorter(int array[], int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			
			msSorter(array, l, m);
			msSorter(array, m+1, r);
			
			msMerger(array, l, m, r);
		}
	}
	
	static void msMerger(int array[], int l, int m, int r) {
		int n1 = m -l +1;
		int n2 = r - m;
		
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		for (int i = 0; i < n1; i++)
			L[i] = array[i+l];
		for (int j = 0; j < n2; j++)
			R[j] = array[m+1+j];
		
		int i = 0, j=0;
		
		int k = l;
		while(i < n1 && j < n2) {
			if (L[i] <= R[j]) { 
				array[k] = L[i];
				i++;
			}else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			array[k] = R[j];
			k++;
			j++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Input data test size: ");
		int arraySize = scan.nextInt();
		System.out.println("");
		
		int array[] = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			array[i] = rand.nextInt(100);
			System.out.println(array[i]);
		}
		
		System.out.println("");
		
		long startTime = 0;
		long endTime   = 0;
		
		boolean running = true;
		while (running) {
			
			System.out.println("Bubble Sort or Merge Sort(enter bubble or merge): ");
			String sort = scan.next();
			
			switch (sort) {
				case "bubble": 
					System.out.println("Test Bubble");
					startTime = System.currentTimeMillis();
					bubbleSort(array);
					printArray(array);
					endTime   = System.currentTimeMillis();
					running = false;
					break;
				case "merge":
					System.out.println("Test Merge");
					startTime = System.currentTimeMillis();
					msSorter(array,0,array.length-1);
					endTime   = System.currentTimeMillis();
					printArray(array);
					running = false;
					break;
				default: 
					System.out.println("Invalid input, try again");
			}
		}
		
		System.out.println("");
		System.out.println("Sort run time: " + (endTime - startTime) + " milliseconds");
		
		System.out.println("");
		System.out.println("Run another test(y/n?);");
		String again = scan.next();
		if(again.equals("y")) {
			System.out.println("restarting");
			System.out.println("");
			Sorting.main( new String[0]);
		}else {
			System.out.println("Goodbye");
		}
			
	}

}
