package by.dzkoirn.graphic.common

interface AbstractArtist {

    fun startDrawing()

    fun postUpdates()

    fun drawLines(lines: Collection<Line>, color: Color)

    fun drawPoints(points: Collection<Point>, color: Color)

    fun drawPoint(point: Point, color: Color)
}