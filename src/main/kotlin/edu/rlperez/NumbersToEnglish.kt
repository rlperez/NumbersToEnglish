package edu.rlperez

import kotlin.math.abs

class NumbersToEnglish {
    private val words = arrayOf(
        arrayOf(
            "zero", "one", "two",
            "three", "four", "five",
            "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve",
            "thirteen", "fourteen",
            "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"
        ),
        arrayOf(
            "", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
        ),
        arrayOf("hundred", "thousand", "million", "billion")
    )

    fun convert(number: Int): String {
        return if (number == 0)
            words[0][0]
        else {
            var posNum = abs(number)
            val arr = IntArray(4)
            (0..3).forEach { i ->
                arr[i] = posNum % 1000
                posNum /= 1000
            }

            val threeDigitGroups = arr.map { i -> threeDigitGroupToEnglish(i) }
            var result = threeDigitGroups[0]
            var appendAnd = (arr[0] in 1..99)
            (1..3).forEach { i ->
                if (arr[i] != 0) {
                    val prefix = threeDigitGroups[i] + " " + words[2][i] + " "

                    if (result.isNotEmpty()) {
                        if (appendAnd) result += " and "
                        appendAnd = false
                    }

                    result = prefix + result
                }
            }

            return result.trim()
        }
    }

    private fun threeDigitGroupToEnglish(i: Int): String {
        var text = ""
        val hundreds = i / 100
        val tensUnits = i % 100
        if (hundreds != 0) {
            text += words[0][hundreds] + " " + words[2][0]
            if (tensUnits != 0)
                text += " and "
        }

        val tens = tensUnits / 10
        val units = tensUnits % 10
        if (tens >= 2) {
            text += words[1][tens]
            if (units != 0) {
                text += " " + words[0][units]
            }
        } else if (tensUnits != 0) {
            text += words[0][tensUnits]
        }

        return text
    }

}

fun main() {
    val converter = NumbersToEnglish()
    var input = ""
    while (input.toUpperCase() != "Q") {
        print("Enter a positive integer number or Q to exit: ")
        input = readLine().orEmpty()
        if (input.toUpperCase() == "Q") break
        if (input.isNotBlank()) println(converter.convert(input.toInt()))
    }
}

