package abc;
import java.util.*;
/** Notation Stack
 * 
 * @author Jonas da Silva
 *
 */
public class NotationStack<T> implements StackInterface<T>{
	
	private ArrayList<T> stack;
	private int top;
	private int capacity;
	
	NotationStack(int capacity){
		stack = new ArrayList<>();
		this.capacity = capacity;
		this.top = -1;
	}
	
	NotationStack(){
		stack = new ArrayList<>();
		capacity = 100;
	}
	

	@Override
	public int size() {
		return stack.size();
	}

	
	@Override 
	public String toString() {
		String str = "";
		for(T type: stack) {
			str += type.toString();
		}
		return str;
	}

	@Override
	public String toString(String delimiter) {
		String str = "";
		int size = stack.size();
		for(int i = 0; i < stack.size(); i++) {
			if(i == size - 1)
				str += stack.get(i);
			else
				str += stack.get(i) + delimiter;
		}
		return str;
	}

	@Override
	public void fill(ArrayList list){
		List<T> copiedList = new ArrayList<>(list);
		for(int i=0 ;i < list.size(); i++) {
			stack.add(i, copiedList.get(i));
			top++;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) 
			throw new StackUnderflowException();
		T poppedObject = stack.get(top);
		stack.remove(top--);
		return poppedObject;
	}

	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty()) 
			throw new StackUnderflowException();
		return stack.get(top);
	}


	@Override
	public boolean push(T e) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
		}
		stack.add(e);
		top++;
		return true;
	}
	
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		if(top == capacity - 1) 
			return true;
		return false;
	}

}
