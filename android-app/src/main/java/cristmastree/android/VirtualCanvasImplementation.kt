package cristmastree.android

import android.graphics.Canvas
import by.dzkoirn.christmastree.common.Point
import by.dzkoirn.christmastree.common.VirtualCanvas

class VirtualCanvasImplementation(
    private val canvas: Canvas
) : VirtualCanvas {

    override val width: Int
        get() = canvas.width
    override val height: Int
        get() = canvas.height

    fun drawLine(start: Point, stop: Point) {
//        Paint()
//        canvas.drawLine(start.x, start.y, stop.x, stop.y, )
    }
}