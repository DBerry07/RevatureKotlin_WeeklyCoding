package challenge_2022mar28

object Challenge_2022Mar28 {

    override fun toString(): String {
        super.toString()
        val str : String = "Open lockers: " + compute()
        return str
    }

    fun compute() : Int {
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