class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0
         for(i in s.indices){
            var l1 = i
            var r1 = i

            while(l1>=0 && r1 < s.length && s[l1] == s[r1]){
                count++
                l1--
                r1++
            }

            var l2 = i
            var r2 = i+1

            while(l2>=0 && r2 < s.length && s[l2] == s[r2]){
                count ++
                l2 --
                r2++
            }
         }
         return count 
    }
}
