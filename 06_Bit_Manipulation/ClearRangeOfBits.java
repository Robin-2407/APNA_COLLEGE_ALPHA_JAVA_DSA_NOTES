public class ClearRangeOfBits {
    public static int clearRange(int n, int i, int j) {
        int a = (~0) << (j + 1); // 1s before j
        int b = (1 << i) - 1; // 1s after i
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void main(String[] args) {
        System.out.println(clearRange(10, 2, 4)); // Output: 8
    }
}
