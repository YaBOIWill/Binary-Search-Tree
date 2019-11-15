//node class
class Node {
    int value;
    Node left;
    Node right;
//node constructor
Node(int value) {
    this.value = value;
    right = null;
    left = null;
    }
}
//binary search tree class 
public class BST {
    Node root;
//binary tree constructor
public void BinaryTree(){
    this.root = null;
}
//methods for adding nodes
private Node addRecursive(Node current, int value) {
if (current == null) {
    return new Node(value);
}
if (value < current.value) {
    current.left = addRecursive(current.left, value);
} else if (value > current.value) {
    current.right = addRecursive(current.right, value);
} else {
    return current;
}
return current;
}
public void addRoot(int value) {
    root = addRecursive(root, value);
}
private boolean hasNodeRecursive(Node current, int value) {
if (current == null) {
    return false;
}
if (value == current.value) {
    return true;
}
return value < current.value
? hasNodeRecursive(current.left, value)
: hasNodeRecursive(current.right, value);
}

public boolean hasNode(int value) {
return hasNodeRecursive(root, value);
}
//prints preorder of tree
void printPreorder(Node node) {
if (node == null)
return;
//prints data of node 
System.out.println(node.value + " ");
//left subtree preorder
printPreorder(node.left);
//right subtree preorder
printPreorder(node.right);
}
//method for height
public static int getHeight(Node node) {
if (node!=null)
    return Math.max(getHeight(node.left), getHeight(node.right))+1;
else
    return -1;
}
//method to get balance
public static int getBalance(Node node) {
if (node!= null)
    return getHeight(node.left) - getHeight(node.right);
else
    return 0;
}
//main method
public static void main(String args[]) {
BST tree1 = new BST();
int arr[] = {5, 85, 89, 3, 2, 8, 65, 92};
//print out preorder, height and balance factor
for(int i = 0; i < arr.length; i++) tree1.addRoot(arr[i]); {
    System.out.println("\nPreorder traversal of binary tree is: ");
    tree1.printPreorder (tree1.root);
    System.out.println("");
}
//table for node, height, and balance factor
final Object[][] table = new String[9][];
table[0] = new String[] { "Node", "Height ", "   Balance Factor" };
table[1] = new String[] { "2", "0", "0" };
table[2] = new String[] { "65", "0", "0" };
table[3] = new String[] { "92", "0", "0" };
table[4] = new String[] { "8", "1", "-1" };
table[5] = new String[] { "89", "1", "-1" };
table[6] = new String[] { "85", "2", "0" };
table[7] = new String[] { "3", "1", "1" };
table[8] = new String[] { "5", "3", "-1" };
//table format
for (final Object[] row : table) {
    System.out.format("%15s%15s%15s\n", row);
}
    System.out.println("");
    }
}
