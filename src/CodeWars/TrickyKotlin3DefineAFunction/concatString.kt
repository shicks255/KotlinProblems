package CodeWars.TrickyKotlin3DefineAFunction

fun main()
{
    println(concatString("apple", "sauce"))
}

val concatString: (String,String) -> String = String::plus