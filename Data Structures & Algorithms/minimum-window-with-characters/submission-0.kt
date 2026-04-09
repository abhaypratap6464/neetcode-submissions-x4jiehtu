class Solution {
    fun minWindow(s: String, t: String): String {
        if(s.isEmpty() || t.isEmpty()) return ""

        val need = HashMap<Char, Int>()
         t.forEach { need[it] = need.getOrDefault(it,0) +1 }

        val window = HashMap<Char,Int>()

        var left = 0
        var formed = 0
       val required = need.size

        var minLen = Int.MAX_VALUE
        var minLeft = 0
        var minRight = 0

        for(right in s.indices){
            val c = s[right]
            window[c] = window.getOrDefault(c,0) +1 

            if(need.containsKey(c) && window[c] == need[c]){
                formed++
            }

            while(formed==required && left <= right){
                val winndowLen = right - left +1 
                if(winndowLen < minLen){
                    minLen = winndowLen
                    minLeft = left
                    minRight = right
                }
                val leftChar = s[left]
                window[leftChar] = window.getOrDefault(leftChar,0) -1

                if(need.containsKey(leftChar) && window[leftChar]!! < need[leftChar]!!){
                    formed--
                }
                left++
            }
        }
         
         return if(minLen == Int.MAX_VALUE) {
            ""
         }else{
            s.substring(minLeft,minRight+1)
         }
    }
}