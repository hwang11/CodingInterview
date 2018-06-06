package LinkedList3;
import java.util.*;
// #2.2 뒤에서 k번째원소 구하기.
public class FindK {
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
	//뒤에서 k번째원소 구하기
	public int printKthToLast(LinkedListNode head,int k) {
		if(head ==null) {
			return 0;
		}
		int index = printKthToLast(head.next,k) +1;
		if(index == k) {
			System.out.println(k+"th to last node is "+head.data);
		}
		System.out.println(index +" "+ k);
		return index;
	}
	
	//'Wrapper class 구현'
	public static class Index{
		public int value = 0;
	}
	LinkedListNode kthToLast(LinkedListNode head,int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}
	LinkedListNode kthToLast(LinkedListNode head,int k,Index idx) {
		if(head == null) {
			return null;
		}
		LinkedListNode node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if(idx.value == k) {
			return head;
		}
		return node;
	}
	
	//해법 #3: 순환적방법
	//p2:시작노드, p1:k만큼 움직이기 p1이 맨마지막 노드에 도달하면 p2는 k번째노
	LinkedListNode nthToLast(LinkedListNode head,int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		//p1을 k만큼이동 
		for(int i=0;i<k;i++) {
			if(p1 == null) return null;
			p1 = p1.next;
		}
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
	
	public static void main(String args[]) {
		FindK l = new FindK();
		LinkedListNode n = new LinkedListNode(2);
		n.appendToTail(10);//data값 
		n.appendToTail(20);
		n.appendToTail(30);
		//l.printKthToLast(n,1);
		//System.out.println(l.kthToLast(n,1).data);
		
	}

}
