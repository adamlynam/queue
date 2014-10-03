public class QueueTest
{
	public static void main(String[] args)
	{
		Queue testQueue = new Queue();
		
		//testQueue.push(new Integer(301));
		//testQueue.push(new Integer(982345));
		
		try
		{
			testQueue.pop();
		}
		catch(Exception e)
		{
			System.out.println("Threw a [" + e + "] exception");
		}
		
		try
		{
			testQueue.getHead();
		}
		catch(Exception e)
		{
			System.out.println("Threw a [" + e + "] exception");
		}
		
		System.out.println(testQueue.isEmpty());
		
		System.out.println(testQueue.toString());
		
		System.out.println(testQueue.hashCode());
		
		Queue tempQueue = new Queue();
		tempQueue.push(new Integer(301));
		tempQueue.push(new Integer(982345));
		tempQueue.push(new Integer(9812341));
		
		System.out.println(testQueue.equals(tempQueue));
	}
}