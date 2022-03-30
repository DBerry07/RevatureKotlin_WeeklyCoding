import challenge_2022feb23.Challenge_2022Feb23

fun main(args: Array<String>) {
    val emptyString : String = ""
    val sep : String = emptyString.padEnd(10, '-')

    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")

    println(sep)
    Challenge_2022Feb23.toString()

    println(sep)
}