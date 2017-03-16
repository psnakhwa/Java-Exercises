import java.util.*;

class LinkedList{
	Node head;

	static class Node{
		int data;
		Node next;
		Node(int val){
			data = val;
			next = null;
		}
	}

	public void push(int x){
		Node new_node = new Node(x);
		new_node.next = head;
		head = new_node;
	}

	public void insertAfter(Node prev, int x){
		if(prev==null) return;
		Node new_node = new Node(x);
		new_node.next = prev.next;
		prev.next = new_node;
	}

	public void append(int x){
		Node new_node = new Node(x);
		if(head==null){
			head = new_node;
			return;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new_node;
		return;
	}

	public void delete(int x){
		if(head==null) return;
		Node temp = head;
		Node prev = null;
		if(temp!=null && temp.data == x){
			head = temp.next;
			return;
		}
		while(temp!=null&&temp.data != x){
			prev = temp;
			temp = temp.next;
		}
		if(temp==null) return;
		prev.next = temp.next;
	}

	public void deleteAtPos(int pos){
		if(head==null) return;
		Node temp = head;
		if(pos==0){
			head = temp.next;
			return;
		}
		for(int i=0;temp!=null&&i<pos-1;i++){
			temp = temp.next;
		}

		if(temp==null || temp.next == null) return;
		temp.next = temp.next.next;
	}

	public int findLength(){
		Node temp = head;
		int len = 0;
		while(temp!=null){
			len++;
			temp = temp.next;
		}
		return len;
	}

	public void printlist(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static LinkedList IntersectionOfTwoSortedLists(LinkedList l1, LinkedList l2){
		LinkedList l3 = new LinkedList();
		Node temp1 = l1.head;
		Node temp2 = l2.head;
		while(temp1 != null && temp2 != null ){
			if(temp1.data<temp2.data) temp1 = temp1.next;
			else if(temp1.data>temp2.data) temp2 = temp2.next;
			else {
				l3.append(temp2.data);
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		return l3;

	}

	public void deleteAlternate(){
		Node temp = head.next;
		Node prev = head;
		while(prev != null && temp != null){
			prev.next = temp.next;
			temp = null;
			prev = prev.next;
			if(prev != null)
				temp = prev.next;
		}
	}

	public static LinkedList addTwoLists(LinkedList l1, LinkedList l2){
		Node head1 = l1.head;
		Node head2 = l2.head;
		Node res = null;
		Node prev = null;
		int carry=0,sum=0;
		while(head1 != null || head2 != null){
			sum = carry + (head1 != null?head1.data:0) + (head2 != null?head2.data:0);
			carry = sum/10;
			sum = sum%10;
			Node new_node = new Node(sum);
			if(res==null) res = new_node;
			else prev.next = new_node;

			prev = new_node;

			if(head1 != null) head1 = head1.next;
			if(head2 != null) head2 = head2.next;
		}
		if(carry>0){
			Node new_node = new Node(carry);
			prev.next = new_node;
		}
		LinkedList l3 = new LinkedList();
		l3.head = res;
		return l3;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for(int i=1;i<10;i++)
			list.append(i);
		list.printlist();
		System.out.println("After Deleting alt");
		list.deleteAlternate();
		list.printlist();
		System.out.println();
		list.delete(5);
		list.push(10);
		list.insertAfter(list.head.next,55);
		list.printlist();
		System.out.println();
		list.deleteAtPos(7);
		list.printlist();
		int l = list.findLength();
		System.out.println("length : "+l);
		System.out.println();

		LinkedList l1new = new LinkedList();
		for(int i=1;i<10;i++)
			l1new.append(i);
		LinkedList l2new = new LinkedList();
		for(int i=2;i<6;i++)
			l2new.append(i);
		l1new.printlist();
		System.out.println();
		l2new.printlist();
		LinkedList l3new = IntersectionOfTwoSortedLists(l1new,l2new);
		System.out.println();
		l3new.printlist();
		System.out.println("---------------------------");
		LinkedList add1 = new LinkedList();
		add1.push(9);
		add1.push(9);
		add1.push(9);
		LinkedList add2 = new LinkedList();
		add2.push(1);
		add2.push(0);
		add2.push(0);
		LinkedList ans = addTwoLists(add1,add2);
		ans.printlist();


	}
}