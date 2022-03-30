package lockers

/**
 * David Berry
 * Solution to the weekly coding challenge of week 28 March 2022
 */

object LockersSolution {

    override fun toString(): String {
        super.toString()
        System.out.println("Open lockers: " + compute())
        return "2022 March 28 Weekly Coding Challenge"
    }

    private fun compute() : Int {
        var lockers : BooleanArray = BooleanArray(100)
        for (num in lockers.indices) {
            lockers[num] = false
        }

        for (num in 1..100) {
            var place : Int = num
            while (place < lockers.size) {
                lockers[place - 1] = !lockers[place - 1]
                place += num
            }
        }

        var count : Int = 0

        for (num in lockers.indices) {
            if (lockers[num]) {
                count++
            }
        }

        return count

    }
}