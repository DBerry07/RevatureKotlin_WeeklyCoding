package core

abstract class ChallengeSolution {

    public val tab = "   "

    public abstract fun solve();

    public fun println(str : String) : Boolean {
        System.out.println(str)
        return true
    }

    public fun println(int : Int) : Boolean{
        System.out.println(int)
        return true
    }

}