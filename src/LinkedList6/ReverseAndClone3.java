package LinkedList6;
import java.util.*;
public class ReverseAndClone3 {
	class Result{
		public LinkedListNode node;
		public boolean result;	
		public Result(LinkedListNode head, boolean b) {
			this.node = head;
			this.result = b;
		}

	}
	boolean isPalindrome(LinkedListNode head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}
	//호출된곳으로 돌아올때 비교하는 것!!! 
	Result isPalindromeRecurse(LinkedListNode head,int length) {
		if(head == null ||length <=0) {
			return new Result(head,true);
		}else if(length ==1) {
			return new Result(head.next, true);
		} 
		Result res = isPalindromeRecurse(head.next,length -2);
		
		if(!res.result||res.node==null) {
			return res;
		}
		res.result = (head.data == res.node.data);
		res.node = res.node.next;
		return res;
	}
	int lengthOfList(LinkedListNode n) {
		int size = 0;
		while(n!=null) {
			size++;
			n = n.next;
		}
		return size;
	}
	
	public static void main(String args[]) {
		ReverseAndClone3 l = new ReverseAndClone3();
		LinkedListNode l1 = new LinkedListNode(0);
		l1.appendToTail(1);//data값 
		l1.appendToTail(2);
		l1.appendToTail(1);
		l1.appendToTail(0);
		if(l.isPalindrome(l1) == true) {
			System.out.println("회문");
		}
		else {
			System.out.println("노");
		}
		
	}
}
