package org.example

import org.example.services.ServiceManager
import org.example.statemachine.State
import org.example.statemachine.TransmittedData
import kotlin.system.exitProcess

fun main() {
//    val serviceManager = ServiceManager()
//    val transmittedData = TransmittedData()
//
//    var textData = ""
//    var currentMenu = Views.mainMenuPoints
//
//    while (true) {
//        println(currentMenu)
//
//        textData = readln()
//
//        currentMenu = serviceManager.processMenuPoint(textData, transmittedData)
//    }

    var currentState = State.MAIN_MENU
    var textData = ""

    println(Views.mainMenuPoints)

    while (true) {
        when (currentState) {
            State.MAIN_MENU -> {
                textData = readln()

                if (textData.equals("1")) {
                    currentState = State.USER_PROFILE
                    println(Views.userProfilePoints)
                } else if (textData.equals("2")) {
                    currentState = State.SHOPPING_CART
                    println(Views.shoppingCartPoints)
                } else if (textData.equals("3")) {
                    exitProcess(0)
                } else {
                    println("Пункт не найден, вы остались на главном меню\n\n" + Views.mainMenuPoints)
                }
            }

            State.USER_PROFILE -> {
                textData = readln()

                if (textData.equals("1")) {
                    println("Данные пользователя\n\nНовое меню")
                    //новый стейт
                } else if (textData.equals("2")) {
                    currentState = State.USER_PROFILE_UPDATE_INFO
                    println("Обновление данных пользователя")
                } else if (textData.equals("3")) {
                    currentState = State.MAIN_MENU
                    println(Views.mainMenuPoints)
                } else {
                    println("Пункт не найден, вы остались на профиле пользователя\n\n" + Views.userProfilePoints)
                }
            }

            State.USER_PROFILE_UPDATE_INFO -> {

            }

            State.SHOPPING_CART -> {

            }
        }
    }

}