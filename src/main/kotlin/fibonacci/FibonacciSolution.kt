package fibonacci

import ChallengeSolution

object FibonacciSolution : ChallengeSolution() {

    private const val max : Int = 4000000
    private const val first : Int = 1
    private const val second : Int = 1

    public override fun solve() {
        println("FIBONACCI SUMS")
        val solution : Int = fibonacci(first, second)
        println("Sum of even Fibonacci: $solution")
    }

    private fun fibonacci(first : Int, second : Int) : Int {
        val sum : Int = first + second
        if (sum < max && sum % 2 == 0) {
            return sum + fibonacci(second, sum)
        }
        else if (sum < max){
            return fibonacci(second, sum)
        }
        else {
            return 0
        }
    }
}