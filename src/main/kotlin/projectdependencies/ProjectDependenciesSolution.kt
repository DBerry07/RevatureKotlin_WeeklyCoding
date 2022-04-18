package projectdependencies

import core.ChallengeSolution

class ProjectDependenciesSolution : ChallengeSolution() {

    public override fun solve() {
        var projects = arrayOf('a', 'b', 'c', 'd', 'e', 'f')
        var dependencies : Array<Set<Char>> = arrayOf(
            setOf('a', 'd'), setOf('f', 'b'), setOf('b', 'd'), setOf('f', 'a'), setOf('d', 'c')
        )
    }

    private fun createHashMap(array : Array<Char>) : HashMap<Char, Int> {
        var hashMap = HashMap<Char, Int>()
        for (each in array) {
            hashMap[each] = 0
        }
        return hashMap
    }
}