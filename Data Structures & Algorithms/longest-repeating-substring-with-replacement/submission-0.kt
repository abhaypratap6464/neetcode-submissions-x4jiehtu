class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if(s.isEmpty()) return 0

        val freq = IntArray(26)
        var left = 0
        var maxFreq = 0
        var maxLength = 0

        for(right in s.indices){
            val rightChar = s[right] - 'A'
            freq[rightChar]++

            maxFreq = maxOf(maxFreq,freq[rightChar])

            val windowSize = (right - left) +1
            if((windowSize-maxFreq)>k){
                freq[s[left] - 'A']--
                left++
            }
             maxLength = maxOf(maxLength,(right - left) +1)
        }
        return maxLength
    }
}
