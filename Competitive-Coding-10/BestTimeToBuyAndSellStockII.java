// TC: O(n)
// SC: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j, n;
        int maxProfit = 0;
        n = prices.length;
        while(i < n) {
            j = i;
            while(j < n - 1 && prices[j] < prices[j + 1]) {
                j++;
            }
            maxProfit += prices[j] - prices[i];
            i = j + 1;
        }
        return maxProfit;
    }
}