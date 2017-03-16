// reverse an array java
import java.util.*;
class RevArr{

	static void reverse(int a[],int start,int end){
		if (start>=end)
			return;
		int temp = a[start];
		a[start] = a[end];
		a[end] = temp;
		reverse(a,start+1,end-1);

	}

	static void print(int a[],int size){
		for(int i = 0;i<size;i++)
			System.out.print(a[i]+" ");
	}

	public static void main(String args[]){
		int arr[] = {1,2,3,4,5,6};
		print(arr,arr.length);
		reverse(arr,0,5);
		System.out.println("Reversed Array");
		print(arr,arr.length);

	}
}