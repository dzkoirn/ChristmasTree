package by.dzkoirn.graphic.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimitivesTest {

    @ExperimentalUnsignedTypes
    @Test
    fun checkRgbColor() {
        val color = Color(0xFFAABBCC.toUInt())
        assertEquals(0xFFu.toUByte(), color.alpha, "alpha is 0xFF")
        assertEquals(0xAAu.toUByte(), color.r, "red is 0xAA")
        assertEquals(0xBBu.toUByte(), color.g, "green is 0xBB")
        assertEquals(0xCCu.toUByte(), color.b, "blue is 0xCC")
    }
}