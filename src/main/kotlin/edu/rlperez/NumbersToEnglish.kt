package edu.rlperez

class NumbersToEnglish {
    val words = arrayOf(
        arrayOf(
            "zero", "one", "two",
            "three", "four", "five",
            "six", "seven", "eight", "nine"
        ),
        arrayOf(
            "", "ten", "eleven", "twelve",
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
            var posNum = Math.abs(number)
            val arr = IntArray(4)
            for (i in 0..3) {
                arr[i] = posNum % 1000
                posNum /= 1000
            }

            arr.joinToString(" ") { i -> threeDigitGroupToEnglish(i) }
                .trim()
        }
    }

    private fun threeDigitGroupToEnglish(i: Int): String {
        var text = ""
        val hundreds = i / 100
        val tensUnits = i % 100
        if (hundreds != 0) {
            text += words[0][hundreds] + " " + words[3][0]
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

fun main(args: Array<String>) {
    val converter = NumbersToEnglish()
    var input = ""
    while (input.toUpperCase() == "Q") {
        print("Enter a positive integer number or Q to exit: ")
        input = readLine().orEmpty()
        if (input.isNotBlank()) println(converter.convert(input.toInt()))
    }
}

