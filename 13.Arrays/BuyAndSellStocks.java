public class BuyAndSellStocks {
    public static int price(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int buyPrice = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < buyPrice) {
                buyPrice = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, arr[i] - buyPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(price(arr));
    }

}
