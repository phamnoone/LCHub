class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size - 1

        for (i in 0..n/2) {
            for (j in 0..n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[n-i][j]
                matrix[n-i][j] = temp
            }
        }

        for (i in 0..n) {
            println(i)
            for (j in (i+1)..n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }
}