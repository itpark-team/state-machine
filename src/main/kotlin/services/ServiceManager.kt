package org.example.services

import org.example.statemachine.State
import org.example.statemachine.TransmittedData
import java.util.HashMap

class ServiceManager {
    private val methods: MutableMap<State, (textData: String, transmittedData: TransmittedData) -> String> = HashMap()
    private val menuLogic: MenuLogic = MenuLogic()
    private val userLogic: UserLogic = UserLogic()


    constructor() {
        methods[State.MAIN_MENU] = menuLogic::processMainMenu
        methods[State.USER_PROFILE] = menuLogic::processUserProfile
        methods[State.USER_PROFILE_UPDATE_INFO] = userLogic::processUserProfileUpdateInfo
        methods[State.SHOPPING_CART] = menuLogic::processShoppingCart
    }

    fun processMenuPoint(textData: String, transmittedData: TransmittedData): String {
        return methods[transmittedData.state]?.invoke(textData, transmittedData) ?: throw Exception("wrong key")
    }
}