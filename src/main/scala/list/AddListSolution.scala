package list
import scala.collection.mutable.HashMap

object AddListSolution {

    def addList(h1: ListNode, h2: ListNode): ListNode = {
        if (h1 == null || h1.next == null) h2
        else if (h2 == null || h2.next == null) h1
        else {
            var c = 0
            var sum = 0
            var p1 = h1.next
            var p2 = h2.next
            var tmp: ListNode = null

            val resultHead = new ListNode()
            resultHead.next = null //头结点是空的
            var p = resultHead
            while (p1 != null && p2 != null) {
                tmp = new ListNode()
                tmp.next = null
                sum = p1.data + p2.data + c
                tmp.data = sum % 10
                c = sum / 10
                p.next = tmp //封装好的数据节点

                p = tmp
                p1 = p1.next
                p2 = p2.next //往后遍历，直到二者有一个为空
            }

            if (p1 == null) { //p2比较长
                while (p2 != null) {
                    tmp = new ListNode()
                    tmp.next = null
                    sum = p2.data + c
                    tmp.data = sum % 10
                    c = sum / 10
                    p.next = tmp
                    p = tmp
                    p2 = p2.next
                }
            }

            if (p2 == null) { //p1比较长
                while (p1 != null) {
                    tmp = new ListNode()
                    tmp.next = null
                    sum = p1.data + c
                    tmp.data = sum % 10
                    c = sum / 10
                    p.next = tmp
                    p = tmp
                    p1 = p1.next
                }
            }

            if (c == 1) {
                tmp = new ListNode()
                tmp.next = null
                tmp.data = c
                p.next = tmp
            }

           resultHead
        }
    }

    def main(args: Array[String]): Unit = {
        val head1 = new ListNode()
        val head2 = new ListNode()
        head1.next = null
        head2.next = null
        var tmp: ListNode = null
        var cur: ListNode = head1
        var result: ListNode = null

        (1 to 6).foreach { i =>
            tmp = new ListNode()
            tmp.data = i + 2
            tmp.next = null
            cur.next = tmp
            cur = tmp
        }

        cur = head2
        (5 to 9).reverse.foreach { i =>
            tmp = new ListNode()
            tmp.data = i
            tmp.next = null
            cur.next = tmp
            cur = tmp
        }

        println("head1: ")
        cur = head1.next
        while (cur != null) {
            print(s"${cur.data} ")
            cur = cur.next
        }

        println("\nhead2: ")
        cur = head2.next
        while (cur != null) {
            print(s"${cur.data} ")
            cur = cur.next
        }

        println("\nresult: ")
        result = addList(head1, head2)
        cur = result.next
        while (cur != null) {
            print(s"${cur.data} ")
            cur = cur.next
        }
    }

}
