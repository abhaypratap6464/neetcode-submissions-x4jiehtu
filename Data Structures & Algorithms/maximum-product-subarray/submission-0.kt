class Solution {
    fun maxProduct(nums: IntArray): Int {
        var curMax = nums[0]
        var curMin = nums[0]
        var result = nums[0]

        for(i in 1 until nums.size){
            val temp = curMax

            curMax = maxOf(nums[i],curMax * nums[i], curMin*nums[i])
            curMin = minOf(nums[i],temp*nums[i],curMin * nums[i])

            result = maxOf(result,curMax)
        }

        return result
    }
}
