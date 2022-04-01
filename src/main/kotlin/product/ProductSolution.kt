package product

import core.ChallengeSolution

object ProductSolution : ChallengeSolution() {

    public override fun solve() {
        println("PRODUCT OF DIGITS")
        println("{16, 28}: ${core(16,28)}")
        println("{0}: ${core(0)}")
        println("{1, 2, 3, 4, 5, 6}: ${core(1, 2, 3, 4, 5, 6)}")
    }

    private fun core(vararg args : Int) : Int {

        val list : MutableList<Int> = MutableList(0) {_ -> 0}
        var answer : Int = 0

        for (each in args) {
            list.add(each)
        }
        answer = sum(list)
        answer = product(answer)

        return answer;
    }

    private fun sum(list : MutableList<Int>) : Int{

        var sum : Int = 0

        for (each in list) {
            sum += each
        }

        return sum
    }

    private fun product(value : Int) : Int {
        val list : MutableList<Int> = MutableList(0) { _ -> 0 }
        var product : Int = 1;

        val str : String = value.toString()
        for (char in str) {
            list.add(char.digitToInt())
        }

        for (int in list) {
            product *= int
        }

        if (product < 10) {
            return product
        }
        else {
            return product(product)
        }
    }
}