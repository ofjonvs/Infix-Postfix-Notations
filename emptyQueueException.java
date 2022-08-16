package abc;
/** Empty Queue Exception
 * 
 * @author Jonas da Silva
 *
 */
public class emptyQueueException extends Exception {

	public emptyQueueException() {
		super("Queue empty");
    }
	
    public emptyQueueException(String str) {
    	super(str);
    }
}