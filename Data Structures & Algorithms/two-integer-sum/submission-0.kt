class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = HashMap<Int,Int>(nums.size*2)
        nums.forEachIndexed{ index,num->
        val complement = target - num
        seen[complement]?.let{complementIndex ->
            return intArrayOf(complementIndex,index)
        }
        seen[num] = index
        }
        return intArrayOf(-1,-1)
    }
}
