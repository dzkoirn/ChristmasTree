package by.dzkoirn.christmastree.common

import by.dzkoirn.graphic.common.Line
import by.dzkoirn.graphic.common.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProportionalTreeGeneratorTest {

    private val expectedPoints by lazy {
        listOf(
            Point(8.0f, 1.0f),
            Point(4.0f, 2.0f), Point(12.0f, 2.0f),
            Point(2.0f, 3.0f), Point(6.0f, 3.0f), Point(10.0f, 3.0f), Point(14.0f, 3.0f),
            Point(1.0f, 4.0f), Point(3.0f, 4.0f), Point(5.0f, 4.0f), Point(7.0f, 4.0f), // continue on next string
            Point(9.0f, 4.0f), Point(11.0f, 4.0f), Point(13.0f, 4.0f), Point(15.0f, 4.0f)
        )
    }

    private val expectedLines by lazy {
        listOf(

            Line(Point(8.0f, 1.0f), Point(4.0f, 2.0f)),

            Line(Point(8.0f, 1.0f), Point(12.0f, 2.0f)),

            Line(Point(4.0f, 2.0f), Point(2.0f, 3.0f)),
            Line(Point(4.0f, 2.0f), Point(6.0f, 3.0f)),

            Line(Point(12.0f, 2.0f), Point(10.0f, 3.0f)),
            Line(Point(12.0f, 2.0f), Point(14.0f, 3.0f)),

            Line(Point(2.0f, 3.0f), Point(1.0f, 4.0f)),
            Line(Point(2.0f, 3.0f), Point(3.0f, 4.0f)),

            Line(Point(6.0f, 3.0f), Point(5.0f, 4.0f)),
            Line(Point(6.0f, 3.0f), Point(7.0f, 4.0f)),


            Line(Point(10.0f, 3.0f), Point(9.0f, 4.0f)),
            Line(Point(10.0f, 3.0f), Point(11.0f, 4.0f)),

            Line(Point(14.0f, 3.0f), Point(13.0f, 4.0f)),
            Line(Point(14.0f, 3.0f), Point(15.0f, 4.0f))
        )
    }

    private lateinit var treeHolder: TreeHolder

    @BeforeAll
    fun setup() {
        treeHolder = generateProportionalTree(16, 5, 0.5f, 0.5f)
    }

    @Test
    fun checkTreePointsSize() {
        val points = treeHolder.treeBalls.map { it.point }
        Assertions.assertSame(expectedPoints.size, points.size, "expected size should be the same as point size")
    }

    @Test
    fun checkTreePointsSame() {
        val points = treeHolder.treeBalls.map { it.point }
        Assertions.assertTrue(points.containsAll(expectedPoints), "expected and calculated points should be the same")
    }

    @Test
    fun checkTreePointDifference() {
        treeHolder.treeBalls.forEach {
            Assertions.assertTrue(expectedPoints.contains(it.point), "expected point don't contains $it")
        }
    }

    @Test
    fun checkTreeLinesSize() {
        val lines = treeHolder.treeLines
        Assertions.assertSame(expectedLines.size, lines.size, "expected size should be the same as lines size")
    }

    @Test
    fun checkTreeLinesSame() {
        val lines = treeHolder.treeLines
        Assertions.assertTrue(lines.containsAll(expectedLines), "expected and calculated points should be the same")
    }

    @Test
    fun checkTreeLinesDifference() {
        treeHolder.treeLines.forEach {
            Assertions.assertTrue(expectedLines.contains(it), "expected point don't contains $it")
        }
    }
}