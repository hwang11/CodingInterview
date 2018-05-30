import LinkedList.LinkedListNode;

public class Partiiton {
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
	LinkedListNode partition(LinkedListNode node,int x) {
		LinkedListNode beforeStart  = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode atferend = null;
		
		while(node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			
		}
	}

	
			

	public static void main(String args[]) {
		
	}
}
