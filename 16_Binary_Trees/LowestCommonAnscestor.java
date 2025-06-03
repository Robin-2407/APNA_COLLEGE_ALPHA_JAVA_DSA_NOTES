import java.util.ArrayList;

public class LowestCommonAnscestor {
    public static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false; // Base case: if the node is null, return false
        }
        path.add(root); // Add the current node to the path
        if (root.data == n) {
            return true; // If the current node is the target node, return true
        }
        // Recursively search in the left and right subtrees
        boolean leftFound = getPath(root.left, n, path);
        boolean rightFound = getPath(root.right, n, path);
        if (leftFound || rightFound) {
            return true; // If the target node is found in either subtree, return true
        }
        path.remove(path.size() - 1); // If not found, remove the current node from the path
        return false; // Return false if the target node is not found in this path
    }

    public static Node findLCA(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1); // Get the path to n1
        getPath(root, n2, path2); // Get the path to n2

        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break; // Stop when paths diverge
            }
        }

        Node lca = path1.get(path1.size() - 1); // The last common node is the LCA
        return lca; // Return the lowest common ancestor
    }

    public static Node findLCAOptimized(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLCA = findLCAOptimized(root.left, n1, n2);
        Node rightLCA = findLCAOptimized(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root; // If both left and right LCA are not null, root is LCA
        }
        return (leftLCA != null) ? leftLCA : rightLCA; // Return the non-null child
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;
        Node lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.data);
        } else {
            System.out.println("LCA not found");
        }
    }
}

// tc O(n) for getPath and O(min(h1, h2)) for findLCA where h1 and h2 are the
// heights of the paths to n1 and n2 respectively.
// sc O(n) for the path storage in getPath
// and O(min(h1, h2)) for the path storage in findLCA.
// The overall time complexity is O(n) and space complexity is O(n) in the worst
// case.
// we can optimize the space complexity by using a different approach that
// doesn't require storing the paths.
// This can be done by traversing the tree and checking if the current node is
// the LCA of n1 and n2.
// This approach uses recursion and does not require additional space for
// storing paths.
// Here's the optimized version of the LCA finding algorithm:
// public static Node findLCA(Node root, int n1, int n2) {
// if (root == null) {
// return null; // Base case: if the node is null, return null
// }
// if (root.data == n1 || root.data == n2) {
// return root; // If the current node is either n1 or n2, return it
// }
// Recursively search in the left and right subtrees
// Node leftLCA = findLCA(root.left, n1, n2);
// Node rightLCA = findLCA(root.right, n1, n2);
// if (leftLCA != null && rightLCA != null) {
// return root; // If both subtrees contain one of the nodes, the current node
// is the LCA
// }
// return (leftLCA != null) ? leftLCA : rightLCA; // Return the non-null child
// }
// This version of the findLCA method has a time complexity of O(n) and a space
// complexity of O(h), where h is the height of the tree.