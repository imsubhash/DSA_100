package com.example.dsa_100.bitmanipulation


fun minBitFlipsAlternative(start: Int, goal: Int): Int {
    var xorResult = start xor goal // XORing finds bits that are different
    var count = 0
    while (xorResult > 0) {
        xorResult = xorResult and (xorResult - 1) // Clears the least significant set bit
        count++
    }
    return count
}
