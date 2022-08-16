package abc;
/** Stack Underflow Exception
 * 
 * @author Jonas da Silva
 *
 */
public class StackUnderflowException extends Exception {
	
	public StackUnderflowException() {
		this("Stack underflow error");
	}

	public StackUnderflowException(String message) {
		super(message);
	}

}
