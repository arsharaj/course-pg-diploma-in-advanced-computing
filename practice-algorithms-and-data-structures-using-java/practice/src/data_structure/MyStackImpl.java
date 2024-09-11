package data_structure;

import exception.MyStackException;

public class MyStackImpl implements MyStack {
	private int size;
	private int[] stack;
	private int top;
	private int max;
	
	public MyStackImpl(int size) {
		this.size = size;
		this.stack = new int[size];
		this.top = -1;
		this.max = -1;
	}

	@Override
	public void push(int x) throws MyStackException {
		if (top + 1 == size) {
			throw new MyStackException("Stack Overflow");
		} else {
			top++;
			stack[top] = x;
			System.out.println("Element inserted successfully.");
		}
	}

	@Override
	public int pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException("Stack Underflow");
		} else {
			System.out.println("Element removed successfully.");
			int elem = stack[top];
			top--;
			return elem; 
		}
	}

	@Override
	public int top() {
		if (top == -1) {
			return -1;
		} else {
			return stack[top];
		}
	}

	@Override
	public int getMax() {
		if (top == -1) {
			return -1;
		} else {
			for (int i = 0; i < top; i++) {
				if (stack[i] > max) {
					max = stack[i];
				}
			}
		}
		return max;
	}

}
