class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val results = ArrayList<ArrayList<String>>()
        val keys = ArrayList<String>()
        for (str in strs) {
            val key = str.toCharArray().sorted().joinToString("")
            if (keys.indexOf(key) == -1) {
                keys.add(key)
                results.add(arrayListOf(str))
            } else {
                results[keys.indexOf(key)].add(str)
            }     
        }
        
        return results
    }
}