package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName (fullName:String?):Pair<String?, String?> {
        //TODO FIXME!!!
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName  = parts?.getOrNull(1)

        if (firstName?.length == 0) firstName=null
        if (lastName?.length == 0)  lastName=null
//        return Pair(firstName, fullName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
//TODO make IT!!!
        return "translit"
    }

    fun toInintials(firstName: String?, lastName: String?): String? {
//TODO make IT!!!
        val firstLetter   = firstName?.getOrNull(0)//.toString().toUpperCase()
        val secondLetter  = lastName?.getOrNull(0)//.toString().toUpperCase()
        var initials:String? = null


        when (firstLetter){
          in 'a'..'z' -> initials = firstLetter.toString().toUpperCase()
          in 'A'..'Z' ->initials = firstLetter.toString()
            else -> {when (secondLetter){
                in 'a'..'z' -> return secondLetter.toString().toUpperCase()
                in 'A'..'Z' -> return secondLetter.toString()
                else -> return null
            }}
        }

        when (secondLetter){
            in 'a'..'z' -> initials = initials + secondLetter.toString().toUpperCase()
            in 'A'..'Z'  -> initials = initials + secondLetter.toString()
            else -> return initials
        }

        return initials
    }
}