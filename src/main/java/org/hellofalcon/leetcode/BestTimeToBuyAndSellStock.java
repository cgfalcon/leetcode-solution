package org.hellofalcon.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * @author - chugang.cg
 * @create - 2019/2/10
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    continue;
                }

                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        BestTimeToBuyAndSellStock bts = new BestTimeToBuyAndSellStock();
        System.out.println(bts.maxProfit(prices));
    }
}
