package com.example.dsa_100.array

fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
    val n = nums.size
    val result = IntArray(n - k + 1)
    val frequency = mutableMapOf<Int, Int>()

    for (i in 0 until k) {
        frequency[nums[i]] = frequency.getOrDefault(nums[i], 0) + 1
    }
    result[0] = calculateXSum(frequency, x)

    for (i in 1..n - k) {
        // Remove the element going out of the window
        val outgoingNum = nums[i - 1]
        frequency[outgoingNum] = frequency[outgoingNum]!! - 1
        if (frequency[outgoingNum] == 0) {
            frequency.remove(outgoingNum)
        }

        // Add the new element entering the window
        val incomingNum = nums[i + k - 1]
        frequency[incomingNum] = frequency.getOrDefault(incomingNum, 0) + 1

        // Calculate x-sum for the current window
        result[i] = calculateXSum(frequency, x)
    }

    return result
}

private fun calculateXSum(frequency: Map<Int, Int>, x: Int): Int {
    // Convert the frequency map to a list of pairs and sort them
    val sortedEntries = frequency.entries.sortedWith(compareByDescending<Map.Entry<Int, Int>> { it.value }.thenByDescending { it.key })

    var sum = 0
    val limit = minOf(x, sortedEntries.size)
    for (i in 0 until limit) {
        sum += sortedEntries[i].key * sortedEntries[i].value
    }
    return sum
}