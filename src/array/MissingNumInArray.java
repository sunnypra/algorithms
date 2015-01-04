package array;

public class MissingNumInArray {
	public static void main(String[] args)
	{
		int[] arr = {1,2,4,5,6};
		int n=6;
		int x=0,y=0;
		for(int i=0;i<5;i++)
		{
			x^=arr[i];
			System.out.println("x1:"+x);	
		}for(int i=1;i<=n;i++)
			y^=i;
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		
		System.out.println("res:"+(x^y));
	}

}
