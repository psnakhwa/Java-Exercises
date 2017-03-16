import java.util.*;

class Sorting{

	public void HeapSort(int[] arr){
		int n = arr.length;
		for(int i=n/2 -1;i>=0;i--)
			Heapify(arr,n,i);

		for(int i=n-1;i>=0;i--){
			// put max element at end of array
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			//MaxHeapify for reduced heap
			Heapify(arr,i,0);
		}
	}

	public void Heapify(int[] arr, int n, int i){
		int largest = i;
		int l = 2*i +1;
		int r = 2*i  +2;
		// swap left or right child if its bigger, with the root.
		if(l<n && arr[l]>arr[largest]) largest = l;
		if(r<n && arr[r]>arr[largest]) largest = r;
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			Heapify(arr,n,largest);
		}
	}

	public void QuickSort(int[] arr, int low, int high){
		if(low<high){
			int pi = partition(arr,low,high);
			QuickSort(arr,low,pi-1);
			QuickSort(arr,pi+1,high);
		}
	}

	public int partition(int[] arr, int low, int high){
		int i = low-1;
		int pivot = arr[high];

		for(int j = low;j<= high-1;j++)
		{
			if(arr[j] <= pivot){
				i++;
				//swap(arr[i] and arr[j])
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
			//swap arr[i+1] and arr[j]
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}

	void MergeSort(int[] arr){
		int n = arr.length;
		if(n<2) return;
		int mid = n/2;
		int[] l = new int[mid];
		int[] r = new int[n-mid];
		for(int i=0;i<mid;i++)
			l[i] = arr[i];
		for(int i=mid;i<n;i++)
			r[i-mid] = arr[i];
		MergeSort(l);
		MergeSort(r);
		Merge(l,r,arr);
	}

	void Merge(int[] left, int[] right, int[] arr){
		int nl = left.length;
		int nr = right.length;
		int i=0,j=0,k=0;
		while(i<nl && j<nr){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++; k++;
			}
			else{
				arr[k] = right[j];
				j++; k++;
			}
		}
		while(i<nl){
			arr[k] = left[i];
			i++;k++;
		}
		while(j<nr){
			arr[k] = right[j];
			j++; k++;
		}
	}

	public void InsertionSort(int[] arr){
		int n = arr.length;
		for(int i=1;i<n;i++){
			int val = arr[i];
			int hole = i;
			while(hole>0 && arr[hole-1]>arr[hole]){
				arr[hole] = arr[hole-1];
				hole--;
			}
			arr[hole] = val;
		}
	}

	public void SelectionSort(int[] arr){
		
		for(int i=0;i<arr.length-1;i++){
			int imin = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[imin])
					imin = j;
			}
			int temp = arr[i];
			arr[i] = arr[imin];
			arr[imin] = temp;
		}
	}

	
	static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	
	public static void main(String[] args){
		int[] arr = {2,1,3,4,5,6};
		Sorting s1 = new Sorting();
		System.out.println("Original Array:");
		printArray(arr);
		System.out.println();
		// System.out.println("Sorted array after Heapsort is:");
		// s1.HeapSort(arr);
		// s1.QuickSort(arr,0,arr.length-1);
		// printArray(arr);
		// s1.MergeSort(arr);
		// s1.InsertionSort(arr);
		s1.SelectionSort(arr);
		printArray(arr);
	}
}