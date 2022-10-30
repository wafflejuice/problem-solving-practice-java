package leetcode

fun isIsomorphic(s: String, t: String): Boolean {
    val map = mutableMapOf<Char, Char>()
    for (i in s.indices) {
        if (s[i] in map.keys) {
            if (map[s[i]] != t[i]) {
                return false
            }
        } else {
            if (t[i] in map.values) {
                return false
            }
            map[s[i]] = t[i]
        }
    }

    return true
}

fun main() {
    assert(isIsomorphic(s = "egg", t = "add") == true)
    assert(isIsomorphic(s = "foo", t = "bar") == false)
    assert(isIsomorphic(s = "paper", t = "title") == true)
}
