public class DaimeterOfTree {
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

    public static class Info {
        int height;
        int diameter;

        Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Info diameterOfTreeOptimized(Node root) {
        if (root == null) {
            return new Info(0, 0); // Height and diameter of an empty tree
        }

        Info leftInfo = diameterOfTreeOptimized(root.left); // Info for left subtree
        Info rightInfo = diameterOfTreeOptimized(root.right); // Info for right subtree

        int height = 1 + Math.max(leftInfo.height, rightInfo.height); // Height of the current node
        int diameter = Math.max(leftInfo.diameter,
                Math.max(rightInfo.diameter, leftInfo.height + rightInfo.height + 1)); // Diameter through the current
                                                                                       // node

        return new Info(height, diameter); // Return the height and diameter
    }

    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0; // Diameter of an empty tree is 0
        }

        int leftDiameter = diameterOfTree(root.left); // Diameter of left subtree
        int leftHeight = height(root.left); // Height of left subtree
        int rightDiameter = diameterOfTree(root.right); // Diameter of right subtree
        int rightHeight = height(root.right); // Height of right subtree

        int selfDiameter = leftHeight + rightHeight + 1; // Diameter through the root
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter)); // Maximum of self, left, and right
                                                                              // diameters
    }

    public static int height(Node root) {
        if (root == null) {
            return 0; // Height of an empty tree is 0
        }
        return 1 + Math.max(height(root.left), height(root.right)); // Height is 1 plus the maximum height of left
                                                                    // and right subtrees
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println("Diameter of the tree: " + diameterOfTree(root));

        Info info = diameterOfTreeOptimized(root);
        System.out.println("Diameter of the tree (Optimized): " + info.diameter);
    }
}

// bruteforce approach
// Time Complexity: O(n^2) for diameterOfTree
// Space Complexity: O(n) for the recursion stack

// Optimized approach
// Time Complexity: O(n) for diameterOfTreeOptimized
// Space Complexity: O(h) for the recursion stack, where h is the height of the
// tree