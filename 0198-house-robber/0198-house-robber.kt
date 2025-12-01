class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return max(nums[0], nums[1])

        val moneys = IntArray(nums.size)
        moneys[0] = nums[0]
        moneys[1] = max(nums[0], nums[1])
        moneys[2] = nums[0] + nums[2]

        for (i in 3..(nums.size -1)) {
            moneys[i] = max(moneys[i-2], moneys[i-3]) + nums[i]
        }

        return max(moneys[nums.size -1], moneys[nums.size -2])
    }
}