package robot

object RobotPathfindingSolution: core.ChallengeSolution() {

    val BLOCKER = 4
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

    /**
     * Recursive function that checks for a valid path from the top left corner of the grid (0, 0)
     * to the bottom right corner (SIZE, SIZE).
    **/
    fun pathfind(current: Pair<Int, Int>?): Boolean {

        /**
        * If the current space is the end space (SIZE, SIZE), return true to indicate the
        * valid path has been found
        **/
        if (current == end) {
            moves.add(current)
            return true
        }

        /**
         * If the current space is null - which can occur if the path has moved outside the
         * grid - return 'false' indicating an invalid path to the goal.
        **/
        if (current == null) {
            return false
        }

        /**
         * If the current space is a blocker space (that is, a space that the pathway is not
         * allowed to go through) return 'false'
        **/
        if (grid[current.first][current.second] == BLOCKER) {
            return false
        }

        var valid : Boolean = false

        /**
         * Call 'pathway' method to move the marker right until it gets a result -
         * either a 'false' from an invalid pathway or a 'true' from the valid pathway.
         */
        valid = pathfind(moveRight(current))

        /**
         * If by moving right, the resultant pathway is in valid, try moving down instead.
         */
        if (!valid) {
            valid = pathfind(moveDown(current))
        }

        /**
         * If a valid pathway has been found - either by moving right or down, add the current
         * space to the list of spaces in the valid pathway and return true to indicate to
         * the calling 'pathway' method that this pathway is the valid pathway.
         */
        if (valid) {
            moves.add(current)
            return true
        }

        /**
         * If moving both right and down is invalid, return false.
         */
        else {
            return false
        }
    }

    fun initializeGrid() {

        /**
         * Generates a randomized grid. It may generate a grid where it is not possible
         * to find a valid path for the robot.
         */
        for (i in 0..SIZE - 1) {
            for (j in 0..SIZE - 1) {
                grid[i][j] = (0..BLOCKER).random()
            }
        }


        /**
         * Pre-defined grid with blockers, to make sure the algorithm works.
         **/
        /**
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
        **/
    }

    /**
     * Prints the grid to the console, showing blocker tiles and pathway tiles.
     */
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

    /**
     * Moves the position to the tile to the right if the move is valid, else returns null
     */
    fun moveRight(pos: Pair<Int, Int>?): Pair<Int, Int>? {
        val value = pos!!.second  + 1
        if (value >= SIZE) {
            return null
        }
        if (grid[pos.first][value] == BLOCKER) {
            return null
        }
        return Pair(pos.first, value)

    }

    /**
     * Moves the position to the tile below the current tile if the move is valid, else returns null
     */
    fun moveDown(pos: Pair<Int, Int>?): Pair<Int, Int>? {
        val value = pos!!.first + 1
        if (value >= SIZE) {
            return null
        }
        if (grid[value][pos.second] == BLOCKER) {
            return null
        }
        return Pair(value, pos.second)
    }

}