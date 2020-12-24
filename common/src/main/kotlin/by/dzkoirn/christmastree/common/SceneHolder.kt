package by.dzkoirn.christmastree.common

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
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
                treeHolder.treeLines.forEach {
//                    canvas.drawLine
                }

            }
        }

    companion object {

        fun create(
            width: Int,
            height: Int,
            ballSize: Int,
            gapSize: Int,
            virtualPainter: VirtualPainter,
            virtualCanvas: VirtualCanvas
        ): SceneHolder {
            val deep = calculateTreeDeep(width, ballSize, gapSize)
            return SceneHolder(TreeHolder.generateTree(deep, width, height), virtualPainter, virtualCanvas)
        }

        private fun calculateTreeDeep(
            width: Int, ballSize: Int, gapSize: Int
        ) = generateSequence(1) { previous -> previous + 1 }
                .last { deep -> pow2(deep).let { it * ballSize + (it + 1) * gapSize } < width }
    }
}
