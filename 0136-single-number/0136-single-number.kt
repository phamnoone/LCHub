class Solution {
    fun singleNumber(nums: IntArray): Int {
        val maps = mutableMapOf<Int,Int>()
        
        for (num in nums) {
            maps[num] = maps.getOrDefault(num, 0) + 1
        }

        return maps.filterValues { it == 1 }.keys.first()
    }
}