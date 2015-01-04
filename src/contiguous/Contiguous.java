package contiguous;

public class Contiguous {
public static int  maxcontisq( int [] a,int len)
{
	int []m=new int[len];
	int maxsum=0;
	if(a[0]>0)
	{
		m[0]= a[0];
	}
	else
		m[0]=0;
	for (int i=1;i<len;i++)
	{
		int tempsum = 0;
		if(m[i-1]+a[i]>0)
		{
			m[i]=m[i-1]+a[i];
		}
		else
			m[i]=0;
	}
	for (int i=0;i<len;i++)
	{
		System.out.println("m["+i+"]"+":"+m[i]);
	}
	int pos=0;
	for  (int i=0;i<len;i++)
	{
		if(m[i]>maxsum)
		{
			 pos=i;
			maxsum=m[i];
		}
	}
	for(int i=0;i<=pos;i++)
	{
		if(i==0 && a[i]<0)
			continue;
		System.out.println("a["+i+"]"+":"+a[i]);
	}
	
	return maxsum;
}
	
	public static void main(String []args)
	{
		int []m = {-2, -3, 4, -1, -2, 1, 5, -3};//{-2,11,-4,13,-5,2};
		
		System .out.println("res: "+ maxcontisq(m,m.length));
	}
}
