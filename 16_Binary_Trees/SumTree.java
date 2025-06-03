public class SumTree {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to convert binary tree to sum tree
    public static int convertToSumTree(Node root) {
        if (root == null)
            return 0;

        // Save the current value
        int oldValue = root.data;

        // Recursively convert left and right subtrees
        int leftSum = convertToSumTree(root.left);
        int rightSum = convertToSumTree(root.right);

        // Set current node's data to sum of values of left and right subtrees
        root.data = leftSum + rightSum;

        // Return sum of current node's original value + new subtree sum (for parent's
        // computation)
        return root.data + oldValue;
    }

    // Helper method for in-order traversal to print the tree
    public static void printInOrder(Node root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Convert to Sum Tree
        convertToSumTree(root);

        // Print updated tree using in-order traversal
        System.out.print("In-order traversal of Sum Tree: ");
        printInOrder(root);
    }
}
