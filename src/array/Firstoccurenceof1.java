package array;

public class Firstoccurenceof1 {
	public static void main (String [] args)
	{
		char [] arrnum ={0,1,1,1,1,1,1};
		int low=0;int high =arrnum.length;
		if(arrnum[0]!=0)
		{
			System.out.println("pos:"+"0");
			return ;
		}
			
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(arrnum[mid]==1 && arrnum[mid-1]==0)
			{
				System.out.println("pos:"+mid);
				return;
			}
			else if(arrnum[mid]==0)
				low=mid+1;
			else if(arrnum[mid]==1)
				high=mid-1;
		}
	}
}
