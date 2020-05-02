package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var itemsToProduct = itemsFromArray.filterIsInstance<Int>()
        itemsToProduct = itemsToProduct.sortedBy{ it.absoluteValue }.reversed()
        var result = 1

        if(itemsToProduct.isEmpty()) {
            return 0
        }

        if(itemsToProduct.size <= numberOfItems) {
            for (item in itemsToProduct){
                result *= item
            }
            return result
        }

        val positiveItems = itemsToProduct.filter { item -> item >= 0 }
        var resultPositive = 1
        for (i in 0 until numberOfItems){
            result *= itemsToProduct[i]
        }
        for (i in 0 until numberOfItems){
            resultPositive *= positiveItems[i]
        }
        if (resultPositive > result){
            return resultPositive
        }
        return result
    }
}
