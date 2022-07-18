import java.util.*

fun main() {

    val sc = Scanner(System.`in`)
    val matSize = sc.nextLine().split(" ").map { it.toInt() }
    val n = matSize[0]
    val m = matSize[1]
    val mat1 = Array(n) { Array(m) { 0 } }
    val mat2 = Array(n) { Array(m) { 0 } }

    for (row: Int in 0 until n) {
        val line = sc.nextLine()
        for (col: Int in 0 until m) {
            mat1[row][col] = line[col] - '0'
        }
    }
    for (row: Int in 0 until n) {
        val line = sc.nextLine()
        for (col: Int in 0 until m) {
            mat2[row][col] = line[col] - '0'
        }
    }

    var cnt = 0
    for (row: Int in 1 until n - 1) {
        for (col: Int in 1 until m - 1) {
            if (mat1[row - 1][col - 1] != mat2[row - 1][col - 1]) {
                cnt++
                for (dx: Int in -1..1) {
                    for (dy: Int in -1..1) {
                        mat1[row + dx][col + dy] = 1 - mat1[row + dx][col + dy]
                    }
                }
            }
        }
    }

    if (isSame(n, m, mat1, mat2)) {
        println(cnt)
    } else {
        println(-1)
    }
}

fun isSame(n: Int, m: Int, mat1: Array<Array<Int>>, mat2: Array<Array<Int>>): Boolean {
    for (row: Int in 0 until n) {
        for (col: Int in 0 until m) {
            if (mat1[row][col] != mat2[row][col]) {
                return false
            }
        }
    }

    return true
}