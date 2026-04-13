class Solution {
    fun isValid(s: String): Boolean {
      val stack = ArrayDeque<Char>()  
     val matchMap = mapOf(
        ')' to '(' ,
         ']' to '[',
         '}' to '{'
     )

     for (char in s){
        when(char){
            '(','[','{' -> stack.addLast(char)
            ')',']','}' -> {
                if(stack.isEmpty() || stack.last()!= matchMap[char]){
                    return false
                }
                stack.removeLast()
            }
        }
     }
         return stack.isEmpty()
    }
   
}
