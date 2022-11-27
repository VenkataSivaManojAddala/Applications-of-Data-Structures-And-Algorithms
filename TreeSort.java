import java.util.Scanner;
class TreeNode{
    int value;
    TreeNode right,left;
    TreeNode(int data){
        this.value=data;
        this.left=null;
        this.right=null;
    }
}
class BST{
    TreeNode Root=null;
    private TreeNode addR(TreeNode root, int value) {
        if (root==null) {
            return new TreeNode(value);
        }
        if (root.value>value) {
            root.left=addR(root.left,value);
            return root;
        }
        if (root.value<value) {
            root.right=addR(root.right,value);
            return root;
        }
        return root;
    }
    public void add(int value) {
        Root=addR(Root,value);
    }
    public void inorder (TreeNode root) {
        if (root!=null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }
    public void Descending (TreeNode root) {
        if (root!=null) {
            Descending(root.right);
            System.out.println(root.value);
            Descending(root.left);
        }
    }
}
public class TreeSort {
    private final BST BT=new BST();
    public void sort() {
        BT.inorder(BT.Root);
    }
    public void insertion(int[] arr){
        for (int j : arr) {
            BT.add(j);
        }
    }
    private final BST BTD=new BST();
    public void Desc() {
        BTD.Descending(BTD.Root);
    }
    public void insert(int[] arr){
        for (int j : arr) {
            BTD.add(j);
        }
    }
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
    for (int i = 0; i < numbers.length; i++)
    {
        System.out.println("Please enter a number: ");
        numbers[i] = input.nextInt();
    }
        TreeSort TS =new TreeSort();
        System.out.println("The sorted values in the ascending order are: ");
        TS.insertion(numbers);
        TS.sort();
        System.out.println(" ");
        System.out.println("The sorted values in the descending order are: ");
        TreeSort TSD =new TreeSort();
        TSD.insert(numbers);
        TSD.Desc();
        
    }
}