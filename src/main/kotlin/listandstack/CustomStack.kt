package listandstack

import core.ChallengeSolution

object CustomStack : ChallengeSolution() {

    private var stack : MutableList<String> = MutableList(0) {_ -> String()}

    override fun solve() {
        println("STACK")
        println("Pushing {v, a, 1}")
        push( 'v', 'a', 1)
        println("Stack contents: $stack")
        println("Max val: ${max()}")
        println("Popping: ${pop()}")
        println("Stack contents: $stack")
        println("Pushing {9, Z, z, b, Hello}")
        push(9, 'Z', 'z', 'b', "Hello")
        println("Stack contents: $stack")
        println("Max val: ${max()}")
    }

    private fun push(vararg args : Any) {
        for (each in args) {
            stack.add(each.toString())
        }
    }

    private fun pop() : String {
        var lastPos = stack.size - 1
        var item = String();
        try {
            item = stack[lastPos]
        } catch (e : java.lang.Exception) {
            throw e
        }
        stack.removeAt(lastPos)
        return item
    }

    private fun max() : String {
        var max = String()
        try {
            max = stack[0]
        } catch (e : java.lang.Exception) {
            throw e
        }
        for (each in stack) {
            val outcome = max.compareTo(each)
            if (outcome < 0) {
                max = each
            }
        }
        return max
    }
}