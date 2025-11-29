class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it.first() }
        
        var start = intervals.first().first()
        var end = intervals.first().last()

        val results = ArrayList<IntArray>()

        for (i in 1..(intervals.size - 1)) {
            if (end < intervals[i].first()) {
                results.add(intArrayOf(start, end))
                start = intervals[i].first()
            }
            
            if (end < intervals[i].last()) {
                end = intervals[i].last()
            }  
        }

        results.add(intArrayOf(start, end))

        return results.toTypedArray()
    }
}