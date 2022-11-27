import java.util.Scanner;
class Stack {
    private char[] array;
	private int top = -1;
	private int length ;
	
	Stack(int length){
		this.length=length;
		array=new char[this.length];
	}
	//Here we have created a method for functioning the push operation.
	public void push(char d) {
		//if the Stack is full then it will just print Full;
		if(isFull()) {
			System.out.println("STACK IS FULL!!");
		}
		// if the Stack is not full then array[++top] value will be given to d.
		else {
			array[++top]= d;
		}
	}
	//Here we have created a method for functioning the pop operation.
	public char pop() {
		//if the Stack is empty then it will just print empty ;
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY!!");
			return 0;
		}
		// if the Stack is not empty then top value will be given to top before value.
		else {
			top=top-1;
			return array[top+1];
		}
	}
	// method for giving the top value of the stack.
	public char peek() {
		return array[top];
	}
	//Here we have created a method for displaying.
	public void display() {
		for(int i=0;i<=top;i++) {
			System.out.println(array[i]);
		}
	}
	public boolean isFull() {
		return top==length-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
}
//for the main function of the program we created a class .
public class IntoPost {
    //Now, we have created a function to convert from string to an array. 
    public static  char[] toArray(String String){
        return (String.toCharArray());
    }
    //Now we have to check whether the string which is given contains alphabets or numbers.
    public static boolean check(char ch){
        int c=ch;
        if ((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57) ){
            return true;
        }
        return false;
    }
    // Now we are giving the precedence for the characters in string.
    public static int precedence(char c){
        if (c=='^')
            return 3;
        else if(c=='/' || c=='*')
            return 2;
        else if (c=='+' || c=='-')
            return 1;
        else
        return 0;
    }
    public static void main(String args[]){
        //Taking the input that is expression from the user.
    System.out.print("Enter the expression: ");
    Scanner sc = new Scanner(System.in);
	String Expression = sc.nextLine();
    System.out.println("The Infix Expression is: "+Expression);
    String Output="";
    // Now we are converting input string to an array.
    char[] expression=IntoPost.toArray(Expression);
    Stack stack=new Stack(expression.length);
    // By using for loop first we sending all the alphabets and numerical values to the output string directly.
    for (int i=0; i<expression.length;i++){
    if (IntoPost.check(expression[i])){
        Output+=expression[i];
    }
    // if it is a '(' then we are pushing into the stack.
    else if(expression[i]=='('){
        stack.push(expression[i]);
    }
    //if it is a ')' then we have to pop all the elements in the stack till we get a '('.
    else if (expression[i]==')'){
        while (stack.peek()!='('){
            Output+=stack.pop();
        }
        stack.pop();
    }
    //Now for other operators in the given expression we are checking the precedence with element in the top of the stack and perform the operation.
    else {
        while((!stack.isEmpty()) && (IntoPost.precedence(expression[i])<=IntoPost.precedence(stack.peek())))
        {
            Output+=stack.pop();
        }
        stack.push(expression[i]);
    }
    }
    //At last some of the elements will be leftover in the stack and we should pop those elements.
        while (!stack.isEmpty()){
            Output+=stack.pop();
        }
        System.out.println("The Postfix of the given Expression is:  "+Output);
    }  }