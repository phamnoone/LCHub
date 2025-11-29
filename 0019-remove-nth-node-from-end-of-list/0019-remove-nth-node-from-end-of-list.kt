/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null

        var i = 0
        var size = 1
        var end = head
        var slow = head
        while(end?.next != null) {
            end = end?.next
            size++
            if (i < n)
                i++
            else {
                slow = slow?.next 
            }
               
        }
        
        if (n == size) {
            return head?.next
        } 
        
        slow?.next = slow?.next?.next
        return head
        
    }
}