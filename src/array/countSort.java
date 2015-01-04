package array;

public class countSort {

	public static void main (String [] arg)
	{
	String str = "geeksforgeeks";
	 
    countSort(str);
    
	}

	private static void countSort(String str) {
		// TODO Auto-generated method stub
		char [] arr= str.toCharArray();
		int [] countarr = new int[255];
		/*for(int i =0;i<countarr.length;i++)
		{
			System.out.println("\n :"+countarr[i]);
		}*/
		
		 for(int i = 0; i<arr.length; i++)
		        countarr[arr[i]]=countarr[arr[i]]+1;
		 for(int i =0;i<countarr.length;i++)
			{
				System.out.println("\n :"+countarr[i]);
			}
	}
}
