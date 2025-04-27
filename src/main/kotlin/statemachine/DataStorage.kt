package org.example.statemachine

import java.util.HashMap

class DataStorage {
    private val data: MutableMap<String, Any> = HashMap()

    fun add(key: String, value: Any) {
        data[key] = value
    }

    fun get(key: String): Any? {
        return data[key]
    }

    fun delete(key: String) {
        data.remove(key)
    }

    fun clear() {
        data.clear()
    }
}