package subtask5

class TelephoneFinder {

    private val n_0 = arrayOf('8')
    private val n_1 = arrayOf('2', '4')
    private val n_2 = arrayOf('1', '3', '5')
    private val n_3 = arrayOf('2', '6')
    private val n_4 = arrayOf('1', '5', '7')
    private val n_5 = arrayOf('2', '4', '6', '8')
    private val n_6 = arrayOf('3', '5', '9')
    private val n_7 = arrayOf('4', '8')
    private val n_8 = arrayOf('5', '7', '9', '0')
    private val n_9 = arrayOf('6', '8')
    private val result = mutableListOf<String>()


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        for (i in number.indices){
            when(number[i]) {
                '0' -> addCombinations(number, i, n_0)
                '1' -> addCombinations(number, i, n_1)
                '2' -> addCombinations(number, i, n_2)
                '3' -> addCombinations(number, i, n_3)
                '4' -> addCombinations(number, i, n_4)
                '5' -> addCombinations(number, i, n_5)
                '6' -> addCombinations(number, i, n_6)
                '7' -> addCombinations(number, i, n_7)
                '8' -> addCombinations(number, i, n_8)
                '9' -> addCombinations(number, i, n_9)
                else -> return null
            }
        }
        return result.toTypedArray()
    }

    private fun addCombinations(number: String, positionOfNum: Int, arrayOfAdjacent: Array<Char>){
        for (num in arrayOfAdjacent){
            val numberAsArray = number.toCharArray()
            numberAsArray[positionOfNum] = num
            result.add(String(numberAsArray))
        }
    }
}
