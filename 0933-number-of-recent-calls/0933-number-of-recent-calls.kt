class RecentCounter() {
    companion object {
        val PAST_TIME = 3000
    }
    
    val requests = ArrayList<Int>()
 
    fun ping(t: Int): Int {
        
        while(requests.size > 0 && t - PAST_TIME > requests[0]) {
            requests.removeAt(0)
        }
        requests.add(t)

        return requests.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */