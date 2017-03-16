// Reverse second half of linked list
//Algorithm:
// 1. Write function to reverse a LL
// 2. write a func to find middle element. If fast is null i.e  nos. are even, so prev.next = reverse(slow) else slow.next = rev(slow.next)		
// Sample Code for Reversing the second half of a linked list.	


class ListNode{
	ListNode next;
	int val;
	ListNode(int x){val=x;}
}

class RevSecHalfLL{

	public ListNode reverseLL(ListNode head){
		ListNode prev = null;
		ListNode curr = null;
		while(head != null){
			curr = head;
			head = head.next;
			curr.next = prev;
			prev = curr;
		}
		return prev;
	}

	public ListNode reverseSecHalf(ListNode head){
		//find middle
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		while(fast != null && fast.next != null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//even nos. of elements in linked list
		if (fast==null) prev.next = reverseLL(slow);
		//odd nos. of elements in LL
		else slow.next = reverseLL(slow.next);
		return head;

	}

	public void printlist(ListNode head){
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		RevSecHalfLL r = new RevSecHalfLL();
		r.printlist(head);
		System.out.println(" ");
		ListNode temp = r.reverseSecHalf(head);
		r.printlist(temp);
	}
}