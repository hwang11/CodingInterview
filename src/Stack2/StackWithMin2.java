package Stack2;
import java.util.*;
public class StackWithMin2 extends Stack{
	Stack s2;
	public StackWithMin2() {
		s2 = new Stack();
	}
	public void push(int value) {
		if(value <= min()) s2.push(value);
		super.push(value);
	}
	public Integer pop() {
		int value = (int) super.pop();
		if(value == min()) s2.pop();
		return value;
	}
	public int min() {
		if(s2.isEmpty()) return Integer.MAX_VALUE;
		else return (int) s2.peek();
	}	
	public static void main(String args[]) {
		StackWithMin2 s = new StackWithMin2();
		s.push(5);
		s.push(6);
		s.push(3);
		s.push(7);
		s.pop();
		//s.pop();
		System.out.println(s.min());
	}
}
