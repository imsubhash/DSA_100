package com.example.dsa_100.array

class Solution {

    fun dfs(
        box: Int,
        status: IntArray,
        candies: IntArray,
        keys: Array<IntArray>,
        containedBoxes: Array<IntArray>,
        visited: MutableSet<Int>,
        foundBoxes: MutableSet<Int>
    ): Int {
        if (visited.contains(box)) {
            return 0
        }

        if (status[box] == 0) {
            foundBoxes.add(box)
            return 0
        }

        visited.add(box)
        var candiesCollected = candies[box]

        for (innerBox in containedBoxes[box]) {
            candiesCollected += dfs(
                innerBox,
                status,
                candies,
                keys,
                containedBoxes,
                visited,
                foundBoxes
            )
        }

        for (boxKey in keys[box]) {
            status[boxKey] = 1
            if (foundBoxes.contains(boxKey)) {
                candiesCollected += dfs(
                    boxKey,
                    status,
                    candies,
                    keys,
                    containedBoxes,
                    visited,
                    foundBoxes
                )
            }
        }

        return candiesCollected
    }

    fun maxCandies(
        status: IntArray,
        candies: IntArray,
        keys: Array<IntArray>,
        containedBoxes: Array<IntArray>,
        initialBoxes: IntArray
    ): Int {
        var candiesCollected = 0
        val visited = mutableSetOf<Int>()
        val foundBoxes = mutableSetOf<Int>()

        for (box in initialBoxes) {
            candiesCollected += dfs(box, status, candies, keys, containedBoxes, visited, foundBoxes)
        }

        return candiesCollected
    }
}