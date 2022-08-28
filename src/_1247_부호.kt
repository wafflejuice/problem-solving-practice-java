import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    for (i in 1..3) {
        val n = br.readLine().toInt()
        var sum = BigDecimal.ZERO
        for (j in 1..n) {
            sum = sum.add(br.readLine().toBigDecimal())
        }

        if (sum > BigDecimal.ZERO) {
            println("+")
        } else if (sum < BigDecimal.ZERO) {
            println("-")
        } else {
            println("0")
        }
    }
}