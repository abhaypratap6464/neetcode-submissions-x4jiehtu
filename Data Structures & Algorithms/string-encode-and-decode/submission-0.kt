class Solution {

    fun encode(strs: List<String>): String {
        if (strs.isEmpty()) return ""
        return buildString {
            strs.forEach { str ->
                append(str.length)
                append('#')
                append(str)
            }
        }
    }

    fun decode(str: String): List<String> {
        if (str.isEmpty()) return arrayListOf()
        val result = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            var j = i
            while (str[j] != '#') j++   
            val length = str.substring(i, j).toInt()
            val requiredString = str.substring(j + 1, j + 1 + length)
            result.add(requiredString)
            i = j + 1 + length           
        }
        return result
    }
}