package robot

import core.ChallengeSolution

object RobotSolution: ChallengeSolution() {

    val tag = tab + "ROBOT >> "
    val SIZE = 10
    var robotPos = Pair(0, 0)
    val grid : Array<IntArray> = Array(SIZE) {IntArray(SIZE) {0} }
    val end = Pair(SIZE - 1, SIZE - 1)


    override fun solve() {
        println("ROBOT")

        val response = navigateRobot()

        if (response) {
            println("Robot successfully navigated!")
        }
        else {
            println("Robot unable to navigate to lower right corner!")
        }
    }

    private fun navigateRobot(): Boolean {
        initializeGrid()
        markRobot()
        var moved = true

        while (robotPos != end && moved) {
            val shiftRight = robotPos.second + 1
            val shiftDown = robotPos.first + 1
            var canMoveRight: Boolean = false
            var canMoveDown: Boolean = false
            var right: Pair<Int, Int>? = null
            var down: Pair<Int, Int>? = null


            if (shiftDown < SIZE) {
                down = Pair(shiftDown, robotPos.second)
            }
            if (shiftRight < SIZE) {
                right = Pair(robotPos.first, shiftRight)
            }

            if (down != null) {
                if (grid[down.first][down.second] == 0) {
                    canMoveDown = true
                }
            }

            if (right != null) {
               if (grid[right.first][right.second] == 0) {
                   canMoveRight = true
               }
            }


            if (canMoveRight && canMoveDown) {
                moveRight()
                moved = true
                println(tag + "Robot moved RIGHT")
            }
            else if (!canMoveRight && canMoveDown) {
                moveDown()
                moved = true
                println(tag + "Robot moved DOWN")
            }
            else if (canMoveRight && !canMoveDown){
                moveRight()
                moved = true
                println(tag + "Robot moved RIGHT")
            }
            else {
                println(tag + "No valid moves!")
                moved = false
            }
            println(tag + "RobotPos: " + robotPos)
        }

        return moved

    }

    fun initializeGrid() {
        grid[0][1] = 1
        grid[2][0] = 1
        grid[2][1] = 1
        grid[2][2] = 1
        grid[2][4] = 1
        grid[4][3] = 1
        grid[5][5] = 1
        grid[6][6] = 1
        grid[9][7] = 1
    }

    fun moveRight() {
        demarkRobot()
        robotPos = robotPos.copy(robotPos.first, robotPos.second + 1)
        markRobot()
    }

    fun moveDown() {
        demarkRobot()
        robotPos = robotPos.copy(robotPos.first + 1, robotPos.second)
        markRobot()
    }

    fun markRobot() {
        grid[robotPos.first][robotPos.second] = 5
    }

    fun demarkRobot() {
        grid[robotPos.first][robotPos.second] = 0
    }
}