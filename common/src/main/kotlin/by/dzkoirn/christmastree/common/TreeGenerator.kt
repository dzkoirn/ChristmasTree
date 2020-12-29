package by.dzkoirn.christmastree.common

import by.dzkoirn.graphic.common.Leaf
import by.dzkoirn.graphic.common.Line
import by.dzkoirn.graphic.common.Point
import by.dzkoirn.graphic.common.toLine

/**
 * This method compute Tree. It's heavy method.
 * return TreeHolder object.
 */
fun generateProportionalTree(
    deep: Int,
    width: Int,
    height: Int,
): TreeHolder {

    fun calculateTreeDeep(
        width: Int, ballSize: Float, gapSize: Float
    ) = generateSequence(1) { previous -> previous + 1 }
        .last { deep -> pow2(deep).let { it * ballSize + (it + 1) * gapSize } < width }

    tailrec fun generateTree(
        deep: Int,
        width: Int,
        height: Int,
        sequence: List<Leaf> = emptyList()
    ): Leaf {
        val slices = pow2(deep)
        val elements = slices / 2
        val sliceSize = width / slices

        val leafs = (0 until elements).map { index ->
            Leaf(
                point = Point(
                    x = (sliceSize + index * 2 * sliceSize).toFloat(),
                    y = (height * deep).toFloat()
                ),
                left = sequence.elementAtOrNull(index * 2),
                right = sequence.elementAtOrNull(index * 2 + 1)
            )
        }
        return if (deep == 1) {
            leafs.elementAt(0)
        } else {
            generateTree(deep - 1, width, height, leafs)
        }
    }

    tailrec fun treeLines(
        leafs: Collection<Leaf>,
        lines: MutableList<Line> = mutableListOf()
    ): List<Line> {
        val newLeafs = leafs.onEach { leaf ->
            leaf.left?.toLine(leaf)?.let { lines.add(it) }
            leaf.right?.toLine(leaf)?.let { lines.add(it) }
        }.flatMap {
            listOfNotNull(it.left, it.right)
        }
        return if (newLeafs.isEmpty()) {
            lines
        } else {
            treeLines(newLeafs, lines)
        }
    }

    tailrec fun treePoints(
        leafs: Collection<Leaf>,
        points: MutableList<Point> = mutableListOf()
    ): List<Point> {
        val newLeafs = leafs.onEach {
            points.add(it.point)
        }.flatMap {
            listOfNotNull(it.left, it.right)
        }
        return if (newLeafs.isEmpty()) {
            points
        } else {
            treePoints(newLeafs, points)
        }
    }

    val root = generateTree(deep, width, height/(deep + 1))
    val points = treePoints(listOf(root))
    val lines = treeLines(listOf(root))

    return TreeHolder(root, lines, points)
}