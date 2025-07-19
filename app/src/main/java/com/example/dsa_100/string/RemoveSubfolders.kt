package com.example.dsa_100.string

fun removeSubfolders(folder: Array<String>): List<String> {
    folder.sort()
    val result = mutableListOf<String>()

    for (f in folder) {
        if (result.isEmpty() || !f.startsWith(result.last() + "/")) {
            result.add(f)
        }
    }
    return result
}

fun main() {
    val folder = arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")
    val result = removeSubfolders(folder)
    println(result) // Output: ["/a", "/c/d", "/c/f"]
}
