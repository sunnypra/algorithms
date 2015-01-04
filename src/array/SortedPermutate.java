package array;

import java.util.Arrays;

public class SortedPermutate {
	public static void main (String [] args)
	{
		String str ="ABCD";
		//char [] strarr  = str.toCharArray();
		//sortedPermutations( str );
		
		String str1=isanagram("tea","slate");
		System.out.println("final:"+str1);
	}
	///teatea
	static String isanagram(String word1, String word2) {
		String res1="";
			
		String conword1= word1+word1;//new StringBuilder(word1).reverse().toString();
		try
		{
		for(int i=0;i<conword1.length()-1;i++)
		{
			for(int j=i+1;j<conword1.length()-1;j++)
			{
			String res=conword1.substring(i,j+1);
			if(word2.contains(res))
			{
				
				System.out.println("hii");
				if(res1.length()<res.length())
					res1=res;
			}
			else
				System.out.println("bye");
		    }
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			res1=res1;
		}
		if(res1.equals(""))
			return "NONE";
		else
			return res1;
	}
}
	/*void sortedPermutations ( char str[] )
	{
	    // Get size of string
	    int size = str.length;
	 
	    // Sort the string in increasing order
	   Arrays
	 
	    // Print permutations one by one
	    bool isFinished = false;
	    while ( ! isFinished )
	    {
	        // print this permutation
	        printf ("%s \n", str);
	 
	        // Find the rightmost character which is smaller than its next
	        // character. Let us call it 'first char'
	        int i;
	        for ( i = size - 2; i >= 0; --i )
	           if (str[i] < str[i+1])
	              break;
	 
	        // If there is no such chracter, all are sorted in decreasing order,
	        // means we just printed the last permutation and we are done.
	        if ( i == -1 )
	            isFinished = true;
	        else
	        {
	            // Find the ceil of 'first char' in right of first character.
	            // Ceil of a character is the smallest character greater than it
	            int ceilIndex = findCeil( str, str[i], i + 1, size - 1 );
	 
	            // Swap first and second characters
	            swap( &str[i], &str[ceilIndex] );
	 
	            // Sort the string on right of 'first char'
	            qsort( str + i + 1, size - i - 1, sizeof(str[0]), compare );
	        }
	    }
	}
}
*/