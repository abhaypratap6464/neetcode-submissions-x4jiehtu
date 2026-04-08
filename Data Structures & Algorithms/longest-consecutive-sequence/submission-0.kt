class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if(nums.isEmpty()) return 0

        val numset = nums.toHashSet()
        var maxLength = 0

        for(num in numset){
            if(num -1 !in numset){
                var currentNum = num
                var currentLength = 1

                while(currentNum+1 in numset){
                    currentNum++
                    currentLength++
                }
                maxLength = maxOf(maxLength,currentLength)
            }
        }
        return maxLength
    }
}
