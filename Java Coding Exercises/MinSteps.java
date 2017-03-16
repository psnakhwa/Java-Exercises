// Min steps to k
import java.util.*;
class MinSteps{
	
	public static void main(String args[]){
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a num");
		n = sc.nextInt();
		int[] arr = new int[n+1];
		if (n>=5)
		{
		arr[0] = 0;
		arr[1] = 1;
		arr[3] = 2;
		arr[5] = 4;
		}
		else if (n>=3){
		arr[0] = 0;
		arr[1] = 1;
		arr[3] = 2;
		}
		else if(n>=1){
		arr[0] = 0;
		arr[1] = 1;
		}

		int ways = findSteps(n,arr);
		System.out.println("Total Steps:"+ways);
	}

	public static int findSteps(int n, int[] arr)
	{
		

		if(n<0) return 0;
		if(n == 1 || n==0) return arr[n];
		else
			{ 	int x = arr[n];
				if(x==0)
				{
			      x =  findSteps(n-1,arr) + findSteps(n-3,arr) + findSteps(n-5,arr);
			      arr[n] = x;

            	}
            	return x;

            }
        
			
	}
}