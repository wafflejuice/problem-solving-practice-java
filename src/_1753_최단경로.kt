import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val k = br.readLine().toInt()

    val graph = List(v + 1) { HashMap<Int, Int>() }

    for (ei: Int in 0 until e) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        graph[u][v] = min(graph[u][v] ?: Int.MAX_VALUE, w)
    }

    val dists = MutableList(v + 1) { Int.MAX_VALUE }
    dists[k] = 0

    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    q.add(Pair(0, k))

    while (!q.isEmpty()) {
        val curr = q.poll().second

        for ((end, weight) in graph[curr]) {
            val newDist = dists[curr] + weight
            if (newDist < dists[end]) {
                dists[end] = newDist
                q.add(Pair(newDist, end))
            }
        }
    }

    for (vi: Int in 1..v) {
        println("${if (dists[vi] == Int.MAX_VALUE) "INF" else dists[vi]}")
    }
}
