package abc;
/** Invalid Notation Format Exception
 * 
 * @author Jonas da Silva
 *
 */

public class InvalidNotationFormatException extends Exception {
	
	public InvalidNotationFormatException() {
		this("Invalid notation format");
	}

	public InvalidNotationFormatException(String message) {
		super(message);
	}

}
