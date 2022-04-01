import josephus.JosephusSolution as feb23
import lockers.LockersSolution as mar28
import fibonacci.FibonacciSolution as mar07

fun main(args: Array<String>) {

    val sep : String = String().padEnd(10, '-')

    println(sep)
    println("WEEKLY CODING CHALLENGES - Kotlin Edition")
    println(">>David W Berry")
    //println("Hello World!")
    //println("Program arguments: ${args.joinToString()}")

    println(sep)
    feb23.solve()

    println(sep)
    mar28.solve()

    println(sep)
    mar07.solve()

    println(sep)
    println("END OF PROGRAM")

}