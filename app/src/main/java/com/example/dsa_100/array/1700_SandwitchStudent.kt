package com.example.dsa_100.array

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    var circleStudentCount = 0
    var squareStudentCount = 0

    // Count the number of students who want each type of sandwich
    for (student in students) {
        if (student == 0) {
            circleStudentCount++
        } else {
            squareStudentCount++
        }
    }

    // Serve sandwiches to students
    for (sandwich in sandwiches) {
        // No student wants the circle sandwich on top of the stack
        if (sandwich == 0 && circleStudentCount == 0) {
            return squareStudentCount
        }
        // No student wants the square sandwich on top of the stack
        if (sandwich == 1 && squareStudentCount == 0) {
            return circleStudentCount
        }
        // Decrement the count of the served sandwich type
        if (sandwich == 0) {
            circleStudentCount--
        } else {
            squareStudentCount--
        }
    }

    // Every student received a sandwich
    return 0
}
