package Lcs;

public class LCS {
	static int max(int a,int b)
	{
		if(a>b)
			return a;
		else 
			return b;
		
	}
	static int cal_LCS(String S1,String S2,int a,int b)
	{
		if( a==0 || b==0)
			return 0;
		if(S1.charAt(a-1) == S2.charAt(b-1))
		{
			System.out.println("char: "+S1.charAt(a-1));
			return 1+cal_LCS(S1, S2,a-1,b-1);
			
		}
		else
			 return max(cal_LCS(S1, S2, a, b-1), cal_LCS(S1, S2, a-1, b));
		//return 0;	
		
	}
	public static void main(String [] args)
	{
		 String X = "AGGTAB";
		  String Y = "GXTXAYB";
		 
		  int m = X.length();
		  int n = Y.length();
		  
		 int res =cal_LCS(X,Y,m,n);
		 System.out.println("res :"+res);
	}
}
