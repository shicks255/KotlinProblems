package Basics.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun main(args: Array<String>) {

    val counter = AtomicInteger()
    val runner = MyFirstCoroutine(counter)

    runner.threads()
    runner.coRout()
    runner.suspendedCoRout()
//    runner.test()

    println(counter.get())
}



class MyFirstCoroutine(val counter: AtomicInteger) {

    fun threads() {

        val start = System.currentTimeMillis()

        for (i in 1..1_000_000) {
            thread(start = true) {
                counter.addAndGet(1)
            }
        }
        println(System.currentTimeMillis() - start)
    }

    fun coRout() {

        val start = System.currentTimeMillis()

        for (i in 1..1_000_000) {
            GlobalScope.launch {
                counter.addAndGet(1)
            }
        }

        println(System.currentTimeMillis() - start)

    }

    fun suspendedCoRout() {

        val start = System.currentTimeMillis()

        val sum = (1..1_000_000).map { n ->
            GlobalScope.async {
                delay(100)
                counter.addAndGet(1)
                n
            }
        }

        runBlocking {
            val answer = sum.sumBy { it.await() }
            println(answer)
        }

        println("took " + (System.currentTimeMillis() - start))
    }

    fun test() {
        val start = System.currentTimeMillis()

        val sum = (1..1_000_000).map { n ->
            Thread.sleep(100)
            n
        }
        println(sum)

        println("took " + (System.currentTimeMillis() - start))
    }

}
