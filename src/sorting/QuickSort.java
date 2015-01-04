package sorting;

public class QuickSort {

	
	static int [] arr = {10, 7, 8, 9, 1, 5};
	
	
	
	public static void main(String []args)
	{
	quickSort(0, arr.length-1);
	}



	private static void quickSort( int i, int j) {
		// TODO Auto-generated method stub
		int p = partition(arr,i,j);
	}
    
}
