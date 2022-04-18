package projectdependencies

import core.ChallengeSolution

object ProjectDependenciesSolution : ChallengeSolution() {

    public override fun solve() {
        var output = String()
        val projects = arrayOf('a', 'b', 'c', 'd', 'e', 'f')
        val dependencies : Array<Set<Char>> = arrayOf(
            setOf('a', 'd'), setOf('f', 'b'), setOf('b', 'd'), setOf('f', 'a'), setOf('d', 'c')
        )

        var hashMap = createHashMap(projects)
        hashMap = countInstances(dependencies, hashMap)

        //projects.indices rather than "i in 0..projects.size - 1"
        for (i in projects.indices) {
            if (hashMap[i] == 0) {
                //'a'.code rather than 'a'.toInt()
                output = output + (i + 'a'.code).toChar() +", "
            }
        }
    }

    private fun createHashMap(array : Array<Char>) : HashMap<Int, Int> {
        val hashMap = HashMap<Int, Int>()
        for (each in array) {
            hashMap[each.toInt()] = 0
        }
        return hashMap
    }

    private fun countInstances(dependencies: Array<Set<Char>>, hashMap: HashMap<Int, Int>): HashMap<Int, Int> {
        for (set in dependencies) {
            val element: Int = set.elementAt(1).code - 'a'.code
            hashMap[element] = hashMap[element]!! + 1
        }
        return hashMap
    }

    private fun findDependents(main : Char, dependencies: Array<Set<Char>>, string: String) {
        for (set in dependencies) {
            var newString = string
            val pend = set.elementAt(1)
            val dant = set.elementAt(0)

            if (dant.equals(main)) {
                newString = "$newString$dant, "
            }
        }
        
    }
}