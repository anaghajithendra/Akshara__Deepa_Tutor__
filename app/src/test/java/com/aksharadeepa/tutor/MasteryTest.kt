package com.aksharadeepa.tutor

import org.junit.Assert.assertEquals
import org.junit.Test

class MasteryTest {
    @Test
    fun scoreBandsMapToExpectedMastery() {
        assertEquals(MasteryLevel.RED, levelFor(39))
        assertEquals(MasteryLevel.AMBER, levelFor(40))
        assertEquals(MasteryLevel.GREEN, levelFor(70))
    }
}
