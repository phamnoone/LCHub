class LRUCache(val capacity: Int) {
    val store = mutableMapOf<Int, Int>()
    val cacheQueue = ArrayDeque<Int>()

    fun get(key: Int): Int {
        val value = store[key]
        if (value != null) {
            cacheQueue.remove(key)
            cacheQueue.addFirst(key)
            return value
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (store.size == capacity && !store.contains(key)) {
            val lastKey = cacheQueue.last()
            cacheQueue.removeLast()
            store.remove(lastKey)
        }
        store[key] = value
        cacheQueue.remove(key)
        cacheQueue.addFirst(key)
    }

}