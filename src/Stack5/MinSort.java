package Stack5;

import java.util.Stack;

public class MinSort {
	Stack sort(Stack s,Stack r) {
		while(!s.isEmpty()) { 
			int tmp = (int) s.pop();
			while(!r.isEmpty() && (int)r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
		return s;
	}
	public static void main(String args[]) {
		MinSort m = new MinSort();
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		Stack stack = new Stack();
		s1.push(7);
		s1.push(10);
		s1.push(5);
		s2.push(1);
		s2.push(3);
		s2.push(8);
		s2.push(12);
		stack = m.sort(s1,s2);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
}
