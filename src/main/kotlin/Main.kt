package org.example

import org.example.services.ServiceManager
import org.example.statemachine.TransmittedData

fun main() {
    val serviceManager = ServiceManager()
    val transmittedData = TransmittedData()

    var textData = ""
    var currentMenu = Views.mainMenuPoints

    while (true) {
        println(currentMenu)

        textData = readln()

        currentMenu = serviceManager.processMenuPoint(textData, transmittedData)
    }



}