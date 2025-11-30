class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0

        var amounts = IntArray(amount+1)
        amounts[0] = 0
        for (i in 1..amount)
            amounts[i] = amount + 1

        // if i == coin then 1 + amounts[i - coin] always = 1 because d[0] = 0
        for (coin in coins)
            for (i in coin..amount)
                amounts[i] = min(amounts[i], 1 + amounts[i - coin])
           

        return if (amounts.last() == amount+1) -1 else amounts.last()
    }
}