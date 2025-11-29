class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = if(s.isEmpty()) 0 else 1
        for (i in 0 until s.length) {
            for (j in i+1 until s.length+1) {
                if (j-i < max)
                    continue
                val sub = s.substring(i,j)
                if (sub.length == sub.chars().distinct().count().toInt()) {
                    max = max(max, sub.length)
                    print("$j $max ")
                    if (j >= 96 && max >= 95)
                        return max
                }
                    
            }
        }

        return max
    }
}