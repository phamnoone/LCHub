class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val matrix = Array(m) { IntArray(n) { 0 } }

        for(i in 0..(m-1))
            for (j in 0..(n-1))
                if (i == 0 || j == 0)
                    matrix[i][j] = 1
                else
                     matrix[i][j] =  matrix[i][j-1] +  matrix[i-1][j]
                     
        return matrix[m-1][n-1]
    }
}