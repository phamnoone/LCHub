class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) 
            return nums.indexOf(target)
        var left = 0
        var right = nums.size - 1
        var middle = nums.size / 2

        while(left != middle) {
            if (target == nums[left]) return left
            if (target == nums[right]) return right
            if (target == nums[middle]) return middle
            

            if (nums[left] < nums[middle]) {
                if (target > nums[left] && target < nums[middle]) {
                    right = middle
                    middle = left + (right - left)/2
                } else {
                    left = middle
                    middle = middle + (right - middle)/2
                }
            } else {
                 if (target > nums[middle] && target < nums[right]) {
                    left = middle
                    middle = middle + (right - middle)/2
                } else {
                    right = middle
                    middle = left + (middle - left)/2 
                }   
            }
        }
     
        return -1
    }
}