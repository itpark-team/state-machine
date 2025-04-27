package org.example.services

import org.example.Views
import org.example.entities.User
import org.example.statemachine.State
import org.example.statemachine.TransmittedData

class UserLogic {
    fun processUserProfileUpdateInfo(textData: String, transmittedData: TransmittedData): String {

        println("Введите новое имя:")
        val name = readln()

        println("Введите новый возраст:")
        val age = readln().toInt()

        val user = User(name, age)

        transmittedData.dataStorage.add("user", user)

        println("пользователь запомнен")

        transmittedData.state = State.MAIN_MENU
        return Views.mainMenuPoints
    }
}