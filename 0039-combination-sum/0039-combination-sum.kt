class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val combinations = ArrayList<ArrayList<Int>>()
        val adds = ArrayList<ArrayList<Int>>()
        val removes = ArrayList<ArrayList<Int>>()
        val results = ArrayList<ArrayList<Int>>()
        
        for (n in candidates) {
            if (n <= target) {
                combinations.add(arrayListOf(n))
            }
        }
        
        while(combinations.size != 0) {
            for (remove in removes)
                combinations.remove(remove)

            for (add in adds)
                combinations.add(add)

            removes.clear()
            adds.clear()

            for (combination in combinations) {
                var sum = 0
                for (number in combination)
                    sum += number

                if (sum > target)
                    removes.add(combination)

                if (sum == target) {
                    results.add(combination)
                    removes.add(combination)
                }

                if (sum < target) {
                    var isAdded = false
                    for (number in candidates) {
                        if (number <= target - sum) {
                            if (isAdded) {
                                val newCombination = ArrayList(combination)
                                newCombination.removeLast()
                                newCombination.add(number)
                                adds.add(newCombination)
                            } else {
                                combination.add(number)
                                isAdded = true  
                            }
                        }
                    }
                    if (!isAdded)
                        removes.add(combination)
                }
            }
        }
        

        val keys =  ArrayList<String>()
        for (result in results) {
            result.sort()
            val key = result.joinToString()
            if (keys.contains(key)) {
                removes.add(result)
            } else {
                keys.add(key)
            }
        }

        for (remove in removes) {
            results.remove(remove)
        }

        return results
    }
}