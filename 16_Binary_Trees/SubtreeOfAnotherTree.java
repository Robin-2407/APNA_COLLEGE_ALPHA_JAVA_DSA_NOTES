public class SubtreeOfAnotherTree {
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

    public static boolean isSubtree(Node rootNode, Node subRootNode) {
        if (subRootNode == null) {
            return true; // An empty tree is a subtree of any tree
        }
        if (rootNode == null) {
            return false; // Non-empty tree cannot be a subtree of an empty tree
        }
        if (rootNode.data == subRootNode.data) {
            if (isIdentical(rootNode, subRootNode)) {
                return true; // If the current nodes match, check if the trees are identical
            }
        }
        // Recursively check left and right subtrees
        return isSubtree(rootNode.left, subRootNode) || isSubtree(rootNode.right, subRootNode);
    }

    public static boolean isIdentical(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) {
            return true; // Both trees are empty
        }
        if (tree1 == null || tree2 == null) {
            return false; // One tree is empty, and the other is not
        }
        // Check if the current nodes are equal and recurse for left and right subtrees
        return (tree1.data == tree2.data)
                && isIdentical(tree1.left, tree2.left)
                && isIdentical(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.left.left = new Node(6);

        Node root2 = new Node(2);
        root2.left = new Node(4);
        root2.right = new Node(5);

        System.out.println(isSubtree(root1, root2)); // Should return true
    }
}

/*
 * Trees are
 * 1
 * / \
 * 2 3
 * / \
 * 4 5
 * 
 * and
 * 2
 * / \
 * 4 5
 * 
 * The second tree is a subtree of the first tree.
 */