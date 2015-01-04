package Design;

 interface Product { }

 abstract class Creator 
{
	public void anOperation() 
	{
		Product product = factoryMethod();
	}
	
	protected abstract Product factoryMethod();
}

 class ConcreteProduct implements Product {
	 ConcreteProduct(){
		 System.out.println("inside ConcreteProduct");
	 }
 }

 class ConcreteCreator extends Creator 
{
	protected Product factoryMethod() 
	{
		return new ConcreteProduct();
	}
}

public class Client 
{
	public static void main( String arg[] ) 
	{
		Creator creator = new ConcreteCreator();
		creator.anOperation();
	}
}