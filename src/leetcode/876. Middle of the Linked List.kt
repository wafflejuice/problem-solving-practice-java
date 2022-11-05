package leetcode

import leetcode.DataStructure.ListNode

fun middleNode(head: ListNode?): ListNode? {
    var curr = head
    var currIdx = 0
    var middle = curr

    while (curr != null) {
        if (currIdx % 2 == 1) {
            middle = middle?.next
        }
        curr = curr.next
        currIdx++
    }

    return middle
}

fun main() {
    assert(middleNode(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))) == ListNode(3, ListNode(4, ListNode(5))))
    assert(middleNode(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))) == ListNode(4, ListNode(5, ListNode(6))))
}
