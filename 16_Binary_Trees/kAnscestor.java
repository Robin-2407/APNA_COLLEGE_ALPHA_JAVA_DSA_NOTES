public class kAnscestor {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int kanscestor(Node root, int n, int k) {
        if (root == null) {
            return -1; // Base case: if the node is null, return -1
        }
        if (root.data == n) {
            return 0; // If the current node is the target node, return 0
        }

        int left = kanscestor(root.left, n, k); // Search in the left subtree
        int right = kanscestor(root.right, n, k); // Search in the right subtree

        if (left == -1 && right == -1) {
            return -1; // If the target node is not found in either subtree, return -1
        }
        int max = Math.max(left, right); // Get the maximum depth from the left and right subtrees
        if (max + 1 == k) {
            System.out.println("The " + k + "th ancestor of node " + n + " is: " + root.data);
        }
        return max + 1; // Return the depth of the current node
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n = 4; // Node for which we want to find k ancestors
        int k = 1; // Number of ancestors to find

        int result = kanscestor(root, n, k);
    }
}