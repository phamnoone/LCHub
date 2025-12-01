class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val results = ArrayList<ArrayList<Int>>()

        for (i in 0..(board.size - 1)) {
            for (j in 0..(board.first().size -1) ) {
                if (board[i][j] == word[0]) {
                    results.add(arrayListOf(i*board.first().size + j))
                    find(board, word, results, results.size - 1)
                }
            }
        }
        
        // results.forEach {
        //     println(it)
        // }

        return results.filter { it.size == word.length }.size > 0
    }

    fun find(
        board: Array<CharArray>, 
        word: String, 
        results: ArrayList<ArrayList<Int>>, 
        node: Int,
    ) {
        val i = results[node].last()/board.first().size
        val j = results[node].last()%board.first().size
        var removeNode = false

        if (canMove(board, word, results[node], i, j + 1)) {
            val newNode = ArrayList(results[node])
            newNode.add(i*board.first().size + j + 1)
            results.add(newNode)
            find(board, word, results, results.size - 1)
            removeNode = true
        }

        if (canMove(board, word, results[node], i, j - 1)) {
            val newNode = ArrayList(results[node])
            newNode.add(i*board.first().size + j - 1)
            results.add(newNode)
            find(board, word, results, results.size - 1)
            removeNode = true
        }

        if (canMove(board, word, results[node], i - 1, j)) {
            val newNode = ArrayList(results[node])
            newNode.add((i - 1)*board.first().size + j)
            results.add(newNode)
            find(board, word, results, results.size - 1)
            removeNode = true
        }

        if (canMove(board, word, results[node], i + 1, j)) {
            val newNode = ArrayList(results[node])
            newNode.add((i + 1)*board.first().size + j)
            results.add(newNode)
            find(board, word, results, results.size - 1)
            removeNode = true
        }

        if (removeNode)
            results.removeAt(node)
    }

    fun canMove(
        board: Array<CharArray>, 
        word: String, 
        results: ArrayList<Int>, 
        i: Int,
        j: Int,
    ): Boolean { 
        if (results.size >= word.length)
            return false

        if (i < 0 || i >= board.size)
            return false

        if (j < 0 || j >= board.first().size)
            return false
        
        if(results.indexOf(i*board.first().size + j) != -1)
            return false
         
        if (board[i][j] != word[results.size])
            return false
        
        return true
    }
}