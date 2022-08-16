package abc;
/** Queue Overflow Exception
 * 
 * @author Jonas da Silva
 *
 */
public class QueueOverflowException extends Exception {
	
	public QueueOverflowException() {
		this("Queue overflow error");
	}

	public QueueOverflowException(String message) {
		super(message);
	}

}
