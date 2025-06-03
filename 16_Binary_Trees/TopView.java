import java.util.HashMap;
import java.util.Queue;

public class TopView {
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
        Node node;
        int horizontalDistance;

        Info(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    public static void topView(Node root) {
        if (root == null) {
            return; // If the tree is empty, there's nothing to print
        }
        Queue<Info> queue = new java.util.LinkedList<>();
        HashMap<Integer, Node> topViewMap = new HashMap<>();

        int min = 0; // To track the minimum horizontal distance
        int max = 0; // To track the maximum horizontal distance
        queue.add(new Info(root, 0)); // Start with the root node at horizontal distance 0
        queue.add(null); // Marker for level end
        while (!queue.isEmpty()) {
            Info currInfo = queue.poll();
            if (currInfo == null) {
                if (!queue.isEmpty()) {
                    queue.add(null); // Add marker for the next level
                } else {
                    break; // If the queue is empty after this, we are done
                }
            } else {
                Node currNode = currInfo.node;
                int horizontalDistance = currInfo.horizontalDistance;

                // If this horizontal distance is not already in the map, add it
                if (!topViewMap.containsKey(horizontalDistance)) {
                    topViewMap.put(horizontalDistance, currNode);
                }

                // Update min and max horizontal distances
                min = Math.min(min, horizontalDistance);
                max = Math.max(max, horizontalDistance);

                // Add left child with horizontal distance - 1
                if (currNode.left != null) {
                    queue.add(new Info(currNode.left, horizontalDistance - 1));
                }
                // Add right child with horizontal distance + 1
                if (currNode.right != null) {
                    queue.add(new Info(currNode.right, horizontalDistance + 1));
                }
            }
        }

        // Print the top view from min to max horizontal distance
        for (int i = min; i <= max; i++) {
            if (topViewMap.containsKey(i)) {
                System.out.print(topViewMap.get(i).data + " "); // Print the node data
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root); // Call the topView method to print the top view of the tree
    }
}

/*
 * Tree structure:
 * 1
 * / \
 * 2 3
 * / \ / \
 * 4 5 6 7
 * 
 * Top view output: 4 2 1 3 7
 * 
 * Tc O(N) - where N is the number of nodes in the tree
 * Sc O(N) - for the queue and the map to store the top view nodes
 */