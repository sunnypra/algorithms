package String;

public class SeperateWithSingleSpace {

	static String str ="abc";
	 char buf[]=new char[4];
	public static void main (String [] args)
	{
		int len = str.length();
		int i=1;
		char buf[]=new char[2*len-1];
		buf[0]=str.charAt(0);
		StringBuffer  sb = new StringBuffer();
		//sb.append(str.charAt(0));
		//System.out.println(str);

		printallpossiblities(buf,1,1,len);
	}
	private static void printallpossiblities( char []buf,
			int i,int j, int len) {
		// TODO Auto-generated method stub
		if(i==(len))
		{
			System.out.println(buf);
			return;	
		}
		//sb.append(str.charAt(i));
		buf[j] = str.charAt(i);	
		printallpossiblities(buf,i+1,j+1,len);
		//System.out.println("sunny");
		//sb.insert(offset, c);
		//System.out.println("sun:"+sb);
		buf[j] = ' ';
		buf[j+1]=str.charAt(i);
		
		printallpossiblities(buf,i+1,j+2,len);
		
	}
}
