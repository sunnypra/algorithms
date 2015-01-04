package array;

public class IncreaseThenDecrease {
	public static void main(String[] args)
	{
		int[] arr = {5,10,15,18,8,2,1};
		int first =0;
		int mid;
		int last = arr.length;
		while(first<last)
		{
			if(first==last)
			{
				System.out.println("elemnt:"+arr[first]);
				return;
				
			}
			if(first==last-1)
			{
				//int res =(arr[first]>arr[last]?arr[first]:arr[last]);
				System.out.println("element:"+(arr[first]>arr[last]?arr[first]:arr[last]));
				return;
			}
			else
			{
				mid=(first+last)/2;
				if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid])
				{
					System.out.println("element:"+arr[mid]);
					return;
			}
				if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1])
				{
					first=mid+1;
				}
				if(arr[mid-1]>arr[mid] && arr[mid]>arr[mid+1])
				{
					last=mid-1;
				}
				
		}
	}
		
}
}
