package abc;
/** Queue Underflow Exception
 * 
 * @author Jonas da Silva
 *
 */
public class QueueUnderflowException extends Exception {
	
	public QueueUnderflowException() {
		this("Queue underflow error");
	}

	public QueueUnderflowException(String message) {
		super(message);
	}

}
