class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val nums = ArrayList<Int>()
        var size = matrix.size*matrix.first().size

        var left = -1
        var right = matrix.first().size
        var top = -1
        var bottom = matrix.size

        var i = 0
        var j = 0
        var state = 0

        while(nums.size < size) {
            when (state) {
                0 -> {
                    nums.add(matrix[i][j++]) 
                    if (j == right) {
                        j--
                        i++
                        top++
                        state = 1
                    }
                }

                1 -> {
                    nums.add(matrix[i++][j]) 
                    if (i == bottom) {
                        i--
                        j--
                        right--
                        state = 2
                    }
                }

                2 -> {
                    nums.add(matrix[i][j--]) 
                    if (j == left) {
                        i--
                        j++
                        bottom--
                        state = 3
                    }
                } 

                else -> {
                    nums.add(matrix[i--][j]) 
                    if (i == top) {
                        i++
                        j++
                        left++
                        state = 0
                    }
                }
            }
        }

        return nums
    }
}