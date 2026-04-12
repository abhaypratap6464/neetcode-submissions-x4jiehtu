class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for(price in prices){
            when{
                price<minPrice -> minPrice = price
                (price-minPrice) > maxProfit -> maxProfit = price - minPrice
            }
        }

        return maxProfit
        
    }
}
