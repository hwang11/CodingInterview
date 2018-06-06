package LinkedList5;
public class AddLists {
	class PartialSum{
		public LinkedListNode sum = null;
		public int carry = 0;
	}
	LinkedListNode addLists(LinkedListNode l1,LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		if(len1 < len2) {
			l1 = padList(l1, len2 - len1);
		}
		else {
			l2 = padList(l2, len1 - len2);
		}
		
		PartialSum sum = addListsHelper(l1, l2);
		
		if(sum.carry == 0) {
			return sum.sum;
		}else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	int length(LinkedListNode node) {
		int len = 0;
		while(node!=null) {
			node = node.next;
			len ++;
		}
		return len;
	}
	
	PartialSum addListsHelper(LinkedListNode l1,LinkedListNode l2) {
		if(l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		int val = sum.carry + l1.data + l2.data;
		
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		
		sum.sum = full_result;
		sum.carry = val/10;
		return sum;
	}
	
	LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for(int i=0;i<padding;i++) {
			head = insertBefore(head,0);
		}
		return head;
	}
	LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if(list != null) {
			node.next = list;
		}
		return node;
	}
	LinkedListNode addLists(LinkedListNode l1,LinkedListNode l2,int carry) {
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		LinkedListNode result = new LinkedListNode(1);
		int value = carry;
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		
		if(l1 != null || l2!=null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next,
											l2 == null ? null : l2.next,
													value >= 10 ? 1: 0);
			result.next = more;					
		}
		return result;
	}
	
	public static void main(String args[]) {
		AddLists l = new AddLists();
		LinkedListNode l1 = new LinkedListNode(6);
		l1.appendToTail(1);//data값 
		l1.appendToTail(7);
		
		LinkedListNode l2 = new LinkedListNode(2);
		l2.appendToTail(9);//data값 
		l2.appendToTail(5);
		LinkedListNode r = l.addLists(l1, l2);
		while(r!=null) {
			System.out.println(r.data);
			r = r.next;
		}
	}
}
