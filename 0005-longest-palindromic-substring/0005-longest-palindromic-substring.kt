class Solution {
    fun longestPalindrome(s: String): String {
        for (j in s.length downTo 1) {
            for (i in 0..(s.length - j)) {
                if (isPlaindromic(s.substring(i, i+j)))
                    return s.substring(i, i+j)
            }
        }
        return s.substring(0,1)
    }

    private fun isPlaindromic(s: String): Boolean {
        for(i in 0..(s.length/2)) {
            if (s[i] != s[s.length - i - 1]) {
                return false
            }
        }
        return true
    }
}