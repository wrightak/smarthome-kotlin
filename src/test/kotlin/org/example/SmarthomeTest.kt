package org.example

import org.example.org.example.Bulb
import org.example.org.example.Smarthome
import org.example.org.example.Switch
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class SmarthomeTest {
    @Test
    fun `Switchがオンの時に、電球がつく`() {
        val smarthome = Smarthome()
        val spyBulb = SpyBulb()
        val alwaysOnSwitch = AlwaysOnSwitch()

        smarthome.run(spyBulb, alwaysOnSwitch)

        assertTrue(spyBulb.turnOnWasCalled)
        assertFalse(spyBulb.turnOffWasCalled)
    }

    @Test
    fun `switchがオフの時に、電球が消える`() {
        val smarthome = Smarthome()
        val spyBulb = SpyBulb()
        val alwaysOffSwitch = AlwaysOffSwitch()

        smarthome.run(spyBulb, alwaysOffSwitch)

        assertFalse(spyBulb.turnOnWasCalled)
        assertTrue(spyBulb.turnOffWasCalled)
    }
}

class SpyBulb : Bulb {
    var turnOnWasCalled = false
    var turnOffWasCalled = false

    override fun turnOn() {
        turnOnWasCalled = true
    }

    override fun turnOff() {
        turnOffWasCalled = true
    }
}

class AlwaysOnSwitch : Switch {
    override fun isOn(): Boolean {
        return true
    }
}

class AlwaysOffSwitch : Switch {
    override fun isOn(): Boolean {
        return false
    }
}
