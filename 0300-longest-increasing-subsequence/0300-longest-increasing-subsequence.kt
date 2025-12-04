class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.size == 1) return 1
        val results = IntArray(nums.size) { 1 }

        for (i in nums.size - 1 downTo 0) {
            for (j in (i+1)..(nums.size-1)) {
                if (nums[i] < nums[j]) {
                    results[i] = max(results[i], 1+ results[j])
                }
            }
        }

        return results.max()
    }
}