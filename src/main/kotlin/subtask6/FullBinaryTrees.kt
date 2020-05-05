package subtask6

import java.util.*


class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        if (count%2 == 0) {
            return "[]"
        }

        val topologies: MutableMap<Int, MutableList<Node>> = HashMap()

        topologies[1] = ArrayList<Node>()
        topologies[1]?.add(Node())


        var i = 3
        while (i <= count) {
            val list: MutableList<Node> = ArrayList()
            var j = 1
            while (j < i) {
                val left: MutableList<Node>? = topologies[j]
                val right: MutableList<Node>? = topologies[i - j - 1]
                list.addAll(generateAllCombinations(left, right))
                j += 2
            }
            topologies[i] = list
            i += 2
        }

        val result: List<Node>? = topologies[count]
        var resultString = ""
        result!!.stream().forEach {
            var str = "[${Node().nodeNotNullMarker},$it]"
            do {
                str = str.replace("null,null,]", "]")
            } while (str.endsWith("null,null,]"))
            str = str.replace(",]", "]")
            resultString += str
        }
        return "[$resultString]"
    }

    private fun generateAllCombinations( left: MutableList<Node>?, right: MutableList<Node>?): Collection<Node> {
        val list: MutableList<Node> = ArrayList()
        for (i in left!!.indices) {
            for (j in right!!.indices) {
                val nNode = Node()
                nNode.left = left[i].clone()
                nNode.right = right[j].clone()
                list.add(nNode)
            }
        }
        return list
    }


    class Node(var nodeNotNullMarker: String = "0") {
        var left: Node? = null
        var right: Node? = null

        fun clone(): Node {
            val nNode = Node()
            if (left != null) nNode.left = left!!.clone()
            if (right != null) nNode.right = right!!.clone()
            return nNode
        }

        override fun toString(): String {
            return if (left != null && right != null) {
                "${left!!.nodeNotNullMarker},${right!!.nodeNotNullMarker}," + left.toString() + right.toString()
            } else {
                "${left.toString()},${right.toString()},"
            }
        }
    }
}
