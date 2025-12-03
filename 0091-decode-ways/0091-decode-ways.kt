class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0
        if (s.length == 1) return 1
        
        var sum2 = 1
        var sum1 = 1
        

        for (i in 1..(s.length - 1)) {
            var temp = 0
            if (s[i] == '0') {
                if (s[i-1] == '1' || s[i-1] == '2') {
                    temp = sum2
                } else {
                    return 0
                }
            } else {
                if (s[i-1] == '1' || (s[i-1] == '2' && s[i] in '0'..'6')) {
                    temp = sum2 + sum1
                } else {
                    temp = sum1
                }
            }
            
            sum2 = sum1
            sum1 = temp
        }


        return sum1
    }
}