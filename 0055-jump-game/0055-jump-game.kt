class Solution {
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.size - 1
        for (i in nums.size - 1 downTo 0) {
            if (i + nums[i] >= goal) {
                goal = i
            }
        }
        return goal == 0
    }

    //greedy algorithm
    fun canJumpGreedy(nums: IntArray): Boolean {
        var i = 0
        var jump = nums[i]
        
        while(i < nums.size - 1) {
            var max = 0
            var maxIndex = i
            for (j in (i+1)..(i+jump)) {
                if (j == nums.size - 1) return true
                if (nums[j] >= max) {
                    var testJump = false
                    for (z in (j+1)..(j+nums[j])) {
                        if (z == nums.size - 1) return true
                        if (nums[z] != 0) {
                            testJump = true
                            break
                        }
                    }
                    if (testJump) {
                        max = nums[j]
                        maxIndex = j
                    }
                }
            }
            jump = max
            i = maxIndex
            if (max == 0) return false
        }

        return true
    }
}