package array;

public class LongestPalindrome {

	
	public static void main (String [] args)
	{
		String str="susus";
		int start=0;
		int maxLength=1;
		boolean [][]table = new boolean [str.length()][str.length()];
		for(int i=0;i<str.length();i++)
			table[i][i]=true;
		for(int i=0;i<str.length()-1;i++)
		{
			
		if(str.charAt(i)==str.charAt(i+1))
		{
			System.out.println("i:"+(i));
			table[i][i+1]=true;
			
			 start = i;
            maxLength = 2;
		}
		}
		for(int m=0;m<str.length();m++)
		{
			for(int n=0;n<str.length();n++)
			{
				System.out.print(" "+table[m][n]);
			}
		System.out.println("\n");
	}
		for( int k = 3; k <= str.length(); ++k )
	    {
	        // Fix the starting index
	        for( int i = 0; i < str.length()- k + 1 ; ++i )
	        {
	            // Get the ending index of substring from starting index i and length k
	            int j = i + k - 1;
	        	//System.out.println("i+1:"+(i+1)+" "+(j-1)+" "+k);
            	//System.out.println("j+1:"+(j-1));
	            // checking for sub-string from ith index to jth index iff str[i+1]
	            // to str[j-1] is a palindrome
	            
	            if( table[i+1][j-1] && str.charAt(i) == str.charAt(j)) 
	            {
	            	System.out.println("table[i+1][j-1] "+(i+1)+"sss"+(j-1 ));
	                table[i][j] = true;
	 
	                if( k > maxLength )
	                {
	                    start = i;
	                    maxLength = k;
	                }
	            }
	        }
	    }
		
		
		for(int m=0;m<str.length();m++)
		{
			for(int n=0;n<str.length();n++)
			{
				System.out.print(" "+table[m][n]);
			}
		System.out.println("\n");
	}
		System.out.println("str:"+str.substring(start,start+maxLength));
		
	}
	
}
