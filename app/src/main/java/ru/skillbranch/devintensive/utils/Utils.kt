package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName (fullName:String?):Pair<String?, String?> {
        //TODO FIXME!!!
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
//        return Pair(firstName, fullName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
//TODO make IT!!!
    }

    fun toInintials(firstName: String?, lastName: String?): String? {
//TODO make IT!!!
    }
}