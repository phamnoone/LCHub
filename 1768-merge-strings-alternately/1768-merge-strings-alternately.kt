class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val chars = ArrayList<Char>()

        for (i in 0..(max(word1.length, word2.length) - 1)) {
            if (i < word1.length)
                chars.add(word1[i])
            if (i < word2.length)
                chars.add(word2[i])
        }

        return chars.joinToString("")
    }
}