package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    private val xSymbol = "x"
    private val degreeSymbol = "^"
    private val plusSymbol = "+"
    private val minusSymbol = "-"

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        var result = ""
        var afterCoifPart = ""
        var coifPart:String
        if(numbers.isEmpty()) {
            return null
        }
        //result+= numbers[0].toString() + xSymbol + degreeSymbol + numbers.size
        for (i in numbers.indices) {
            if((numbers.size - i - 1) == 0) {
                afterCoifPart = ""
            }
            if((numbers.size - i - 1) == 1) {
                afterCoifPart = xSymbol
            }
            if((numbers.size - i - 1) > 1) {
                afterCoifPart = xSymbol + degreeSymbol + (numbers.size - i - 1)
            }
            coifPart = if(numbers[i].absoluteValue == 1) {
                ""
            } else {
                numbers[i].absoluteValue.toString()
            }
            if(numbers[i] > 0) {
                result += plusSymbol + coifPart + afterCoifPart
            }
            if(numbers[i] < 0) {
                result += minusSymbol + coifPart + afterCoifPart
            }
            if(numbers[i] == 0) {
                result += ""
            }
        }
        result = result.substring(1 until result.length)
        result = result.replace(plusSymbol, " $plusSymbol ")
        result = result.replace(minusSymbol, " $minusSymbol ")
        return result
    }
}
