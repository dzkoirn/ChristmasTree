package by.dzkoirn.graphic.common

data class Point(
    val x: Float,
    val y: Float,
)

data class Line(
    val start: Point,
    val end: Point
)

data class Ball(
    val point: Point,
    val radius: Float
)

data class Color @ExperimentalUnsignedTypes constructor(
    val rgbColor: UInt // #FFAABBCC
) {
    @ExperimentalUnsignedTypes
    val alpha: UByte = ((rgbColor and 0xFF000000.toUInt()) shr 24).toUByte()
    @ExperimentalUnsignedTypes
    val r: UByte = ((rgbColor and 0x00FF0000.toUInt()) shr 16).toUByte()
    @ExperimentalUnsignedTypes
    val g: UByte = ((rgbColor and 0x0000FF00.toUInt()) shr 8).toUByte()
    @ExperimentalUnsignedTypes
    val b: UByte = (rgbColor and 0x000000FF.toUInt()).toUByte()
}

@ExperimentalUnsignedTypes
object Colors {
    val Cyan = Color(0xff00ffffu)
    val Green = Color(0xFF00FF00u)
}