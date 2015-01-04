package pattern;

public class KMP {
	static int []lps ;
	static String tex= "ababaca";
	static String pattern ="ABABCABAB";
	public static void main(String [] args)
	{
		
		computeLPSArray(tex.length());
		for (int i=0;i<tex.length();i++)
		{
			System.out.println("elemnt:"+lps[i]);
		}
	}
	 static void computeLPSArray(int len) {
		 lps= new int[len];
		// TODO Auto-generated method stub [] 
		char [] text1=tex.toCharArray();
		lps[0]=0;
		int i=1,j=0;
		while(i<len)
		{
			if(text1[i]==text1[j])
			{
				lps[i]=j+1;
				i++;
				j++;
			}
			else if(j!=0)
				j=lps[j-1];
			
			else
			{
				lps[i]=0;
				i++;
			}
		}
	}

}
