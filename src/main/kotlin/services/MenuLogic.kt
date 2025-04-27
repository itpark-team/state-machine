package org.example.services

import org.example.Views
import org.example.entities.User
import org.example.statemachine.State
import org.example.statemachine.TransmittedData
import kotlin.system.exitProcess

class MenuLogic {
    fun processMainMenu(textData: String, transmittedData: TransmittedData): String {

        if (textData.equals("1")) {
            transmittedData.state = State.USER_PROFILE
            return Views.userProfilePoints
        } else if (textData.equals("2")) {
            transmittedData.state = State.SHOPPING_CART
            return Views.shoppingCartPoints
        } else if (textData.equals("3")) {
            exitProcess(0)
        } else {
            return "Пункт не найден, вы остались на главном меню\n\n" + Views.mainMenuPoints
        }


    }

    fun processUserProfile(textData: String, transmittedData: TransmittedData): String {
        if (textData.equals("1")) {
            return "Данные пользователя\n\nНовое меню"
            //новый стейт
        } else if (textData.equals("2")) {
            transmittedData.state = State.USER_PROFILE_UPDATE_INFO
            return "Обновление данных пользователя"
        } else if (textData.equals("3")) {
            transmittedData.state = State.MAIN_MENU
            return Views.mainMenuPoints
        } else {
            return "Пункт не найден, вы остались на профиле пользователя\n\n" + Views.userProfilePoints
        }
    }

    fun processShoppingCart(textData: String, transmittedData: TransmittedData): String {

        val user = transmittedData.dataStorage.get("user") as User

        println(user)

        transmittedData.state = State.MAIN_MENU
        return Views.mainMenuPoints
    }
}