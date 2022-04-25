package robot

object RobotPathfindingSolution: core.ChallengeSolution() {

    val BLOCKER = 7
    val SIZE = 10
    val grid : Array<IntArray> = Array(RobotSolution.SIZE) {IntArray(RobotSolution.SIZE) {0} }
    val start : Pair<Int, Int> = Pair(0, 0)
    val end : Pair<Int, Int> = Pair(SIZE - 1, SIZE - 1)
    var moves : MutableList<Pair<Int, Int>> = MutableList(0) {Pair(0, 0)}

    override fun solve() {
        initializeGrid()
        pathfind(start)

        printGrid()
        if (moves.size == 0) {
            println("No valid pathway for the robot!")
        }

        println(moves.asReversed())
    }

    fun pathfind(current: Pair<Int, Int>?): Boolean {

        if (current == end) {
            moves.add(current)
            return true
        }
        if (current == null) {
            return false
        }
        if (grid[current.first][current.second] == BLOCKER) {
            return false
        }

        var valid : Boolean = false

        valid = pathfind(moveRight(current))

        if (!valid) {
            valid = pathfind(moveDown(current))
        }

        if (valid) {
            moves.add(current)
            return true
        }
        else {
            return false
        }
    }

    fun initializeGrid() {

        /**
        for (i in 0..SIZE - 1) {
            for (j in 0..SIZE - 1) {
                grid[i][j] = (0..BLOCKER).random()
            }
        }
        **/

        grid[0][1] = BLOCKER
        grid[1][5] = BLOCKER
        grid[2][0] = BLOCKER
        grid[2][1] = BLOCKER
        grid[2][2] = BLOCKER
        grid[2][4] = BLOCKER
        grid[4][3] = BLOCKER
        grid[4][5] = BLOCKER
        grid[3][5] = BLOCKER
        grid[5][5] = BLOCKER
        grid[6][6] = BLOCKER
        grid[8][9] = BLOCKER
        grid[9][7] = BLOCKER

    }

    fun printGrid() {
        for (i in 0..SIZE - 1) {
            for (j in 0..SIZE - 1) {
                if (moves.contains(Pair(i, j))) {
                    print("[>]")
                }
                else if (grid[i][j] < BLOCKER) {
                    print("[.]")
                }
                else {
                    print("[#]")
                }
            }
            println()
        }
    }

    /**
    fun printGrid() {

        var printable : Array<Array<String>> = Array(SIZE) { Array<String>(SIZE) {""} }
        for (each in moves) {
            printable[each.first][each.second] = "[#]"
        }

        for (i in 0..SIZE - 1) {
            for (j in 0..SIZE - 1) {
                if (printable[i][j] == "") {
                    if (grid[i][j] < BLOCKER) {
                        printable[i][j] = "[.]"
                    }
                    else {
                        printable[i][j] = "[=]"
                    }
                }
            }
        }

        for (i in 0..SIZE - 1) {
            println()
            for (j in 0..SIZE - 1) {
                print(printable[i][j])
            }
        }

    }
    **/

    fun moveRight(pos: Pair<Int, Int>?): Pair<Int, Int>? {
        val value = pos!!.second  + 1
        if (value >= SIZE) {
            return null
        }
        if (grid[pos.first][value] == 3) {
            return null
        }
        return Pair(pos.first, value)

    }

    fun moveDown(pos: Pair<Int, Int>?): Pair<Int, Int>? {
        val value = pos!!.first + 1
        if (value >= SIZE) {
            return null
        }
        if (grid[value][pos.second] == 3) {
            return null
        }
        return Pair(value, pos.second)
    }

}