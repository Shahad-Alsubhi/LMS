
public class linkedlist {
class node
{
	int data;
	node next;
	
	public node(int data) 
	{
		this.data=data;
		this.next=null;
	}
	
}
public node head=null;
public node tail=null;

public void addnode(int data) {
	node newnode=new node(data);
	
	if (head==null) {
		head=newnode;
		tail=newnode;
	}
	else {
		tail.next=newnode;
		tail=newnode;
	}
}
public void display() {
	node current=head;
	if(head==null) {
		System.out.println("list is empty");
		return;
	}
	System.out.println("nodes of singly linked list:");
	while(current!=null) {
		System.out.print(current.data+" ");
		current=current.next;
	}
	System.out.println();
}

public static void main(String[] args) 
{
	linkedlist slist=new linkedlist();
	slist.addnode(1);
	slist.addnode(2);
	slist.addnode(3);
	slist.addnode(4);
	
	//slist.display();
	
	}

}
