public class MinimumDistanceBetweenNodes {
    public static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static int findDistance(Node root, int n1, int n2) {
        Node lca = findLCA(root, n1, n2);
        if (lca == null) {
            return -1; // If LCA is not found, return -1
        }
        return distanceFromLCA(lca, n1) + distanceFromLCA(lca, n2);
    }

    public static Node findLCA(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root; // If both left and right LCA are not null, root is LCA
        }
        return (leftLCA != null) ? leftLCA : rightLCA; // Return the non-null child
    }

    public static int distanceFromLCA(Node lca, int n) {
        if (lca == null) {
            return -1; // If LCA is null, return -1
        }
        if (lca.data == n) {
            return 0; // If LCA is the target node, distance is 0
        }
        int leftDistance = distanceFromLCA(lca.left, n);
        int rightDistance = distanceFromLCA(lca.right, n);

        if (leftDistance == -1 && rightDistance == -1) {
            return -1; // If both distances are -1, target node not found
        }
        return (leftDistance != -1 ? leftDistance : rightDistance) + 1; // Return the distance
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 6;
        int distance = findDistance(root, n1, n2);
        if (distance != -1) {
            System.out.println("Distance between " + n1 + " and " + n2 + " is: " + distance);
        } else {
            System.out.println("One or both nodes not found in the tree.");
        }
    }
}