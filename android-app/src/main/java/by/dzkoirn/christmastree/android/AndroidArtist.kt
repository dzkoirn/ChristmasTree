package by.dzkoirn.christmastree.android

import android.graphics.Canvas
import by.dzkoirn.graphic.common.Line
import by.dzkoirn.graphic.common.AbstractArtist
import by.dzkoirn.graphic.common.Color
import by.dzkoirn.graphic.common.Point

class AndroidArtist(
    private val
    private val canvas: Canvas,
) : AbstractArtist {

    private val linesArray: FloatArray = FloatArray(linesCount)

    override fun startDrawing() {
        TODO("Not yet implemented")
    }

    override fun postUpdates() {
        TODO("Not yet implemented")
    }

    override fun drawLines(lines: Collection<Line>, color: Color) {
        lines.foldIndexed(linesArray) { index, acc, (start, end) ->
            val position = index * 4
            acc[position] = start.x
            acc[position + 1] = start.y
            acc[position + 2] = end.x
            acc[position + 3] = end.y
            acc
        }
        canvas.drawLines(linesArray, androidPainter.paint)
    }

    override fun drawPoints(collection: Collection<Point>, color: Color) {
        TODO("Not yet implemented")
    }

    override fun drawPoint(point: Point, color: Color) {
        TODO("Not yet implemented")
    }
}