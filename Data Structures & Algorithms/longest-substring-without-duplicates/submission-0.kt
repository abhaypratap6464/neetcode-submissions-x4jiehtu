class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
       if(s.isEmpty()) return 0

       val charIndex = HashMap<Char,Int>()
       var maxLength = 0
       var left = 0 

       s.forEachIndexed{ right,char ->
        charIndex[char]?.let{ lastIndex->
            if(lastIndex>=left){
                left = lastIndex +1
            }
        }
        charIndex[char] = right
        maxLength = maxOf(maxLength,(right-left) +1)
       }
       return maxLength 
    }
}
