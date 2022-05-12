package listandloop

import core.ChallengeSolution

object ListAndLoopSolution: ChallengeSolution() {

    var listOneRoot: MyNode? = null
    var listTwoRoot: MyNode? = null
    var listOneAddresses: MutableList<Int>? = null
    var listTwoAddresses: MutableList<Int>? = null

    var listLoopRoot: MyNode? = null
    var listLoop: MutableList<Int>? = null

    override fun solve() {
        val llAnswer = findIntersection()
        val loopAnswer = findLoopStart()

        println("LIST AND LOOP")
        println("Linked List Intersection:")
        println("List1: $listOneAddresses")
        println("List2: $listTwoAddresses")
        if (llAnswer != null) {
            println("Intersecting Node: MyNode with hashcode of ${System.identityHashCode(llAnswer)}")
        }
        else {
            println("No intersection found!")
        }
        println()
        println("Find Loop Start:")
        println("List: $listLoop")
        if (loopAnswer != null) {
            println("Loop start: MyNode with hashcode of $loopAnswer")
        }
        else {
            println("No loop found!")
        }
    }

    fun findIntersection(): MyNode? {
        initializeLinkedLists()
        initializeLoop()

        var nodeOne = listOneRoot
        var nodeTwo = listTwoRoot

        listOneAddresses = MutableList<Int>(0) {0}
        listTwoAddresses = MutableList<Int>(0) {0}

        while (nodeOne != null) {
            listOneAddresses!!.add(System.identityHashCode(nodeOne))
            nodeOne = nodeOne.next
        }

        while (nodeTwo != null) {
            listTwoAddresses!!.add(System.identityHashCode(nodeTwo))
            nodeTwo = nodeTwo.next
        }

        for (aVal in listOneAddresses!!) {
            for (bVal in listTwoAddresses!!) {
                if (aVal == bVal) {
                    var node = listOneRoot
                    while (System.identityHashCode(node) != aVal) {
                        node = node!!.next
                    }
                    return node
                }
            }
        }
        return null
    }

    fun findLoopStart(): Int? {

        listLoop = MutableList<Int>(0) {0}
        var node = listLoopRoot

        while (node != null) {
            val hashcode = System.identityHashCode(node)
            for (i in 0 until listLoop!!.size - 1) {
                if (listLoop!![i] == hashcode) {
                    return hashcode
                }
            }
            listLoop!!.add(hashcode)
            node = node.next
        }

        return null
    }

    fun initializeLinkedLists() {
        val arrayOne = arrayOf(MyNode(1), MyNode(2), MyNode(3), MyNode(4), MyNode(5))
        val arrayTwo = arrayOf(MyNode(1), MyNode(7), arrayOne[1])

        for (i in 0 until arrayOne.size - 1) {
            arrayOne[i].next = arrayOne[i + 1]
        }
        for (i in 0 until arrayTwo.size - 1) {
            arrayTwo[i].next = arrayTwo[i + 1]
        }

        listOneRoot = arrayOne[0]
        listTwoRoot = arrayTwo[0]

        initializeLoop()
    }

    fun initializeLoop() {
        val arrayLoop = arrayOf(MyNode(1), MyNode(2), MyNode(3), MyNode(4), MyNode(5))

        for (i in 0 until arrayLoop.size - 1) {
            arrayLoop[i].next = arrayLoop[i + 1]
        }

        val halfway = arrayLoop.size / 2
        arrayLoop[arrayLoop.size - 1].next = arrayLoop[halfway]

        listLoopRoot = arrayLoop[0]
    }

}

class MyNode(v: Int) {
    var value = v
    var next: MyNode? = null
}