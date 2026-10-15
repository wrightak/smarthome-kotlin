package org.example

import org.example.org.example.B9000
import org.example.org.example.Bulb
import org.example.org.example.S9000
import org.example.org.example.Smarthome

fun main() {
    val smarthome = Smarthome()
    smarthome.run(B9000(), S9000())
}