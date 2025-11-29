class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size == 0) return 0
        val sorted =  nums.sorted()
        var result = 0
        var count = 0
        var cursor = sorted.first()
        for (i in 1..sorted.size-1) {
            if (cursor + 1 == sorted[i]) {
                count++
            } else if (cursor == sorted[i]) {
                continue
            } else {
                if (++count > result) 
                    result = count
                count = 0
            }
             cursor = sorted[i]
        }

        if (++count > result) 
            result = count

        return result
    }
}