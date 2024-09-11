package data_structure;

import exception.MyStackException;

public interface MyStack {
	void push(int x) throws MyStackException;
	int pop() throws MyStackException;
	int top();
	int getMax();
}
