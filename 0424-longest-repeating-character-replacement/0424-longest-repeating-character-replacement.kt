class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var result = 0
        val map = HashMap<Char,Int>()

        var i = 0
        var j = 0
        var diff = 0

        while (i <= s.length -1) {
            while(true) {
                map[s[j]] = (map[s[j]] ?: 0) + 1

                if (map.size != 1) {
                    var max = 0
                    var sum = 0
                    for(num in map.values) {
                        max = max(num, max)
                        sum += num
                    }

                    diff = sum - max

                    if (diff > k) {
                        result = max(j - i, result)
                        j++
                        break
                    }
                }

                if (j == s.length - 1) 
                    return max(result, s.length - i)

                j++
            }

            map[s[i]] = (map[s[i]] ?: 0) - 1
            
            if (result >= s.length - i - 1) 
                break
            i++
        }

        return result
    }
}