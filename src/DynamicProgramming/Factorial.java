package DynamicProgramming;

public class Factorial {
	static int facto[]= new int[6];
public static void main (String [] args)
{
	int n=5;
	int res = fact(n);
	System.out.println("res:"+res);
}
static int fact(int n)
{
	if (n==1 || n==0)
		return 1;
	else if(facto[n]!= 0)
		return facto[n];
	else
		return facto[n]=n*fact(n-1);
}
}
