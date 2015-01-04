package array;

public class MergeSort {
public static void main(String [] aargs)
{
	 int [] arr={4,7,8,2,9};
	MergeSort(arr,0,5);
	
for(int i=0;i<5;i++)
{
	System.out.println(arr[i]);
}
}


static void MergeSort(int [] a, int L, int R) {
	  
    if (R <= L) return; 
    
    /*
    // Possible optimization  
    if (R -L < _threshold) {
        return InsertionSort(a, L, R);
        // Can replace with different sort etc.
    }
    */
    int mid = (R-L)/2 + L;
    // Sort left half.
    MergeSort(a, L, mid);
    // Sort right half.
    MergeSort(a, mid+1, R);
    // Merge.
    Merge(a, L, mid, R);
}

static void  Merge(int [] a, int L, int mid, int R) {
    // Scratch space which holds the merged elements.
    int [] tmp = new int[R-L+1];
    
    int i = L;  // pointer to left half.
    int j = mid+1; // pointer to right half.
    int to_write = 0; // pointer to merge space.
    
    // Try to merge till we reach the end of the first part.
    while (i <= mid) {
        // either out of right half elements, or we need to copy
        // element from left half.
        if (j > R || a[i] <= a[j]) {
            tmp[to_write++] = a[i++];
        } else {
            tmp[to_write++] = a[j++];
        }
    }
    
    // There might be elements left over from the right part.
    while (j <= R) {
        tmp[to_write++] = a[j++];
    }
    
    // Now modify the original array to the sorted version.
    for (int k = 0 ; k < tmp.length; k++) {
        a[L+k] = tmp[k];
    }
}
}
