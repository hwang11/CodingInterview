package LinkedList6;
import LinkedList6.LinkedListNode;
import java.util.*;
public class ReverseAndClone {
	boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head,reversed);
	}
	//뒤집는
	LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while(node != null) {
			LinkedListNode n = new LinkedListNode(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}
	//비교하는
	boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one!= null && two != null) {
			if(one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
	
	// 해법 #2:순환적 접근법
	boolean isPalindrome1(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		//연결리스트의 앞 절반을 스택에 쌓는다.fast runner(2배 빠른)가
		//연결리스트의 끝에 도달하면 slow runner가 중간에 도달했다는 사실을 알수있다.
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		//원소의 개수가 홀수 개라면 가운데 원소는 넘긴다.
		if(fast != null) {
			slow = slow.next;
		}
		while(slow != null) {
			int top = stack.pop().intValue();
			if(top!= slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	
	
	
	
	public static void main(String args[]) {
		ReverseAndClone l = new ReverseAndClone();
		LinkedListNode l1 = new LinkedListNode(0);
		l1.appendToTail(1);//data값 
		l1.appendToTail(2);
		l1.appendToTail(1);
		l1.appendToTail(1);
		if(l.isPalindrome(l1) == true) {
			System.out.println("회문");
		}
		else {
			System.out.println("노");
		}
	
	}
}
