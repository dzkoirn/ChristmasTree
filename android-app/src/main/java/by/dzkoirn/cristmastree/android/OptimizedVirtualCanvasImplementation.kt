package by.dzkoirn.cristmastree.android

import android.graphics.Canvas
import by.dzkoirn.christmastree.common.Line
import by.dzkoirn.christmastree.common.VirtualCanvas
import by.dzkoirn.christmastree.common.VirtualPainter

class OptimizedVirtualCanvasImplementation(
    private val canvas: Canvas,
    private val linesCount: Int
) : VirtualCanvas {

    private val linesArray: FloatArray = FloatArray(linesCount)

    override val width: Int
        get() = canvas.width
    override val height: Int
        get() = canvas.height

    override fun drawLines(treeLines: List<Line>, virtualPainter: VirtualPainter) {
        val androidPainter = virtualPainter as AndroidVirtualPainterImpl
        treeLines.foldIndexed(linesArray) { index, acc, (start, end) ->
            val position = index * 4
            acc[position] = start.x
            acc[position + 1] = start.y
            acc[position + 2] = end.x
            acc[position + 3] = end.y
            acc
        }
        canvas.drawLines(linesArray, androidPainter.paint)
    }
}