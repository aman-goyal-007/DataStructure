
import java.util.Stack;

// This program is for infix to Postfix notation. Postfix notation helps in calculation. Not user can take operator and 2 operands before operator to perform operation.

public class Postfix {
	final static String openBrackets="{(";
	final static String closingBrackets=")}";
	public static void main(String...args){
		Postfix pf = new Postfix();
		//String expression="A*(B+C*D)+E";   Output should be ABCD*+*E+
		String expression="A*B^C+D"; // output should be ABC^*D+

		System.out.println(pf.doTransformation(expression));
	}
	
	
	String doTransformation(String expression){
		StringBuffer output=new StringBuffer();
		char[] expAr = expression.toCharArray();
		char getChar;
		int currentPrecedence;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<expAr.length;i++){
			getChar=expAr[i];
			if((currentPrecedence=ifOperatorGetPrecedence(getChar))!=-1){
				while(true){
					if(!stack.isEmpty()){
						char prev=stack.peek();
						int prevPrec=ifOperatorGetPrecedence(prev);
						if(prevPrec!=-1 && prevPrec>currentPrecedence)
							output.append(stack.pop()+"");
						else {
							stack.push(getChar);
							break;
						}
					}else
					{
						stack.push(getChar);
						break;
					}
				}
			}else if(isCloseBracket(getChar)){
				while(true && !stack.isEmpty()){
					char prev=stack.peek();
					if(!isOpenBracket(prev)){
						output.append(stack.pop()+"");
					}else{
						stack.pop();
						break;
					}
				}
			}else if(isOpenBracket(getChar)){
				stack.push(getChar);
			}else{
				output.append(getChar);
			}
			
			
		}
		while(!stack.isEmpty()){
			output.append(stack.pop()+"");
		}
		return output.toString();
	}
	
	int ifOperatorGetPrecedence(char oper){
		int precedence=-1;
		switch(oper){
		case '+':
			precedence=1;
			break;
		case '-':
			precedence=1;
			break;
		case '*':
			precedence=2;
			break;
		case '/':
			precedence=2;
			break;
		case '^':
			precedence=3;
			break;
			default:
				precedence=-1;
			
		}
		return precedence;
	}
	boolean isOpenBracket(char oper){
		if(openBrackets.contains(oper+"")) return true;
		else return false;
	}
	boolean isCloseBracket(char oper){
		if(closingBrackets.contains(oper+"")) return true;
		else return false;
	}
	
	
}




