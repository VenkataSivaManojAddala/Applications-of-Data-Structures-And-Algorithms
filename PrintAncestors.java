class Node
{
    int data;
    Node left = null, right = null;
    Node(int data) {
        this.data = data;
    }
}
public class PrintAncestors
{
    public static boolean Ancestors(Node root, Node node)
    {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        boolean left = Ancestors(root.left, node);
        boolean right = false;
        if (!left) {
            right = Ancestors(root.right, node);
        }
        if (left || right) {
            System.out.print(root.data + " ");
        }
        return left || right;
    }
    public static void main(String[] args)
    {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(50);
        root.left.left = new Node(40);
        root.left.left.left = new Node(70);
        root.left.left.left.left = new Node(110);
        root.left.left.left.right = new Node(120);
        root.left.right.left = new Node(80);
        root.left.right.right = new Node(90);
        root.right.left = new Node(60);
        root.right.right = new Node(100);
        root.right.right.left = new Node(130);
        root.right.right.right = new Node(140);
        Node node = root.left.left.left.right; 
        System.out.println("The Ancestors for the given node is :");
        Ancestors(root, node);
    }
} 