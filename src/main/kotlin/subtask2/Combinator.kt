package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val combinations = array[0]
        val n = array[1]
        var k = 0
        while(k < n) {
            if(factorial(k) * factorial(n-k) == factorial(n)/combinations) return k
            k++
        }

        return null
    }

    private fun factorial(num: Int): Long {
        return if (num >= 1)
            num * factorial(num - 1)
        else
            1
    }
}
