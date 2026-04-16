class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        if (text1 == text2) return text1.length
        val m = text1.length
        val n = text2.length
    
        var prev = IntArray(n + 1)
        var curr = IntArray(n + 1)

        for (i in 1..m) {
            for (j in 1..n) {
                curr[j] = if (text1[i - 1] == text2[j - 1]) {
                    prev[j - 1] + 1
                } else {
                    maxOf(prev[j], curr[j - 1])
                }
            }
            val temp = prev
            prev = curr
            curr = temp
        }
        return prev[n]
    }
}