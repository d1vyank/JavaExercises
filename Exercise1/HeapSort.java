import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import java.util.Scanner;

class HeapSort {
	
	private void sort(int[] array) {
		formHeap(array);
		int end = array.length -1;
		while (end > 0) {
			swapIndices(array, 0, end);
			end = end - 1;
			pushDown(array, 0, end);
		}
		
	}
	private void formHeap(int[] array) {
		int start;
		int size = array.length - 1;
		start = (int) Math.floor((size - 2)/2);
		while (start >= 0) {
			pushDown(array, start, size - 1);
			start--;
		}	
	}
	private void pushDown(int[] array,int root,int end) {
		int swap,child;
		while((root*2)+1 <= end) {
			child = root*2 + 1;
			swap = root;
			if (array[swap] < array[child])
				swap = child;
			if ((child+1) <= end && array[swap]<array[child+1])
				swap = child + 1;
			if (swap != root) {
				swapIndices(array, root, swap);
				root = swap;
			}
			else
				break;			
		}	
	}
	private void swapIndices(int[] array, int index1, int index2) {
		int temp;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	public static void main(String args[]) {
		//int[] array = {4,1,100,33,56,2,11,21,6,9};
		int i=0;
		int n = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of integer elements");
        n = scan.nextInt();  
		int[] array = new int[n]; 
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            array[i] = scan.nextInt();
		//int[] array = new int[10];
		HeapSort h = new HeapSort();
		h.sort(array);
		for(i=0; i<n; i++) {
			SimpleWriter1L out = new SimpleWriter1L();
			out.println(array[i]);
			out.close();
		}
		
		
	}
	
}		
	
