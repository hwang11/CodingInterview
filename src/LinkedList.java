import java.util.*;

public class LinkedList<Element> {
	public static class LinkedListNode{
		LinkedListNode next = null;
		int data;
		public LinkedListNode(int d) {
			data = d;
		}
		void appendToTail(int d) {
			LinkedListNode end = new LinkedListNode(d);
			LinkedListNode n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
				
			
		}
	}
	void DeleteDups(LinkedListNode n) {
		HashSet set = new HashSet();
		LinkedListNode previous = null;
		while(n!= null) {
			if(set.contains(n.data)) {
				previous.next = n.next;
				
			}else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	//버퍼가 없을때 
	void deleteDups(LinkedListNode head) {
		LinkedListNode current = head;
		while(current != null) {
			LinkedListNode runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				}
				else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	

	
	
	public static void main(String args[]) {
		LinkedList l = new LinkedList();
		LinkedListNode n = new LinkedListNode(2);
		n.appendToTail(1);
		n.appendToTail(2);
		n.appendToTail(3);
		l.DeleteDups(n);
		LinkedListNode now = n;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
		
	}
}
