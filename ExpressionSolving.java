import java.lang.*;
class ExpressionSolving{
Node root;
public static class Node
{
	String data;
	Node left, right;
	Node(String d)
	{
		data = d;
		left = null;
		right = null;
	}
}
private static int toInt(String s)
{
	int num = 0;
	if (s.charAt(0) != '-')
		for(int i = 0; i < s.length(); i++)
			num = num * 10 + ((int)s.charAt(i) - 48);
	else
	{
		for(int i = 1; i < s.length(); i++)
		num = num * 10 + ((int)(s.charAt(i)) - 48);
		num = num * -1;
	}
	return num;
}
public static int evalTree(Node root)
{
	if (root == null)
		return 0;
	if (root.left == null && root.right == null)
		return toInt(root.data);
	int leftEval = evalTree(root.left);
	int rightEval = evalTree(root.right);
	if (root.data.equals("+"))
		return leftEval + rightEval;
	if (root.data.equals("-"))
		return leftEval - rightEval;
	if (root.data.equals("*"))
		return leftEval * rightEval;
	return leftEval / rightEval;
}
public static void main(String[] args)
{

	Node root = new Node("*");
	root.left = new Node("*");
	root.left.left = new Node("+");
    root.left.left.left = new Node("-");
    root.left.left.left.left = new Node("*");
    root.left.left.left.left.left = new Node("5");
	root.left.right = new Node("10");
    root.left.left.right = new Node("5");
    root.left.left.left.right = new Node("10");
    root.left.left.left.left.right = new Node("6");
	root.right = new Node("+");
	root.right.left = new Node("20");
	root.right.right = new Node("/");
    root.right.right.left = new Node("5");
    root.right.right.right = new Node("*");
    root.right.right.right.left = new Node("2");
    root.right.right.right.right = new Node("-");
    root.right.right.right.right.left = new Node("11");
    root.right.right.right.right.right = new Node("+");
    root.right.right.right.right.right.left = new Node("15");
    root.right.right.right.right.right.right = new Node("10");
	System.out.println("THE SOLUTION OF THE GIVEN EXPRESSION IS : "+evalTree(root));
	root = null;
}
}
