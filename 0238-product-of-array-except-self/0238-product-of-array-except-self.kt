class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val lefts = IntArray(nums.size) { 1 }
        val rights = IntArray(nums.size) { 1 }
        val results = IntArray(nums.size) { 1 }

        for (i in 0..(nums.size-2))
            lefts[i+1] = lefts[i] * nums[i]

        for (i in nums.size-1 downTo 1)
             rights[i-1] = rights[i] * nums[i]

        for (i in 0..(nums.size-1))
            results[i] = lefts[i] * rights[i]

        return results
    }
}