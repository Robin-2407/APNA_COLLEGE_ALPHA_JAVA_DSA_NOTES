import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {
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

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Preorder Traversal: Root -> Left -> Right
        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // Inorder Traversal: Left -> Root -> Right
        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        // Postorder Traversal: Left -> Right -> Root
        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal : BFS
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null); // Marker for end of level
            while (!queue.isEmpty()) {
                Node currNode = queue.poll();
                if (currNode == null) {
                    System.out.println();
                    if (!queue.isEmpty()) {
                        queue.add(null); // Add marker for next level
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Tree built successfully with root value: " + root.data);

        System.out.print("Preorder Traversal: ");
        tree.preOrder(root);
        System.out.println();

        System.out.print("Inorder Traversal: ");
        tree.inOrder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postOrder(root);
        System.out.println();

        System.out.println("Level Order Traversal:");
        tree.levelOrder(root);
        System.out.println();
    }
}

// PreOrder Traversal
// Tc : O(n)
// Sc : O(h) where h is height of tree (for recursion stack)

// InOrder Traversal
// Tc : O(n)
// Sc : O(h) where h is height of tree (for recursion stack)

// PostOrder Traversal
// Tc : O(n)
// Sc : O(h) where h is height of tree (for recursion stack)

// Level Order Traversal
// Tc : O(n)
// Sc : O(n) for queue
// Note: In all traversals, n is the number of nodes in the tree.