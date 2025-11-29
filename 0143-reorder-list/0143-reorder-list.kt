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
    fun reorderList(head: ListNode?): Unit {
        var size = head?.size() ?: 0
        var middle = head?.get(size/2)
        var before = middle?.next?.reverse()

        middle?.next = null

        var pointerHead = head 
        var pointerBefore = before
        var tempHead:ListNode? = null
        var tempBefore:ListNode? = null

        while(true) {
            if (pointerBefore == null) break

            tempHead = pointerHead?.next
            tempBefore = pointerBefore?.next
            pointerHead?.next = pointerBefore
            pointerBefore?.next = tempHead

            pointerHead = tempHead
            pointerBefore = tempBefore
        }
    }

    fun ListNode.size(): Int {
        var size = if(this == null) 0 else 1
        var c: ListNode? = this 

        while(true) {
            if (c?.next == null) break
            size++
            c = c?.next
        }

        return size
    }

    fun ListNode.get(index: Int): ListNode? {
        var size = if(this == null) 0 else 1
        var c: ListNode? = this 

        while(true) {
            if (c == null) return null
            if ((size -1) == index) return c
            size++
            c = c?.next
        }

        return c
    }

    fun ListNode.reverse(): ListNode? {
        var c: ListNode? = this 
        var c1: ListNode? = null 
        var c2: ListNode? = null
        while(true) {
            if (c?.next == null) {
                c?.next = c2
                return c
            }

            c1 = c?.next
            c?.next = c2
            c2 = c
            c = c1
        }
    }
}