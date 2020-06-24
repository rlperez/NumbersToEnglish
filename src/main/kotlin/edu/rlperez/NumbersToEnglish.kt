class NumbersToEnglish {
    fun convert(number: Int): String {
        return ""
    }
}

fun main(args: Array<String>) {

    var input = ""
    while(input.toUpperCase() == "Q") {
        print("Enter an integer number or Q to exit: ")
        input = readLine().orEmpty()
    }
}

