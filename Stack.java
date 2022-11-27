import java.util.Scanner;
//First here we are creating a class for implementing Stack.
public class Stack {
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
		return (top==length-1)?true:false;
	}
	public boolean isEmpty() {
		return (top==-1)?true:false;
	}
	public static void main(String[] args) {
        System.out.print("Enter the expression you want to check : ");
		// Taking the input that is expressiion from the user.
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
		Stack stack =new Stack(10);
		// Here we have used for loop for going to the each index of the expression given.
	for(int i=0;i< S.length();i++) {
			char X = S.charAt(i);
			if(X =='[' || X =='{' || X =='(') {
				//If the above condition satisfies then we push the values
				stack.push(X);
			}
			else if(X ==']' || X =='}' || X ==')') {
				// if the above comdition satisfies then push operation activates
				if(stack.isEmpty()) {
					// after removing all the elements after checking if there is a extra element then it is known as
					//UNBALANCED expression.
					System.out.println("THE GIVEN EXPRESSION IS UNBLANACED!!");
					System.exit(1);
				}
				else {
					//Now again checking each condition if the condition is true then the program will continue
					if(X ==']' && stack.pop()=='[') {
						continue;
					}
					else if(X ==')' && stack.pop()=='(') {
						continue;
					}
					else if(X =='}' && stack.pop()=='{') {
						continue;
					}
					else {
						System.out.println("THE GIVEN EXPRESSION IS UNBLANACED!!");
						System.exit(1);
					}
				}
			}
			
        }
			if(stack.isEmpty()) {
				System.out.println("THE GIVEN EXPRESSION IS BLANACED!!");
			}
			else {
				System.out.println("THE GIVEN EXPRESSION IS UNBLANACED!!");
			}
	}
}