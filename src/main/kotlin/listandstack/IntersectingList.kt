package listandstack

import core.ChallengeSolution
import java.util.*

object IntersectingList : ChallengeSolution() {

    override fun solve() {
        val list1 : LinkedList<Int> = LinkedList(arrayListOf(3, 7, 8, 10))
        val list2 : LinkedList<Int> = LinkedList(arrayListOf(99, 1, 8, 10))
        val node : Int = findIntersecting(list1, list2)
        var str = String()
        if (node == 0) {
            str = "No intersecting node"
        }
        else {
            str = "$node"
        }
        println("INTERSECTING LIST")
        println("Intersecting node: $str")
    }

    private fun findIntersecting(list1 : LinkedList<Int>, list2 : LinkedList<Int>) : Int {

        val length1 : Int = list1.size
        val length2 : Int = list2.size
        var diff : Int = 0

        var iter1 : Iterator<Int> = list1.iterator()
        var iter2 : Iterator<Int> = list2.iterator()

        if (length1 > length2) {
            diff = length1 - length2
            while (diff > 0) {
                iter1.hasNext()
                diff--
            }
        }
        else if (length1 < length2) {
            diff = length2 - length1
            while (diff > 0) {
                iter2.hasNext()
                diff--
            }
        }
        else {
            diff = 0
        }

        return compareIters(iter1, iter2)
    }

    private fun compareIters(iter1 : Iterator<Int>, iter2 : Iterator<Int>) : Int {
        while (iter1.hasNext()) {
            var val1 = iter1.next()
            var val2 = iter2.next()
            if (val1 == val2) {
                return val1
            }
        }
        return 0
    }
}