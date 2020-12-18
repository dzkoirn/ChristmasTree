package by.dzkoirn.cristmastree.android

import android.graphics.Canvas
import by.dzkoirn.cristmastree.common.VirtualCanvas

class VirtualCanvasImplementation(
    private val canvas: Canvas
) : VirtualCanvas {

    override val width: Int
        get() = canvas.width
    override val height: Int
        get() = canvas.height
}