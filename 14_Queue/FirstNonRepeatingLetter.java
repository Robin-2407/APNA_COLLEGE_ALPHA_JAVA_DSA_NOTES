import java.util.Queue;
import java.util.LinkedList;

public class FirstNonRepeatingLetter {
    public static void printNonRepeating(String str) {
        int freq[] = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Add character to the queue
            queue.add(ch);

            // Increment frequency of the character
            freq[ch - 'a']++;

            // Remove characters from the front of the queue if they are repeating
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.remove();
            }

            // Print the first non-repeating character
            if (queue.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek() + " ");
            }

        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}

// TC : O(n)
// SC : O(1) for frequency array, O(n) for queue in worst case
// Output: a -1 b b b b x