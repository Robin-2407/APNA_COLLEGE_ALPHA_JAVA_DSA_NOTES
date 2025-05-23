public class CountSetBits {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1; // Right shift n by 1 bit
        }
        return count;

    }

    public static void main(String[] args) {
        int n = 16; // Example number
        int result = countSetBits(n);
        System.out.println("Number of set bits in " + n + " is: " + result);
    }
}
