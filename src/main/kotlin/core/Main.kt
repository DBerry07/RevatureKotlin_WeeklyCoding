import josephus.JosephusSolution as feb23
import lockers.LockersSolution as mar28
import fibonacci.FibonacciSolution as mar07
import product.ProductSolution as mar02
import listandstack.ListAndStackSolution as mar14
import projectdependencies.ProjectDependenciesSolution as apr18
import robot.RobotSolution as apr2501
import robot.RobotPathfindingSolution as apr2502

fun main(args: Array<String>) {
    //println("Hello World!")
    //println("Program arguments: ${args.joinToString()}")

    val sep : String = String().padEnd(10, '-')

    println(sep)
    println("WEEKLY CODING CHALLENGES - Kotlin Edition")
    println(">>David W Berry")

    println(sep)
    feb23.solve()

    println(sep)
    mar02.solve()

    println(sep)
    mar07.solve()

    println(sep)
    mar14.solve()

    println(sep)
    mar28.solve()

    println(sep)
    apr18.solve()

    println(sep)
    apr2502.solve()

    println(sep)
    println("END OF PROGRAM")

}