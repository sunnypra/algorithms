package array;

public class SubsetSum {

	
	static int  subsetSum(int []arr,int len,int s)
	{
		
		int i,j;int M[][];
	M[0][0]=0;
	for (i=1;i<s;i++)
		M[0][i]=0;
	for (i=1;i<len;i++)
	{
		for(j=0;j<=s;j++)
		{
			M[i][j]=M[i-1][j] || M[i-1][j]-arr[i]];
			
		}
	}
	
	}
	public static void main (String [] args)
	{
		int [] arr ={3,4,4,19,3,7,13,10,6,11};
		int res =subsetSum(arr, arr.length,17);
	}
}
