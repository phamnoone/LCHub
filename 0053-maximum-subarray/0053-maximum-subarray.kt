class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var result = nums[0]

        for (i in 1..(nums.size -1)) {
            max = max(nums[i], max + nums[i])
            result = max(max, result)
        } 

        return result
    }
}