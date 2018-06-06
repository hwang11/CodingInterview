package LinkedList4;
import java.util.*;;

public class Partition {
	
	//2-4 x기준으로 앞 + 뒤 
	LinkedListNode partition(LinkedListNode node,int x) {
		LinkedListNode beforeStart  = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while(node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if(node.data <x) {
				//before 리스트의 끝에 원소를 삽입한
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				}else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}else {
				//after 리스트의 끝에 원소를 삽입한
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				}else {
					afterEnd.next = node;
					afterEnd = node;
				}
				
			}
			node = next;
		}
		if(beforeStart == null) {
			return afterStart;
		}
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	//새로운 리스트 만들기  
	LinkedListNode partition1(LinkedListNode node,int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while(node != null) {
			LinkedListNode next = node.next;
			if(node.data<x) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		//head가 바뀌었기 때문에 새로운 head를 반환해야한다.
		return head;
	}

	
	public static void main(String args[]) {
		Partition p = new Partition();
		LinkedListNode n = new LinkedListNode(1);
		n.appendToTail(2);
		n.appendToTail(4);
		n.appendToTail(5);
		//p.partition(n,3);
		p.partition1(n,3);
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}