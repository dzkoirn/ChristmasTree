package by.dzkoirn.christmastree.common

data class Point(
    val x: Float,
    val y: Float,
)

data class Line(
    val start: Point,
    val end: Point
)