public class Queue
{
	//@ invariant firstNode == null <==> lastNode == null;
	//@ invariant firstNode == null <==> size == 0;
	//@ invariant lastNode == null <==> size == 0;

	Queue()
	{
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	//@ ensures size == \old(size) + 1;
	public void push(Object newValue)
	{
		QueueNode tempNode = new QueueNode(newValue);
		
		if (firstNode == null)
		{
			firstNode = tempNode;
			lastNode = tempNode;
		}
		else
		{
			lastNode.setNextNode(tempNode);
			lastNode = tempNode;
		}
		
		size++;
	}
	
	//@ requires firstNode != null;
	public /*@ pure @*/ Object getHead()
	{
		if (firstNode == null)
		{
			throw (new RuntimeException("Cant call getHead on a empty list"));
		}
	
		return firstNode.getNodeValue();
	}
	
	//@ requires firstNode != null;
	//@ ensures size == \old(size) - 1;
	public Object pop()
	{
		if (firstNode == null)
		{
			throw (new RuntimeException("Cant call pop on a empty list"));
		}
		
		QueueNode tempNode = firstNode;
		
		if (firstNode == lastNode)
		{
			firstNode = null;
			lastNode = null;
		}
		else
		{
			firstNode = firstNode.getNextNode();
		}
		
		size--;
		
		return tempNode.getNodeValue();
	}
	
	public /*@ pure @*/ int getSize()
	{
		return size;
	}
	
	public /*@ pure @*/ boolean isEmpty()
	{
		if(firstNode == null)
		{
			return true;
		}
		
		return false;
	}
	
	public /*@ pure @*/ String toString()
	{
		String currentInfo = "";
		
		if (firstNode == null)
		{
			return currentInfo += "no queue elements";
		}
		
		QueueNode currentNode = firstNode;
		
		currentInfo += currentNode.getNodeValue().toString();
		currentNode = currentNode.getNextNode();
		
		while (currentNode != null)
		{
			currentInfo += ", " + currentNode.getNodeValue().toString();
			currentNode = currentNode.getNextNode();
		}
		
		return currentInfo;
	}
	
	public /*@ pure @*/ boolean equals(Object compareTo)
	{
		if (compareTo == null || !(compareTo instanceof Queue))
		{
			return false;
		}
		
		QueueNode currentNode = firstNode;
		QueueNode currentCompareNode = ((Queue)compareTo).firstNode;
		
		if (size != ((Queue)compareTo).getSize())
		{
			return false;
		}
		
		while (currentNode != null && currentCompareNode != null)
		{
			if (!currentNode.getNodeValue().equals(currentCompareNode.getNodeValue()))
			{
				return false;
			}
			
			currentNode = currentNode.getNextNode();
			currentCompareNode = currentCompareNode.getNextNode();
		}
		
		return true;
	}
	
	public /*@ pure @*/ int hashCode()
	{
		int currentCode = 0;
		
		if (firstNode == null)
		{
			return currentCode;
		}
		
		QueueNode currentNode = firstNode;
		
		while (currentNode != null)
		{
			currentCode += currentNode.getNodeValue().hashCode();
			currentNode = currentNode.getNextNode();
		}
		
		return currentCode;
	}
	
	private /*@ spec_public @*/ QueueNode firstNode;
	private /*@ spec_public @*/ QueueNode lastNode;
	private /*@ spec_public @*/ int size;
}