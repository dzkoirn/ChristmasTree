package by.dzkoirn.cristmastree.common

import kotlin.math.pow
import kotlin.time.ExperimentalTime

class SceneHolder(
    private val treeHolder: TreeHolder
) {

    @Volatile
    private var isRunningFlag = false

    @ExperimentalTime
    fun start() {
        isRunningFlag = true
        loop()
    }

    fun stop() {
        isRunningFlag = false
    }

    @ExperimentalTime
    private fun loop() {
//        takeUnless {  }
//        GlobalScope.launch {
//            loop()
//        }.start()
//        delay(1.seconds)
    }

    companion object {

        fun create(width: Int, height: Int, ballSize: Int, gapSize: Int): SceneHolder {
            val deep = calculateTreeDeep(width, ballSize, gapSize)
            return SceneHolder(TreeHolder.generateTree(deep, width, height))
        }

        private fun calculateTreeDeep(
            width: Int, ballSize: Int, gapSize: Int
        ) = generateSequence(1) { previous -> previous + 1 }
                .last { deep -> pow2(deep).let { it * ballSize + (it + 1) * gapSize } < width }
    }
}
