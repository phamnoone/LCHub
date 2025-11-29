class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var i = 0
        var j = height.size - 1

        while(j>i) {
            max = max(min(height[i], height[j]) * (j - i ),max)
            if (height[i] < height[j])
                i++
            else
                j--
        }

        return max
    }
}