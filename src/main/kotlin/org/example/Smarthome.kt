package org.example.org.example

interface Switch {
    fun isOn(): Boolean
}

interface Bulb {
    fun turnOn()
    fun turnOff()
}

class Smarthome {
    fun run(bulb: Bulb, switch: Switch) {
        if (switch.isOn()) {
            bulb.turnOn()
        } else {
            bulb.turnOff()
        }
    }
}
