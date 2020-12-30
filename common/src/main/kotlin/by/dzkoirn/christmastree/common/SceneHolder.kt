package by.dzkoirn.christmastree.common

import by.dzkoirn.graphic.common.AbstractArtist
import by.dzkoirn.graphic.common.Colors
import kotlinx.coroutines.*
import kotlin.time.ExperimentalTime

class SceneHolder(
    private val treeHolder: TreeHolder,
    private val artist: AbstractArtist,
) {
    private var loopJob: Job? = null

    @ExperimentalUnsignedTypes
    @ExperimentalTime
    fun start() {
        loopJob = loop()
    }

    fun stop() {
        loopJob?.cancel()
    }

    @ExperimentalUnsignedTypes
    @ExperimentalTime
    private fun loop() =
        GlobalScope.launch {
            while (isActive) {
                artist.startDrawing()
                artist.drawLines(treeHolder.treeLines, Colors.Green)
                artist.drawBalls(treeHolder.treeBalls, Colors.Cyan)
                artist.postUpdates()
                delay(100)
            }
        }
}
