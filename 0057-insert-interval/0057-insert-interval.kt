class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.size == 0) return arrayOf(newInterval)

        val results = ArrayList<IntArray>()
        var start = -1
        var end = -1
        var inserted = false

        for (i in 0..(intervals.size - 1)) {
            if (inserted)  {
                results.add(intervals[i])
                continue
            }
                
            val s = intervals[i][0]
            val e = intervals[i][1]
            val nS = newInterval[0]
            val nE = newInterval[1]

            if (start != -1) {
                if (end < s) {
                    results.add(intArrayOf(start, end))
                    results.add(intervals[i])
                    inserted = true
                    continue
                }

                if (s <= end && end <= e) {
                    results.add(intArrayOf(start, e))
                    inserted = true
                    continue
                }

                if (i == intervals.size -1) {
                    results.add(intArrayOf(start, end))
                }

                continue
            }
            
            if (nS > e) {
                results.add(intervals[i])
                continue
            }

            if (s <= nS && nE <= e) {
                results.add(intervals[i])
                inserted = true
                continue
            }

            if (nS <= s) {
                if (nE < s) {
                    results.add(intArrayOf(nS,nE))
                    results.add(intervals[i])
                    inserted = true
                    continue
                }
                
                if (nE <= e) {
                    results.add(intArrayOf(nS,e))
                    inserted = true
                    continue
                } 

                end = nE
                start = nS

                if (i == intervals.size -1) {
                    results.add(intArrayOf(start, end))
                }
            } else {
                start = s
                end = nE

                if (i == intervals.size -1) {
                    results.add(intArrayOf(start, end))
                }
            }
        }

        if (!inserted && start == -1)
            results.add(newInterval)
            
        return results.toTypedArray()
    }
}