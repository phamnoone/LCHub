class Solution {
    fun maxProduct(nums: IntArray): Int {
        if(nums.size == 1) 
            return nums[0]

        val results = DoubleArray(nums.size) {
            1.0
        }
        var max = 0.0

        for(i in  0..(nums.size-1)) {
            for(j in  0..(nums.size - 1 - i)) {
                results[j] = results[j]*nums[j+i].toDouble()
                max = max(results[j], max)
            }
        }

        return max.toInt()
    }

}