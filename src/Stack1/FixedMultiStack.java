package Stack1;
import java.util.*;
public class FixedMultiStack {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes  = new int[numberOfStacks];
	}
	
	public void push(int stackNum, int value) throws FullStackException{
		if(isFull(stackNum)) {
			throw new FullStackException();
		}
		//스택 포인터를 증가시키고 가장 꼭대기 값을 갱신한다.
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	//스택에서 값을 꺼낸다.
	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];//가장 꼭대기 값을 꺼낸다.
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}
	//꼭대기 원소를 반환한다.
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}
	//스택이 비어있으면 true를 반환한다.
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	//스택이 꽉 차 있으면 true를 반환한다.
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
	
	public static void main(String args[]) {
		
	}
}
