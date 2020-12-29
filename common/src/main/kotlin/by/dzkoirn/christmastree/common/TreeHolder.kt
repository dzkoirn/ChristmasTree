package by.dzkoirn.christmastree.common

import by.dzkoirn.graphic.common.Line
import by.dzkoirn.graphic.common.Point

class TreeHolder internal constructor(
    internal val root: Leaf,
    val treeLines: List<Line>,
    val treePoints: List<Point>
)

internal data class Leaf(
    val point: Point,
    val left: Leaf? = null,
    val right: Leaf? = null,
)

internal fun Leaf.toLine(leaf: Leaf): Line =
    Line(leaf.point, this.point)
