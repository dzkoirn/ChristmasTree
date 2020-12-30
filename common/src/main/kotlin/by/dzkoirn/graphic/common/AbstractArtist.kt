package by.dzkoirn.graphic.common

interface AbstractArtist {

    fun startDrawing()

    fun postUpdates()

    fun drawLines(lines: Collection<Line>, color: Color)

    fun drawLine(line: Line, color: Color)

    fun drawPoints(points: Collection<Point>, color: Color)

    fun drawPoint(point: Point, color: Color)

    fun drawBalls(balls: Collection<Ball>, color: Color)

    fun drawBall(ball: Ball, color: Color)

}