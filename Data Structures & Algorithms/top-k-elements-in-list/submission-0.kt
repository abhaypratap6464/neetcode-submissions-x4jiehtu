class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = HashMap<Int,Int>()
        nums.forEach{ num ->
        freqMap[num] = freqMap.getOrDefault(num,0) +1
        }
        val minHeap = PriorityQueue<Map.Entry<Int,Int>>(
            compareBy {it.value}
        )

        freqMap.entries.forEach{entry ->
        minHeap.offer(entry)
        if(minHeap.size>k) {
            minHeap.poll()
        }

        }
        return minHeap.map { it.key }.toIntArray()
    }
}
