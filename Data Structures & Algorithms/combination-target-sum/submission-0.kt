class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()

        fun backtrack(
            current:MutableList<Int>,
            remaning:Int,
            start:Int
        ){
            if(remaning == 0){
                result.add(current.toList())
                return
            }

            for(i in start until candidates.size){
                if(candidates[i]> remaning) break
                current.add(candidates[i])
                backtrack(current,remaning - candidates[i],i)
                current.removeAt(current.size-1)
            }
        }
        backtrack(mutableListOf(),target,0)
        return result
    }
}
