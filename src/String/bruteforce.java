package String;

public class bruteforce {
	static int []  arr ={'a','b','c','x','z','s'};
	static int []  arr1 ={'a','b','c'};
public static void main(String [] args)
{
	for(int i=0;i<=(arr.length-arr1.length);i++)
	{
		int j=0;
		while(j< (arr1.length) && arr1[j]==arr[i+j] )
			j++;
		System.out.println("j:"+j);
		if(j==arr1.length){
			System.out.println("found");
			return;
		}
	}
	System.out.println("not found");
}
}
