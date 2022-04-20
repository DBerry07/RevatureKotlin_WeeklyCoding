package projectdependencies

import core.ChallengeSolution

object ProjectDependenciesSolution : ChallengeSolution() {

    public override fun solve() {
        var output = String()
        val projects = arrayOf('a', 'b', 'c', 'd', 'e', 'f')
        val dependencies : Array<Set<Char>> = arrayOf(
            setOf('a', 'd'), setOf('f', 'b'), setOf('b', 'd'), setOf('f', 'a'), setOf('d', 'c')
        )

        /**
         * Used for testing invalid builds
        val dependencies : Array<Set<Char>> = arrayOf(
            setOf('a', 'b'), setOf('b', 'a')
        )
        **/
        var limit = projects.size * projects.size

        var orderList = MutableList<Char>(0) {'?'}

        var array : MutableList<MutableList<Char>> = MutableList(projects.size) { MutableList(0) {'?'} }
        var removeString = String()
        for (pair in dependencies) {
            val main : Char = pair.elementAt(0)
            val second : Int = pair.elementAt(1).code - 'a'.code

            var list = array[second]
            list.add(main)
        }

        //Add projects requiring no dependencies to order list
        for (i in 0 until array.size) {
            var list = array[i]
            if (list.size == 0) {
                orderList.add((i + 'a'.code).toChar())
            }
        }

        while (orderList.size < projects.size && limit > 0) {
            for (i in 0 until array.size) {
                var match = 0
                var list = array[i]
                for (j in 0 until list.size) {
                    if (orderList.contains(list[j])) {
                        match++
                    }
                }
                if (match == list.size) {
                    val char = (i + 'a'.code).toChar()
                    if (!orderList.contains(char)) {
                        orderList.add(char)
                    }
                }
            }
            limit--
        }

        if (orderList.size == projects.size) {
            println(orderList)
        }
        else {
            println("[ No valid order ]")
        }


        /**
        var hashMap = createHashMap(projects)
        hashMap = countInstances(dependencies, hashMap)
        var order = MutableList<Char>(0) { 'a' }

        //Finds the projects that do not require any dependencies and adds them to the order list
        //projects.indices rather than "i in 0..projects.size - 1"
        for (i in projects.indices) {
            if (hashMap[i] == 0) {
                //'a'.code rather than 'a'.toInt()
                order.add((i + 'a'.code).toChar())
            }
        }

        for (i in 0..projects.size) {
            
        }
        **/
    }

    /**
    //Creates a hash map of the projects in order to count the number of instances
    private fun createHashMap(array : Array<Char>) : HashMap<Int, Int> {
        val hashMap = HashMap<Int, Int>()
        for (each in array) {
            hashMap[each.code] = 0
        }
        return hashMap
    }

    //Counts the number of times a project requires a dependency
    private fun countInstances(dependencies: Array<Set<Char>>, hashMap: HashMap<Int, Int>): HashMap<Int, Int> {
        var numOfTimesBeingDepending = hashMap
        for (set in dependencies) {
            val element: Int = set.elementAt(1).code - 'a'.code
            numOfTimesBeingDepending[element] = numOfTimesBeingDepending[element]!! + 1
        }
        return numOfTimesBeingDepending
    }

    private fun findDependents(main : Char, dependencies: Array<Set<Char>>): MutableList<Char> {
        var list = MutableList<Char>(0)
        for (set in dependencies) {
            val dependingVal = set.elementAt(1)
            val dependVal = set.elementAt(0)

            if (dependVal == main) {
                list.add(dependingVal)
            }
        }
        return list
    }
    **/
}