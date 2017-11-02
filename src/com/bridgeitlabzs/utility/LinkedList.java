package com.bridgeitlabzs.utility;

public class LinkedList<T> {
	Node head=null, tail=null, temp, temp2, previous, new_node;
	int elements=0;
	class Node<T>
	{
		T data=null;
		Node next;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		private Node(T data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	/**
	 * @param item
	 */
	public <T> void add(T item)
	{
		new_node=new Node<T>(item);
		
		if(head==null)
		{
			head=new_node;
			temp=new_node;
			tail=new_node;
			elements++;
		}
		else
		{
			temp=head;
			head=new_node;
			elements++;
		}
	}
	
	public <T> void addLast(T item)
	{
		if(head==null)
		{
			System.out.println("List is empty please first add some items.");
		}
		else
		{
			new_node=new Node<T>(item);
			temp=head;
			int count=0;
			while(temp!=null)
			{
				temp=temp.getNext();
				if(temp==null && count==0)
				{
					temp=tail;
					tail=new_node;
					count++;
					elements++;
				}
			}
		}
	}
	
	public int size()
	{
		return elements;
	}
	
	public <T> void remove(T item)
	{
		Node temp=head;
		Node prev=head;
		if(head==null)
		{
			System.out.println("List is empty, first you have to add the data.");
		}
		else if(temp.getData().equals(item)){
			head=temp.getNext();
			elements--;
		}
		else 
		{
			temp2=head;
			temp=head;
			while(temp!=null)
			{
				if(item.equals(temp.getData()))
				{
					System.out.println(item+" is removed.");

					prev.setNext(temp.getNext());
					elements--;
					break;
				}
				else
				{
					prev=temp;
					temp=temp.getNext();
				}
			}
			if(temp==null)
			{
				System.out.println(item+" is not available in the list.");
			}
		}
	}
	
	public void getElement()
	{
		
     }
}
