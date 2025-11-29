class Solution {
    fun countSubstrings(s: String): Int {
        var result = s.length
        for (j in s.length downTo 2) {
            for (i in 0..(s.length - j)) {
                if (s.substring(i, i+j).isPalindromic())
                    result++
            }
        }

        return result
    }
}

fun String.isPalindromic(): Boolean {
    for (i in 0..this.length-1) {
        if (this[i] != this[this.length - i - 1])
            return false
    }
    return true
}