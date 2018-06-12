package Stack4;
import java.util.*;
public class MyQueue {
	Stack stackNewest, stackOldest;
	public MyQueue() {
		stackNewest = new Stack();
		stackOldest = new Stack();
	}
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	public void add(int value) {
		//새로운 원소가 상단에 놓이도록 stackNewest에 원소를 삽입한다.
		stackNewest.push(value);
	}
	//stackNewest에서 stackOldest로 원소르 옮긴다. stackOldset 연산을 수행하기 위한 작업이다.
	private Stack shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
		return stackOldest;
	}
	public int peek() {
		shiftStacks();
		return (int) stackOldest.peek();
	}
	public int remove() {
		shiftStacks();
		return (int) stackOldest.pop();
	}
	public static void main(String args[]) {
		MyQueue m = new MyQueue();
		Stack stack = new Stack();
		m.add(1);
		m.add(2);
		m.add(3);
		m.add(4);
		m.add(5);
		stack=m.shiftStacks();
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
