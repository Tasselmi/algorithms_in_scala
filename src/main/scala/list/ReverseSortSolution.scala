package list

object ReverseSortSolution {

    def reverseSort(head: ListNode): Unit = {
        if (head == null || head.next == null) return

        var current: ListNode = null
        var next: ListNode = null
        current = head.next.next
        head.next.next = null

        while (current != null) {
            next = current.next

        }
    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode()
        head.next = null
        var tmp: ListNode = null
        var cur = head

        (1 to 7) foreach { i =>
            tmp = new ListNode()
            tmp.data = i
            tmp.next = null

            cur.next = tmp
            cur = tmp
        }

        cur = head.next
        while (cur != null) {
            println(s"data: ${cur.data}")
            cur = cur.next
        }
    }

}
