package by.dzkoirn.cristmastree.common

class TreeHolder private constructor(
    private val root: Leaf
) {
    fun treeLines(): Sequence<Line> {
        tailrec suspend fun SequenceScope<Line>.treeLines(
            leaf: Leaf
        ) {
            return when {
                leaf.left != null -> {
                    yield(Line(leaf.point, leaf.left.point))
                    treeLines(leaf.left)
                }
                leaf.right != null -> {
                    yield(Line(leaf.point, leaf.right.point))
                    treeLines(leaf.right)
                }
                else -> return
            }
        }
        return sequence {
            treeLines(root)
        }
    }

    fun treePoints(): Sequence<Point> {
        tailrec suspend fun SequenceScope<Point>.treePoints(
            leaf: Leaf
        ) {
            yield(leaf.point)
            return when {
                leaf.left != null -> {
                    treePoints(leaf.left)
                }
                leaf.right != null -> {
                    treePoints(leaf.right)
                }
                else -> return
            }
        }
        return sequence {
            treePoints(root)
        }
    }

    private data class Leaf(
        val point: Point,
        val left: Leaf? = null,
        val right: Leaf? = null,
    )

    companion object {

        /**
         * return root of the Tree
         */
        fun generateTree(
            deep: Int,
            width: Int,
            height: Int,
        ): TreeHolder {

            tailrec fun generateTree(
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

            return TreeHolder(generateTree(deep, width, height/deep, emptySequence()))
        }
    }
}
