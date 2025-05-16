
public class BuyAndSellStocks {
    public static int stocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Max Profit is " + stocks(prices));

    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// The space complexity is O(1) because we are using only a constant amount of
// extra space (buyPrice and maxProfit).
