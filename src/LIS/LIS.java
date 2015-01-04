package LIS;

public class LIS {
	static int []lis = new int[1024] ;
	static int LonIncreaseSubs(int [] a,int len)
	{
		int max =0;
		for(int i=0;i<len;i++)
		{
			lis[i]=1;
		}
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[i]>a[j] && lis[i]<lis[j]+1)
				{
					lis[i]=lis[j]+1;
				}
			}
		}
		for(int i=0;i<len;i++)
		{
			//System.out.println("lis "+""+i+":"+lis [i]);	
			if(max<lis[i])
			{
				System.out.println("item :"+a [i]);
				max=lis[i];
			}
		}
		return max;
		
}
	public static void main(String [] args)
	{
		int [] a= {5,6,2,3,4,1,9,9,8,9,5};
		int res = LonIncreaseSubs(a,a.length);
		System.out.println(" length of longest subaequence:"+res);
	}
}
