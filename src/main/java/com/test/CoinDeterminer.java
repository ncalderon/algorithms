package com.test;

public class CoinDeterminer {
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
