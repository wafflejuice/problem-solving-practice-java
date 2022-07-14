import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val totalAmount = sc.nextBigInteger()
    val perAmount = sc.nextBigInteger()

    val div = totalAmount / perAmount
    println(div)
    println(totalAmount % perAmount)
}