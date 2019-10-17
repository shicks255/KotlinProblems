package Basics.AccessModifier

fun main(args: Array<String>) {

    val steve: Person = SecretPerson(30, "steve")
    steve.getMarried(SecretPerson(30, "Some girl"))

    val lessSecretSteve: Person = LessSecretPerson(30, "steve", "man")
    lessSecretSteve.getMarried(steve)
    lessSecretSteve.getMarried(LessSecretPerson(30, "Some GIrl", "woman"))
}

abstract class Person(age: Int, name: String) {
    abstract fun getMarried(person: Person)
}

class SecretPerson(age: Int, name: String): Person(age, name) {
    override fun getMarried(person: Person) {
        println("We now join these 2 in holy matrimony")
    }
}

class LessSecretPerson(age: Int, val name: String, sex: String): Person(age, name) {

    private val fullName: String
        get() {
            return name.toUpperCase()
        }

    private var feeling: String = ""
        get() {
            return if (field.isEmpty()) "nothing" else field
        }
        set(value) {
            field = value
        }

    override fun getMarried(person: Person) {
        when (person) {
            is SecretPerson -> println("we now join $name and some other person in holy matrimony")
            is LessSecretPerson -> println("We now join $fullName and ${person.name} in holy matrimony")
        }

        println(feeling)
        feeling = "depress"
        println(feeling)
    }
}
