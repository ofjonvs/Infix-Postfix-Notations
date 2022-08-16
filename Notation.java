package abc;
/** Notation class
 * 
 * @author Jonas da Silva
 *
 */
import java.util.ArrayList;

public class Notation {
	
	public Notation() {}
	
	public static double evaluatePostfixExpression​(String postfixExpr)
			throws InvalidNotationFormatException{
		NotationStack<Double> stack = new NotationStack<>(postfixExpr.length());
		char[] charArray = postfixExpr.toCharArray();
		try {
			for(char ch : charArray) {
				if (Character.isDigit(ch) || ch == '(') {
                    stack.push(Double.parseDouble(Character.toString(ch)));
                    continue;
				}
				if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                    if (stack.size() < 2) 
                            throw new InvalidNotationFormatException();
			}
				double x = stack.pop();
                double y = stack.pop();
				if(ch == '*') 
					stack.push(x * y);
				
				if(ch == '/') 
					stack.push(y / x);
				
				if(ch == '-') 
					stack.push(y - x);
				
				if(ch == '+') 
					stack.push(x + y);
		}
	} 
	catch (StackOverflowException | StackUnderflowException ignore) {
		throw new InvalidNotationFormatException();
	}
	if (stack.size() > 1) 
        throw new InvalidNotationFormatException();
	
	return Double.parseDouble(stack.toString());
}
	
	
	
	public static String convertPostfixToInfix​(String postfix) 
			throws InvalidNotationFormatException{
		NotationStack<String> stack = new NotationStack<>(postfix.length());
		try {
			for(int i = 0; i < postfix.length(); i++) {
				char ch = postfix.charAt(i);
				if(Character.isDigit(ch)) {
					stack.push(Character.toString(ch));
				}
				if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                    if (stack.size() < 2) 
                            throw new InvalidNotationFormatException();
                    String first = stack.pop();
                    String second = stack.pop();
                    String str = "(" + second + ch + first + ")";
                    stack.push(str);
				}
			}
		}
		catch (StackUnderflowException | StackOverflowException ignore) {
			throw new InvalidNotationFormatException();	
	}
		if (stack.size() > 1) 
	        throw new InvalidNotationFormatException();
	return stack.toString();
	}
	
	public static String convertInfixToPostfix​(String infix)
			throws InvalidNotationFormatException{
		NotationStack<String> stack = new NotationStack<>(infix.length());
		NotationQueue<String> queue = new NotationQueue<>(infix.length());
		//char[] charArray = new char[] {};
		ArrayList<String> charArrayList = new ArrayList<String> ();
		for(int i = 0; i< infix.length(); i++) {
			String temp = "";
			if(Character.isDigit(infix.charAt(i))){
				temp += infix.charAt(i);
				if(i == infix.length() - 1)
					continue;
				if(Character.isDigit(infix.charAt(i + 1))) {
					temp += infix.charAt(i + 1);
					i++;
				}
				charArrayList.add(temp);
				continue;
			}
			temp += infix.charAt(i);
			charArrayList.add(temp);
		}
        try {
        	for(String str : charArrayList) {
        		int d = -1;
        		try {
        			 d = Integer.parseInt(str);
        		}
        		catch (NumberFormatException nfe) {}
        		if(d != -1) {
        			if(d >= 10) {
        				str = "(" + d + ")";
        				queue.enqueue(str);
        			//	stack.push(str);
        			}
        			else {
        				str = "" + d;
        				queue.enqueue(str);
        				//stack.push(str);
        			}
        		}
        		if(str.equals("("))
        			stack.push(str);
        		if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
        			if(queue.isEmpty()) 
        				stack.push(str);
        			String top = stack.top();
        			if(top.equals("*") || top.equals("/"))
        				queue.enqueue(stack.pop());
        			if(top.equals("+") && str.equals("+"))
        				queue.enqueue(stack.pop());
        			if(top.equals("-") && str.equals("-"))
        				queue.enqueue(stack.pop());
        			if(top.equals("+") && str.equals("-"))
        				queue.enqueue(stack.pop());
        			if(top.equals("-") && str.equals("+"))
        				queue.enqueue(stack.pop());
        			stack.push(str);       			
        		}
        		while(str.equals(")")) {
        			if(stack.top().equals("(")) {
        				if (stack.top() == null)
        					throw new InvalidNotationFormatException();
        				stack.pop();
        				break;
        			}
        			queue.enqueue(stack.pop());
        		}
        	}
        	
        }
        catch (QueueOverflowException | StackOverflowException | StackUnderflowException ignore) {
            throw new InvalidNotationFormatException();
    }
        return queue.toString();        
	}
	
	
}

