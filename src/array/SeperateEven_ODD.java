package array;

public class SeperateEven_ODD {
	public static void main(String [] args)
	{
		int [] arr={12,13,16,19,15,18};
		int left=0;
		int right=arr.length-1;
		while(left<right)
		{
			while(arr[left]%2==0 && left<right)
				left++;
			while(arr[right]%2==1 && left<right)
				right--;
			if(left<right)
			{
				/*arr[left]=0;
				arr[right]=1;*/
				int t=arr[left];
				arr[left]=arr[right];
				arr[right]=t;
				left++;
				right--;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
		System.out.println("aar:"+arr[i]);
		}
	}

}
