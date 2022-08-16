package abc;
/** Notation Queue
 * 
 * @author Jonas da Silva
 *
 */
import java.util.ArrayList;
import java.util.List;

public class NotationQueue<T> implements QueueInterface<T> {
	
	private ArrayList<T> queue;
	//private Node first = null;
  //  private Node last = null;
    private int size;
    
    private class Node {
        public Node(T newEntry) {
		}
		private Node next;
		private T newEntry;
    }
    
    public NotationQueue() {
    	queue = new ArrayList<>();
        size = 100;
        }
    
    public NotationQueue(int size) {
    	queue = new ArrayList<>(size);
        this.size = size;
    }

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public boolean isFull() {
		return queue.size() >= size; 
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException();
		T deq = queue.get(0);
		queue.remove(0);
		queue.ensureCapacity(size);
		return deq;
}
	

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(queue.size() >= size) 
			throw new QueueOverflowException();
		queue.add(e);
		return true;
	}
	
	public String toString() {
		String str = "";
		for(T type: queue) {
			str += type.toString();
		}
		return str;
	}

	@Override
	public String toString(String delimiter) {
		String str = "";
		int size = queue.size();
		for(int i = 0; i < queue.size(); i++) {
			if(i == size - 1)
				str += queue.get(i);
			else
				str +=queue.get(i) + delimiter;
		}
		return str;
	}

	@Override
	public void fill(ArrayList<T> list) {
		List<T> copiedList = new ArrayList<>(list);
		for(int i=0 ;i < list.size(); i++) {
			queue.add(i, copiedList.get(i)); 
		}
	}

}
