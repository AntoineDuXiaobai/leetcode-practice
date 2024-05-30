//169.买卖股票的最佳时机

//1.  暴力法  时间复杂度O(n^2) 空间复杂度O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        for(int i=0; i<prices.length-1;i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]-prices[i]>max_profit){
                    max_profit = prices[j]-prices[i];
                }
            }
        }
        return max_profit;
    }
}


//2. 动态规划   时间复杂度O(n) 空间复杂度O(n)
//第i天的最大收益只需要知道前i天的最低点就可以算出来了。
// 而第i天以前（包括第i天）的最低点和i-1天的最低点有关，至此我们的动态方程就出来了。
//dp[i] = min(d[i-1],prices[i])
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];
        int max = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            max = Math.max(max, prices[i] - dp[i]);
        }

        return max;
    }
}


//优化空间复杂度   时间复杂度O(n) 空间复杂度O(1)
//尽管上述方法已经非常直观地展示了动态规划的思路，但我们其实可以优化空间复杂度，
// 因为我们只需要前一天的最低价格来更新当天的最低价格，而不需要整个 dp 数组。下面是优化后的代码：
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }


