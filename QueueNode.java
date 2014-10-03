public class QueueNode
{
	QueueNode(Object newValue)
	{
		nodeValue = newValue;
		nextNode = null;
	}
	
	public /*@ pure @*/ QueueNode getNextNode()
	{
		return nextNode;
	}
	
	public void setNextNode(QueueNode newNode)
	{
		nextNode = newNode;
	}
	
	public /*@ pure @*/ Object getNodeValue()
	{
		return nodeValue;
	}
	
	private /*@ spec_public @*/ Object nodeValue;
	private /*@ spec_public @*/ QueueNode nextNode;
}