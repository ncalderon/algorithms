package com.test;

public class CoinDeterminer {


    /**
     * Challenge
     *
     * Have the function CoinDeterminer(num) take the input, which will be an integer ranging from 1 to 250, and return an integer output
     * that will specify the least number of coins, that when added, equal the input integer. Coins are based on a system as follows: there
     * are coins representing the integers 1, 5, 7, 9, and 11. So for example: if num is 16, then the output should be 2 because you can achieve
     * the number 16 with the coins 9 and 7. If num is 25, then the output should be 3 because you can achieve 25 with either 11, 9, and 5 coins
     * or with 9, 9, and 7 coins.
     *
     * Sample Test Cases
     *
     * Input:6
     *
     * Output:2
     *
     * Input:16
     *
     * Output:2
     *
     * @param num
     * @return
     */
    public static int coinDeterminer(int num) {
        int coins[] = {11, 9, 7, 5, 1};
        return findMinCoins(coins, coins.length, num);
    }

    private static int findMinCoins(int coins[], int length, int value) {
        if (value == 0) return 0;

        int res = 250;

        for (int i=0; i<length; i++)
        {
            if (coins[i] <= value)
            {
                int sub_res = findMinCoins(coins, length, value-coins[i]);

                if (sub_res != 250 && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }
}
