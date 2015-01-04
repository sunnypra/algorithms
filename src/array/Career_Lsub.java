package array;

import java.util.ArrayList;
import java.util.Arrays;


public class Career_Lsub {
	static ArrayList a1= new ArrayList();
public static void main(String [] arg)
{
	String input="abowadcbjkl";
	char[] arr1 =input.toCharArray();
	char[] arr =input.toCharArray();
	 Arrays.sort(arr); 
	 String str= Arrays.toString(arr);
	 System.out.println("arr:"+str);
	 for(int i=0;i<arr1.length-1;i++)
	 {
		 String res="";
		 //res+=arr[i];
		 for(int j=i;j<arr1.length-1;j++)
		 {
			 
			 if(((int)arr[j+1]- (int)arr[j])==0 ||((int)arr[j+1]- (int)arr[j])==1 )
			 {
				 res+=arr[j];
			 }
			 else
			 {
				if(res.length()>0)
					res+=arr[j];
				 break;
			 }
			 
		 }
		 //if(res.length()>1)
	     a1.add(res);
	 }
	 //String longStr=(String) a1.get(0);
	 System.out.println("a1:"+a1);
}
}
