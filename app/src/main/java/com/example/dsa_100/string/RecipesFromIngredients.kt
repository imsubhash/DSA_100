package com.example.dsa_100.string

fun findAllRecipes(
    recipes: Array<String>,
    ingredients: List<List<String>>,
    supplies: Array<String>
): List<String> {
    val n = recipes.size
    val result = mutableListOf<String>()
    val availableSupplies = supplies.toMutableSet()
    val cooked = BooleanArray(n)
    var iterations = n

    while (iterations-- > 0) {
        var recipeMadeInThisIteration = false
        for (j in 0 until n) {
            if (cooked[j]) {
                continue
            }

            var canMake = true
            for (ing in ingredients[j]) {
                if (!availableSupplies.contains(ing)) {
                    canMake = false
                    break
                }
            }

            if (canMake) {
                availableSupplies.add(recipes[j])
                result.add(recipes[j])
                cooked[j] = true
                recipeMadeInThisIteration = true
            }
        }
        if (!recipeMadeInThisIteration && iterations > 0) {
            break
        }
    }

    return result
}

fun main() {
    val recipes = arrayOf("bread", "sandwich", "burger")
    val ingredients = listOf(
        listOf("yeast", "flour"),
        listOf("bread", "meat"),
        listOf("sandwich", "meat", "bread")
    )
    val supplies = arrayOf("yeast", "flour", "meat")

    val result = findAllRecipes(recipes, ingredients, supplies)
    println(result)  // Output: [bread, sandwich, burger]
}