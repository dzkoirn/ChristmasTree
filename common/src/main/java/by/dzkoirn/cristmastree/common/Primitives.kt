package by.dzkoirn.cristmastree.common

data class Point(
    val x: Double,
    val y: Double,
)

data class Line(
    val start: Point,
    val end: Point
)