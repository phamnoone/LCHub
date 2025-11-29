class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val triplets = ArrayList<List<Int>>()
        
        nums.sort()

        for(i in 0 until nums.size-2) {
            if (nums[i]>0) break

            if (i > 0 && nums[i] == nums[i - 1])
                continue

            var s = i+1
            var e = nums.size - 1

            while(s<e) {
                when {
                    nums[i] + nums[s] + nums[e] == 0 -> {
                        triplets.add(arrayListOf(nums[i],nums[s],nums[e]))
                        s++
                        e--
                        while (s < e && nums[s] == nums[s - 1]) 
                            s++

                        while (s < e && nums[e] == nums[e + 1]) 
                            e--
                    }

                    nums[i] + nums[s] + nums[e] > 0 -> e--

                    else -> s++
                }
            }
            
        }         

        return triplets
    }
}