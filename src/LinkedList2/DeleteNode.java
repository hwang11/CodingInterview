package LinkedList2;
import java.util.*;
public class DeleteNode {
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
	boolean deleteNode(LinkedListNode n) {
		if(n == null|| n.next == null) {
			return false;
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
	
	public static void main(String args[]) {
		DeleteNode d = new DeleteNode();
		LinkedListNode n = new LinkedListNode(30);
		n.appendToTail(10);//data값 
		n.appendToTail(20);
		n.appendToTail(30);
		d.deleteNode(n.next);
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}
