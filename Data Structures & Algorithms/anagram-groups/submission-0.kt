class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagramMap = HashMap<String,MutableList<String>>()

        strs.forEach{ word ->
        val sortedKeys = word.toCharArray()
                            .sorted()
                            .joinToString("")

          anagramMap.getOrPut(sortedKeys) { mutableListOf() }.add(word)
                            
        }
        return anagramMap.values.toList()
    }
}
