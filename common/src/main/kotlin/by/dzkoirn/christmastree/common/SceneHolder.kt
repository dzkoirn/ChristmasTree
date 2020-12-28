package by.dzkoirn.christmastree.common

import kotlinx.coroutines.*
import kotlin.time.ExperimentalTime

class SceneHolder(
    private val treeHolder: TreeHolder,
    private val virtualPainter: VirtualPainter,
    private val canvas: VirtualCanvas
) {

    private var loopJob: Job? = null

    @ExperimentalTime
    fun start() {
        loopJob = loop()
    }

    fun stop() {
        loopJob?.cancel()
    }

    @ExperimentalTime
    private fun loop() =
        GlobalScope.launch {
            while (isActive) {
                canvas.drawLines(treeHolder.treeLines, virtualPainter)
                delay(100)
            }
        }

    companion object {

        fun create(
            width: Int,
            height: Int,
            ballSize: Float,
            gapSize: Float,
            virtualPainter: VirtualPainter,
            virtualCanvas: VirtualCanvas
        ): SceneHolder {
            val deep = calculateTreeDeep(width, ballSize, gapSize)
            return SceneHolder(TreeHolder.generateTree(deep, width, height), virtualPainter, virtualCanvas)
        }
    }
}
