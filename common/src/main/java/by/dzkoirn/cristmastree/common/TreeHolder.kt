package by.dzkoirn.cristmastree.common

class TreeHolder private constructor(
    private val root: Leaf
) {

    private data class Leaf(
        val point: Point,
        private val left: Leaf? = null,
        private val right: Leaf? = null,
    )

    private data class Point(
        val x: Double,
        val y: Double,
    )




    companion object {

        /**
         * return root of the Tree
         */
        fun generateTree(
            deep: Int,
            width: Int,
            height: Int,
        ): TreeHolder = TreeHolder(
            generateTree(deep, width, height/deep, emptySequence())
        )

        private tailrec fun generateTree(
            deep: Int,
            width: Int,
            height: Int,
            sequence: Sequence<Leaf>
        ): Leaf {
            val leafs = sequence {
                val slices = pow2(deep)
                val elements = slices / 2
                val sliceSize = width / slices

                repeat(elements) { index ->
                    yield(
                        Leaf(
                            point = Point(x = (sliceSize + index * 2 * sliceSize).toDouble(), y = (height * deep).toDouble()),
                            left = sequence.elementAtOrNull(index * 2),
                            right = sequence.elementAtOrNull(index * 2 + 1)
                        )
                    )
                }
            }
            return if (deep == 1) {
                leafs.elementAt(0)
            } else {
                generateTree(deep - 1, width, height, leafs)
            }
        }

    }

}