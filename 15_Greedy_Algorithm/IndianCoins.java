import java.util.ArrayList;

public class IndianCoins {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        ArrayList<Integer> coinList = new ArrayList<>();
        int amount = 590;
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount = amount - coins[i];
                count++;
                coinList.add(coins[i]);
            }
        }
        System.out.println("Minimum number of coins required: " + count);
        System.out.println("Coins used: " + coinList);
    }
}
