package Basics

class Person(val firstName: String, val lastName: String = "", age: Int) {

    init {
        println("creating new person")
        if (age > 0)
            print("dam you are old")
    }

    override fun toString(): String {
        when (lastName.length){
            0 -> return "Your name is $firstName"
            else -> return "Your name is $firstName $lastName"
        }
    }

}