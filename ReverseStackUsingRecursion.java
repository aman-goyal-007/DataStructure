
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseStackUsingRecursion
{
    public static void main(String [] args) 
    {
    	try{
    		Stack<Integer> stack = new Stack<>();
    		stack.add(1);
    		stack.add(2);
    		stack.add(3);
    		stack.add(4);
    		stack.add(5);
    		System.out.println("Before Reverse");
    		stack.stream().forEach(System.out::println);
    		reverseStack(stack);
    		System.out.println("After Reverse");
    		stack.stream().forEach(System.out::println);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    static void reverseStack(Stack<Integer> givenStack){
    	if(givenStack.size()!=0){
    		int element=givenStack.pop();
    		reverseStack(givenStack);
    		addAtBottom(givenStack, element);
    	}
    }
    static void addAtBottom(Stack<Integer> givenStack,int element){
    	if(givenStack.isEmpty()){
    		givenStack.push(element);
    	}else{
    		int e=givenStack.pop();
    		addAtBottom(givenStack, element);
    		givenStack.push(e);
    	}
    }
}
