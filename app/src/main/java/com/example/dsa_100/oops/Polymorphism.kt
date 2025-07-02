package com.example.dsa_100.oops

open class Animal {
    open fun makeSound() = "Generic animal sound"
}

class Cat : Animal() {
    override fun makeSound() = "Meow"
}

class Dog : Animal() {
    override fun makeSound() = "Woof"
}

fun main() {
    val animals: List<Animal> = listOf(Cat(), Dog())
    animals.forEach { println(it.makeSound()) }
    // Output:
    // Meow
    // Woof
}