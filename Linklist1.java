//一个类  表达结点
class Node{
	int value; //保存结点中的数据
    Node next; // 指向下一个结点的引用
	           //null
	public Node(int value){
		this.value=value;
		this.next=null;
	}		   
}
public class Linklist1{
	
	public static Node createLinklist(){
		Node n1=new Node(1);// 首结点（头结点）
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
        Node n5=new Node(5);  	
	//将所有结点串起来
	    n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		return n1;
	}
	public static Node pushFront(Node head,int value){
		//1.申请新结点
		Node newNode=new Node(value);
		//2.更新newNode的next  -->head
		newNode.next=head;
		//3.更新head
		head=newNode;
		
		return newNode;
	}
	public static Node getLast(Node head){
		Node cur=head;
		while(cur.next!=null){
			cur=cur.next;
		}
		return cur;
	}
	public static Node pushBack(Node head,int value){
		if(head==null){
			return pushFront(head,value);
		}else{
		    Node newNode=new Node(value);
		    Node last=getLast(head);
		    last.next=newNode;
		    return head; 	
		}
		 
	}
	
	public static void displayLinklist(Node head){
		//如何遍历一个链表
		for (Node cur=head;cur!=null;cur=cur.next){
			System.out.printf("(%d)-->",cur.value);
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		Node head=createLinklist();
		displayLinklist(head);
		head=pushFront(head,100);
		displayLinklist(head);
		pushBack(head,666);
		displayLinklist(head);
		
		head=null;
		displayLinklist(head);
		head=pushBack(head,1);
		head=pushBack(head,1);
		head=pushBack(head,1);
		head=pushBack(head,1);
		displayLinklist(head);
	}
}
 