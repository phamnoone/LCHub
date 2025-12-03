class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (nums.size == 1) return nums

        val hashMap = HashMap<Int, Int>()

        for(i in 0..(nums.size -1)) {
            if (hashMap[nums[i]] == null)
                hashMap[nums[i]] = 1
            else
                hashMap[nums[i]] = hashMap[nums[i]]!!  +1
        }

        return hashMap.entries.sortedByDescending { 
            it.value 
        }.slice(0..k-1).map { it.key }.toIntArray()
    }
}