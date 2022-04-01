package josephus

import ChallengeSolution

/**
 * David Berry
 * Solution to the weekly coding challenge of week 23 February 2022
 */

object JosephusSolution : ChallengeSolution() {

    public override fun solve() {
        println("JOSEPHUS CIRCLE")
        println("Size 41, interval 3: " + josephus(41, 3))
        println("Size 35, interval 11: " + josephus(35, 11))
        println("Size 11, interval 1: " + josephus(11, 1))
        println("Size 2, interval 2: " + josephus(2, 2))
    }

    private fun josephus(circleSize : Int, interval : Int) : Int {
        var circle : Array<Boolean> = Array<Boolean>(circleSize, {i -> true})
        val predicate: (Boolean) -> Boolean = {it == true}
        var remaining = circle.asList().count(predicate)
        var position : Int = 0
        var count = interval - 1
        var survivor : Int = -1

        while (remaining >= 1) {
            if (!circle[position]) {
                position++
            }
            else if (count > 0 && circle[position]) {
                position++
                count--
            }
            else if (count == 0) {
                survivor = position
                circle[position] = false
                count = interval - 1
            }
            if (position >= circleSize) {
                position -= circleSize
            }
            remaining = circle.asList().count(predicate)
        }

        return survivor + 1
    }
}