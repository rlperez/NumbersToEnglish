package edu.rlperez

import org.junit.Test
import kotlin.test.assertEquals

class NumbersToEnglishTest {
    @Test
    fun singleDigitTest() {
        val converter = NumbersToEnglish()
        assertEquals("one", converter.convert(1))
    }

    @Test
    fun doubleDigitTest() {
        val converter = NumbersToEnglish()
        assertEquals("ten", converter.convert(10))
        assertEquals("twelve", converter.convert(12))
        assertEquals("nineteen", converter.convert(19))
    }

    @Test
    fun hundredsDigitTest() {
        val converter = NumbersToEnglish()
        assertEquals("five hundred twenty three", converter.convert(523))
    }

    @Test
    fun thousandsDigitTest() {
        val converter = NumbersToEnglish()
        assertEquals("nine thousand nine hundred twenty three", converter.convert(9923))
    }

}
