package LinkedList;



public class SingleLinkedList {
	private ListNode head;
	
	private static class ListNode
	{
		private int data;
		private ListNode next;
		
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public void display()
	{
		ListNode current =head;
		
		while(current!=null)
		{
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public int count()
	{
		ListNode current = head;
		int count =0;
		
		if(head == null)
		{
			return 0;
		}
		while(current!= null)
		{
			count++;
			current = current.next;
			
		}
		return count;
	}
	
	public void insertAtBeginning(int data)
	{
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAtEnd(int data)
	{
		ListNode newNode = new ListNode(data);
		ListNode current = head;
		
		if(head == null)
		{
			head = newNode;
			return;
		}
		else
		{
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = newNode;
		}
		
		
	}
	
	public void insertAnywhere(int data, int location)
	{
		ListNode newNode = new ListNode(data);
		
		
		int total = count();
		if(head == null)
		{
			head = newNode;
			return;
		}
		
		if(location == 1)
		{
			insertAtBeginning(data);
		}
		
		else if(location == total)
		{
			insertAtEnd(data);
		}
		else
		{
			ListNode previous = head;
			int count = 1;
			while(count != location-1)
			{
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = newNode;
			newNode.next = current;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList sl = new SingleLinkedList();
		sl.head = new ListNode(10);
		ListNode second = new ListNode(20);
		ListNode third = new ListNode(30);
		ListNode fourth = new ListNode(40);
		
		sl.head.next = second;
		second.next = third;
		third.next = fourth;
		
		sl.display();
		System.out.println("The number of nodes " + sl.count());
		
		sl.insertAtBeginning(5);
		sl.display();
		System.out.println("The number of nodes " + sl.count());
		
		sl.insertAtEnd(50);
		sl.display();
		System.out.println("The number of nodes " + sl.count());
		
		sl.insertAnywhere(100, 2);
		sl.display();
		System.out.println("The number of nodes " + sl.count());
		
		sl.insertAnywhere(2, 1);
		sl.display();
		System.out.println("The number of nodes " + sl.count());
		
		sl.insertAnywhere(200, 8);
		sl.display();
		System.out.println("The number of nodes " + sl.count());
		 

	}

}
