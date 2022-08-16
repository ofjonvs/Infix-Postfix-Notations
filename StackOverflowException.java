package abc;
/** Stack Overflow Exception
 * 
 * @author Jonas da Silva
 *
 */
public class StackOverflowException extends Exception {
	
	public StackOverflowException() {
		this("Stack overflow error");
	}

	public StackOverflowException(String message) {
		super(message);
	}
	
	

}
