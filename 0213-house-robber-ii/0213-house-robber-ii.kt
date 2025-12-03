class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return  max(
            robI(nums, 1, nums.size-1), 
            robI(nums, 0, nums.size - 2)
        )
    }

    fun robI(nums: IntArray, star: Int, end: Int): Int {
        var rob2 = 0
        var rob1 = 0 
        
        for (i in star..end) {
            val temp = max(nums[i] + rob2, rob1)
            rob2 = rob1
            rob1 = temp
        }

        return rob1
    }
}