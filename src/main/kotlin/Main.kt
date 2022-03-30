import josephus.JosephusSolution as feb23
import lockers.LockersSolution as mar28

fun main(args: Array<String>) {

    val sep : String = String().padEnd(10, '-')

    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")

    System.out.println(sep)
    feb23.toString()

    System.out.println(sep)
    mar28.toString()

    System.out.println(sep)
}