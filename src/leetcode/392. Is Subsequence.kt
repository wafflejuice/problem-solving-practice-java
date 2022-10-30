package leetcode

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) {
        return true
    }

    var si = 0
    for (ti in t.indices) {
        if (t[ti] == s[si]) {
            si++
            if (si == s.length) {
                return true
            }
        }
    }
    return false
}

fun main() {
    assert(isSubsequence(s = "abc", t = "ahbgdc") == true)
    assert(isSubsequence(s = "axc", t = "ahbgdc") == false)
}
