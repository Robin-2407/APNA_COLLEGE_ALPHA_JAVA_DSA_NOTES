import java.util.LinkedList;
import java.util.Queue;

public class KthLevelOfATree {
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

    public static void LevelOrder(Node root, int k) {
        if (root == null) {
            return; // If the tree is empty, there's nothing to print
        }
        if (k < 0) {
            return; // Invalid level
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Marker for level end
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode == null) {
                if (currentLevel == k) {
                    break; // Stop processing if we reached the desired level
                }
                currentLevel++;
                if (!queue.isEmpty()) {
                    queue.add(null); // Add marker for the next level
                }
            } else {
                if (currentLevel == k) {
                    System.out.print(currentNode.data + " "); // Print node at level k
                }
                // Add left and right children to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        if (currentLevel < k) {
            System.out.println("No nodes at level " + k); // If no nodes were found at level k
        }

        System.out.println(); // New line after printing all nodes at level k

        for (Node node : queue) {
            if (node != null) {
                System.out.print(node.data + " "); // Print remaining nodes in the queue
            }
        }

    }

    public static int kthLevel(Node root, int k) {
        if (root == null) {
            return 0; // If the tree is empty, return 0
        }
        if (k < 0) {
            return 0; // Invalid level
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Marker for level end
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode == null) {
                if (currentLevel == k) {
                    break; // Stop processing if we reached the desired level
                }
                currentLevel++;
                if (!queue.isEmpty()) {
                    queue.add(null); // Add marker for the next level
                }
            } else {
                if (currentLevel == k) {
                    System.out.print(currentNode.data + " "); // Print node at level k
                }
                // Add left and right children to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return currentLevel; // Return the current level reached
    }

    public static void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
        }
        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2; // Level to print
        System.out.println("Nodes at level " + k + ":");
        LevelOrder(root, k); // Call the method to print nodes at level k

        System.out.println("Using kthLevel method:");
        kthLevel(root, 0, k); // Call the method to print nodes at level k using recursion
        System.out.println(); // New line after printing all nodes at level k
    }
}

// Tc O(n), where n is the number of nodes in the tree.
// Sc O(n), where n is the number of nodes in the tree (due to the queue used
// for level order traversal)