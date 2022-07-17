import java.util.Scanner
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    sc.nextLine()
    for (i: Int in 1..t) {
        val line = sc.nextLine()
        val values = line.split(' ').map{ it.toInt() }
        val x1 = values[0]
        val y1 = values[1]
        val r1 = values[2]
        val x2 = values[3]
        val y2 = values[4]
        val r2 = values[5]

        println(countCross(x1, y1, r1, x2, y2, r2))
    }
}

fun countCross(x1: Int, y1: Int, r1: Int, x2: Int, y2: Int, r2: Int): Int {
    if (x1 == x2 && y1 == y2) {
        return if (r1 == r2) -1 else 0
    }

    val dist = sqrt((x1 - x2).toDouble().pow(2) + (y1 - y2).toDouble().pow(2))
    val range = (r1 + r2).toDouble()

    if (dist.compareTo(range) < 0) {
        val outerCheck = (dist + min(r1, r2)).compareTo(max(r1, r2))
        if (outerCheck < 0) {
            return 0
        } else if (outerCheck == 0) {
            return 1
        } else {
            return 2
        }
    } else if (dist.compareTo(range) == 0) {
        return 1
    } else {
        return 0
    }
}