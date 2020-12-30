package by.dzkoirn.christmastree.android

import android.graphics.Canvas
import android.graphics.Paint
import android.view.SurfaceHolder
import by.dzkoirn.graphic.common.*
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
        val linesArray = FloatArray(lines.size * 4)
        lines.foldIndexed(linesArray) { index, acc, (start, end) ->
            val position = index * 4
            acc[position] = start.x
            acc[position + 1] = start.y
            acc[position + 2] = end.x
            acc[position + 3] = end.y
            acc
        }
        withCanvas {
            val paint = Paint().apply {
                this.color = color.rgbColor.toInt()
            }
            drawLines(linesArray, paint)
        }
    }

    @ExperimentalUnsignedTypes
    override fun drawLine(line: Line, color: Color) {
        withCanvas {
            val paint = Paint().apply {
                this.color = color.rgbColor.toInt()
            }
            drawLine(line.start.x, line.start.y, line.end.x, line.end.y, paint)
        }
    }

    @ExperimentalUnsignedTypes
    override fun drawPoints(points: Collection<Point>, color: Color) {
        val pointsArray = FloatArray(points.size * 4)
        points.foldIndexed(pointsArray) { index, acc, p ->
            acc[index * 2] = p.x
            acc[index * 2 + 1] = p.y
            acc
        }
        withCanvas {
            val paint = Paint().apply {
                this.color = color.rgbColor.toInt()
            }
            drawPoints(pointsArray, paint)
        }
    }

    @ExperimentalUnsignedTypes
    override fun drawPoint(point: Point, color: Color) {
        withCanvas {
            val paint = Paint().apply {
                this.color = color.rgbColor.toInt()
            }
            drawPoint(point.x, point.y, paint)
        }
    }

    @ExperimentalUnsignedTypes
    override fun drawBalls(balls: Collection<Ball>, color: Color) {
        balls.forEach {
            drawBall(it, color)
        }
    }

    @ExperimentalUnsignedTypes
    override fun drawBall(ball: Ball, color: Color) {
        withCanvas {
            val paint = Paint().apply {
                this.color = color.rgbColor.toInt()
            }
            drawOval(ball.toRectF(), paint)
        }
    }

    private fun withCanvas(block: Canvas.() -> Unit) {
        if (::canvas.isInitialized.not()) {
            throw IllegalStateException()
        }
        canvas.block()
    }
}