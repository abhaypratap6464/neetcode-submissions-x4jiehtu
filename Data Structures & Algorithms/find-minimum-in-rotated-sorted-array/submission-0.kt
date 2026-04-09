class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0 
        var right = nums.size-1

        if(nums[left]<=nums[right]) return nums[left]

        while(left<=right){
            val mid = left + (right-left)/2

            if(mid<nums.size-1 && nums[mid]>nums[mid+1]){
                return nums[mid+1]
            }

            if(mid>0 && nums[mid-1]>nums[mid]){
                return nums[mid]
            }

            if(nums[left]<= nums[mid]){
                left = mid+1
            }else{
                right = mid -1
            }
        }
        return nums[left]
    }
}
