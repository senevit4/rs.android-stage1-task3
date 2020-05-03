package subtask4

import java.util.*


class SquareDecomposer {


    fun decomposeNumber(number: Int): Array<Int>? {
        val numberLong = number.toLong()
        val decomposedList = decomposer(numberLong, numberLong * numberLong)

        return if (decomposedList != null) {
            decomposedList.removeAt(decomposedList.size -1)
            decomposedList.toTypedArray()
        } else {
            null
        }

    }

    private fun decomposer(n: Long, remain: Long): MutableList<Int>? {
        if (remain == 0.toLong()) {
            val resultList: MutableList<Int> = ArrayList()
            resultList.add(n.toInt())
            return resultList
        }

        for (i in n - 1 downTo 1) {
            val difference = remain - i * i
            if (difference >= 0) {
                val resultList = decomposer(i, difference)
                if (resultList != null) {
                    resultList.add(n.toInt())
                    return resultList
                }
            }
        }

        return null
    }
}
