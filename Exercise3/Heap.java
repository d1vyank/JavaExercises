import java.util.NoSuchElementException;
import java.util.Scanner;


public class Heap<T extends Comparable<T>> {
	private T[] contents;
	private int numItems;

	@SuppressWarnings("unchecked")
	public Heap(int maxSize) {
		contents = (T[])new Comparable[maxSize];
		numItems = 0;
	}

	public Heap(T[] arr) {
		contents = arr;
		numItems = arr.length;
		makeHeap();
	}


	private void makeHeap() {
		int last = contents.length - 1;
		int parentOfLast = (last - 1)/2;
		for (int i = parentOfLast; i >= 0; i--)
			siftDown(i);
	}

	/** 
	 * insert - add the specified item to the heap and sift it up
	 * into its proper position.
	 */
	public void insert(T item) {
		if (numItems == contents.length) {
			// grow the array
			T[] newContents = (T[])new Comparable[contents.length * 2];
			System.arraycopy(contents, 0, newContents, 0, numItems);
			contents = newContents;
		}

		contents[numItems] = item;
		siftUp(numItems);
		numItems++;
	}

	public boolean isEmpty() {
		return (numItems == 0);
	}
	private void siftDown(int i) {
		T toSift = contents[i];

		int parent = i;
		int child = 2 * parent + 1;
		while (child < numItems) {
			if (child < numItems - 1  &&
					contents[child].compareTo(contents[child + 1]) < 0)
				child = child + 1;
			if (toSift.compareTo(contents[child]) >= 0)
				break;
			contents[parent] = contents[child];
			parent = child;
			child = 2 * parent + 1;
		}

		contents[parent] = toSift;
	}

	private void siftUp(int i) {
		T toSift = contents[i];

		int child = i;
		while (child > 0) {
			int parent = (child - 1)/2;

			if (toSift.compareTo(contents[parent]) <= 0)
				break;

			contents[child] = contents[parent];
			child = parent;
		}

		contents[child] = toSift;
	}
	public void printHeap() {
		for (T item : contents)
			System.out.println(item);
	}
	public void heapSort() {
		makeHeap();
		int end = numItems -1;
		while(end>0) {
			siftDown(end);
			end = end -1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size");
		int size = in.nextInt();
		in.nextLine();
		int choice;
		Heap<Integer> heap = new Heap<Integer>(size);
		while(true) {
			System.out.println("1. Insert 2. print 3. sort 4. quit");
			choice = in.nextInt();
			in.nextLine();
			switch (choice) {
				case 1:
					System.out.println("enter number");
					int insert =  in.nextInt();
					heap.insert(insert);
					in.nextLine();
					break;
				case 2:
					heap.printHeap();
					break;
				case 3:
					heap.heapSort();
					break;
				case 4:
					System.exit(0);
			}		
		}
		
	}
	
}