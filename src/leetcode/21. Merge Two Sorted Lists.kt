package leetcode

class ListNode(var `val`: Int, var next: ListNode? = null)

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val head = ListNode(-1)
    var curr = head
    var (p1, p2) = list1 to list2
    while (true) {
        if (p1 == null) {
            curr.next = p2
            break
        }

        if (p2 == null) {
            curr.next = p1
            break
        }

        if (p1.`val` <= p2.`val`) {
            curr.next = p1
            p1 = p1.next
        } else {
            curr.next = p2
            p2 = p2.next
        }

        curr = curr.next!!
    }

    return head.next
}

fun main() {
    var result1 = mergeTwoLists(ListNode(1, ListNode(2, ListNode(4))), ListNode(1, ListNode(3, ListNode(4))))
    while (result1 != null) {
        print("${result1.`val`} ")
        result1 = result1.next
    }
    println()

    var result2 = mergeTwoLists(null, null)
    while (result2 != null) {
        print("${result2.`val`} ")
        result2 = result2.next
    }
    println()

    var result3 = mergeTwoLists(null, ListNode(0))
    while (result3 != null) {
        print("${result3.`val`} ")
        result3 = result3.next
    }
    println()
}
