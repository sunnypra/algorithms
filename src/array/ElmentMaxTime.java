package array;

public class ElmentMaxTime {

	public static void main(String [] args)
	{
		 int [] arr =new int[]{1,2,4,2,3};
		 int n= arr.length;
		 for (int i=0;i<arr.length;i++)
			 
		 {
			 arr[arr[i]%n]+=n;
		 }
	
	 for (int j=0;j<arr.length;j++)
		 
	 {
		 System.out.println("j:"+arr[j]);
	 }
}
}