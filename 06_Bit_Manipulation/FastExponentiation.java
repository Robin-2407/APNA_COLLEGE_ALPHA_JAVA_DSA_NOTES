public class FastExponentiation {
    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static int modularExpo(int a, int n, int m) {
        int ans = 1;
        a = a % m; // Update a if it is more than or equal to m
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = (ans * a) % m;
            }
            a = (a * a) % m;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastExpo(5, 3));
    }
}

// Tc = O(log n)
// Sc = O(1)