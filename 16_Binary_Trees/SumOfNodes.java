public class SumOfNodes {
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

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0; // Sum of an empty tree is 0
        }
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right); // Sum is root's data plus left and right
                                                                           // subtree sums
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Sum of nodes in the tree: " + sumOfNodes(root));
    }
}
// Output: Sum of nodes in the tree: 21