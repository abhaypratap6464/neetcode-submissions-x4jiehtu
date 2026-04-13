/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty()){
            return null
        }

        val minHeap = PriorityQueue<ListNode>(
            compareBy { it.`val` }
        )

        lists.forEach { head ->
            head?.let{ minHeap.offer(it) }
        }

        val dummy = ListNode(0)
        var curr = dummy

        while(minHeap.isNotEmpty()){
            val smallest = minHeap.poll()
            curr.next = smallest
            curr = curr.next!!

            smallest.next?.let{ minHeap.offer(it) }
        }
        return dummy.next        
    }
}
