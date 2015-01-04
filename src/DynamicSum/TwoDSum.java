package DynamicSum;

public class TwoDSum {
	static int ROW= 4;
	static int COL =5;
	 static int sum, start, finish;
	 static int []temp=new int[4];
	 static int maxSum = 0, finalLeft=0, finalRight=0, finalTop=0, finalBottom=0;
	public static void main (String [] args)
	{
		   int M[][] = {{1, 2, -1, -4, -20},
                   {-8, -3, 4, 2, 1},
                   {3, 8, 10, 1, 3},
                   {-4, -1, 1, 7, -6}
                  };

		   findMaxSum(M);
	}

	
	static void findMaxSum(int M[][])
	{
	    // Variables to store the final output
	   
	 
	    int left, right, i;
	   	 
	    // Set the left column
	    for (left = 0; left < COL; ++left)
	    {
	        // Initialize all elements of temp as 0
	        //memset(temp, 0, sizeof(temp));
	 
	        // Set the right column for the left column set by outer loop
	        for (right = left; right < COL; ++right)
	        {
	            // Calculate sum between current left and right for every row 'i'
	            for (i = 0; i < ROW; ++i)
	            {
	                temp[i] += M[i][right];
	            }
	            // Find the maximum sum subarray in temp[]. The kadane() function
	            // also sets values of start and finish.  So 'sum' is sum of
	            // rectangle between (start, left) and (finish, right) which is the
	            //  maximum sum with boundary columns strictly as left and right.
	            sum = kadane(temp);
	 
	            // Compare sum with maximum sum so far. If sum is more, then update
	            // maxSum and other output values
	            if (sum > maxSum)
	            {
	                maxSum = sum;
	                finalLeft = left;
	                finalRight = right;
	                finalTop = start;
	                finalBottom = finish;
	            }
	        }
	        
	    }
	    System.out.println("x:"+finalTop+":"+finalLeft);
	    System.out.println("x:"+finalBottom+":"+finalRight);
	       // printf("(Bottom, Right) (%d, %d)\n", finalBottom, finalRight);
	        System.out.println("x:"+maxSum);
}
	
	static int  kadane(int []arr)
	{
	    // initialize sum, maxSum and start
		// System.out.println("arr:"+arr.toString());
		 for (int m = 0; m < ROW; ++m)
		 {
			System.out.print(""+arr[m]) ;
		 }
		 System.out.println();
	    int sum1 = 0, maxSum1 = -1, i;
	 
	    // needed if sum NEVER becomes less than 0
	    //start = 0;
	 
	    // Standard Kadane's algorithm. See following link
	    // http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	    for (i = 0; i < ROW; ++i)
	    {
	        sum1 += arr[i];
	        System.out.println("sum1:"+sum1);
	        if (sum1 < 0)
	        {
	            sum1 = 0;
	            start = i+1;
	        }
	        else if (sum1 > maxSum1)
	        {
	            maxSum1 = sum1;
	            finish = i;
	        }
	    }
	    System.out.println("maxSum1:"+maxSum1);
	    return maxSum1;
	}

	}