package array;

public class Test {

	static int value  = 1;
	
	public static void main(String[] args) {
		
		Test t =  new Test();
		
		System.out.println(t.value);
        System.out.println(t.getValue());	
        System.out.println(t.value);
	}
	
	public int getValue()
	{
		try
		{
			//value =value + 1;
			value=value/0;
			return value;
			
		}
		catch(Exception e)
		{
			System.out.println("e:"+e);
		}
		finally
		{
			value++;
		}
		return 5;
	}
	
}
