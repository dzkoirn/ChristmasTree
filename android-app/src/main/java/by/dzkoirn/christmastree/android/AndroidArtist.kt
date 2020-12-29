package by.dzkoirn.christmastree.android

import android.graphics.Canvas
import android.graphics.Paint
import android.view.SurfaceHolder
import by.dzkoirn.graphic.common.Line
import by.dzkoirn.graphic.common.AbstractArtist
import by.dzkoirn.graphic.common.Color
import by.dzkoirn.graphic.common.Point
import java.lang.IllegalStateException

class AndroidArtist(
    private val surfaceHolder: SurfaceHolder,
) : AbstractArtist {

    private lateinit var canvas: Canvas

    override fun startDrawing() {
        canvas = surfaceHolder.surface.lockCanvas(null)
    }

    override fun postUpdates() {
        withCanvas {
            surfaceHolder.surface.unlockCanvasAndPost(this)
        }
    }

    @ExperimentalUnsignedTypes
    override fun drawLines(lines: Collection<Line>, color: Color) {
        val linesArray = FloatArray(lines.size)
        lines.foldIndexed(linesArray) { index, acc, (start, end) ->
            val position = index * 4
            acc[position] = start.x
            acc[position + 1] = start.y
            acc[position + 2] = end.x
            acc[position + 3] = end.y
            acc
        }
        val paint = Paint().apply {
            this.color = color.rgbColor.toInt()
        }
        withCanvas {
            drawLines(linesArray, paint)
        }
    }

    override fun drawPoints(collection: Collection<Point>, color: Color) {
        TODO("Not yet implemented")
    }

    override fun drawPoint(point: Point, color: Color) {
        TODO("Not yet implemented")
    }

    private fun withCanvas(block: Canvas.() -> Unit) {
        if (::canvas.isInitialized.not()) {
            throw IllegalStateException()
        }
        canvas.block()
    }
}