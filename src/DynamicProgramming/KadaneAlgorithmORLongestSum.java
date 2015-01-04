package DynamicProgramming;

import contiguous.Contiguous;

public class KadaneAlgorithmORLongestSum {
public static void main(String[] args)
{
	int [] arr ={-2,11,-4,13,-5,2};
	int max_xo_far=0;
	
	//O(n2 ssoln)
	for(int i=0;i<arr.length-1;i++){
		int currentsum=0;
	
		for(int j=i;j<arr.length;j++){
		 currentsum=currentsum+arr[j];
			if(currentsum>max_xo_far)
				max_xo_far=currentsum;
		}
	}
	System.out.println("max_xo_far:"+max_xo_far);
	
	
	//DP soln for the same in o(n) complexity
	int res=Contiguous.maxcontisq(arr,arr.length);
	System.out.println("max_xo_far:"+res);
	
	
	//Kadane Algorithms
	int max_ending_here=0;
	for(int i=0;i<arr.length;i++)
	{
		max_ending_here=max_ending_here+arr[i];
		if(max_ending_here<0)
			max_ending_here=0;
		
			
		if(max_xo_far<max_ending_here)
			max_xo_far=max_ending_here;
	}
	System.out.println("max_xo_far"+max_xo_far);
	
	
}
}
