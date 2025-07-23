package com.example.dsa_100.array


//PayPal DSA Round
fun findTeams(skills: Array<Int>, minPlayers: Int, minLevel: Int, maxLevel: Int): Int {
    val eligibleCount = skills.count { it in minLevel..maxLevel }
    if (eligibleCount < minPlayers) return 0
    var total = 0L
    for (teamSize in minPlayers..eligibleCount) {
        var res = 1L
        val r = if (teamSize > eligibleCount / 2) eligibleCount - teamSize else teamSize
        for (i in 1..r) {
            res = res * (eligibleCount - i + 1) / i
        }
        total += res
    }
    return if (total > Int.MAX_VALUE) Int.MAX_VALUE else total.toInt()
}


fun main() {
    val skills = arrayOf(12, 4, 6, 13, 5, 10)
    val minPlayers = 3
    val minLevel = 4
    val maxLevel = 10
    println(findTeams(skills, minPlayers, minLevel, maxLevel))  // Output: 5
}