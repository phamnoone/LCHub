class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val moneys = IntArray(nums.size)
        moneys[0] = nums[0]
        moneys[1] = max(nums[0], nums[1])

        for (i in 2..(nums.size -1)) {
            moneys[i] = max(moneys[i-2] + nums[i], moneys[i-1])
        }

        return moneys.max()
    }
}