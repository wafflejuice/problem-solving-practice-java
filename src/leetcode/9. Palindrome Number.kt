package leetcode

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    if (x == 0) return true

    var palindromeCandidate = x
    var divider: Int
    var firstDigit: Int
    var lastDigit: Int
    while (palindromeCandidate > 0) {
        divider = pow(10, calculateCipher(palindromeCandidate) - 1)
        firstDigit = palindromeCandidate / divider
        lastDigit = palindromeCandidate % 10
        if (firstDigit != lastDigit) return false
        palindromeCandidate %= divider
        palindromeCandidate /= 10
    }

    return true
}

fun pow(base: Int, exp: Int): Int {
    if (exp == 0) return 1

    var result = 1
    for (i in 0 until exp) {
        result *= base
    }

    return result
}

fun calculateCipher(x: Int): Int {
    var count = 1
    var x = x
    while (x >= 10) {
        x /= 10
        count++
    }

    return count
}

fun main() {
    println(isPalindrome(101))
    println(isPalindrome(222))
    println(isPalindrome(-1))
    println(isPalindrome(12322))
    println(isPalindrome(12321))
    println(isPalindrome(123321))
}
