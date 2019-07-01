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
        val str2Translit = payload.toString()
        var result:String=""
        val divider = divider

        for (i in str2Translit.indices) result += cyr2lat(str2Translit[i])

        return  result.replace(" ",divider)
    }

    fun cyr2lat(c:Char?):String{
        var ch = c.toString()
        when (c){
            'а' -> ch="a"
            'б' -> ch="b"
            'в' -> ch="v"
            'г' -> ch="g"
            'д' -> ch="d"
            'е' -> ch="e"
            'ё' -> ch="e"
            'ж' -> ch="zh"
            'з' -> ch="z"
            'и' -> ch="i"
            'й' -> ch="i"
            'к' -> ch="k"
            'л' -> ch="l"
            'м' -> ch="m"
            'н' -> ch="n"
            'о' -> ch="o"
            'п' -> ch="p"
            'р' -> ch="r"
            'с' -> ch="s"
            'т' -> ch="t"
            'у' -> ch="u"
            'ф' -> ch="f"
            'х' -> ch="h"
            'ц' -> ch="c"
            'ч' -> ch="ch"
            'ш' -> ch="sh"
            'щ' -> ch="sh"
            'ъ' -> ch=""
            'ы' -> ch="i"
            'ь' -> ch=""
            'э' -> ch="e"
            'ю' -> ch="yu"
            'я' -> ch="ya"
            'А' -> ch="A"
            'Б' -> ch="B"
            'В' -> ch="V"
            'Г' -> ch="G"
            'Д' -> ch="D"
            'Е' -> ch="E"
            'Ё' -> ch="E"
            'Ж' -> ch="Zh"
            'З' -> ch="Z"
            'И' -> ch="I"
            'Й' -> ch="I"
            'К' -> ch="K"
            'Л' -> ch="L"
            'М' -> ch="M"
            'Н' -> ch="N"
            'О' -> ch="O"
            'П' -> ch="P"
            'Р' -> ch="R"
            'С' -> ch="S"
            'Т' -> ch="T"
            'У' -> ch="U"
            'Ф' -> ch="F"
            'Х' -> ch="H"
            'Ц' -> ch="C"
            'Ч' -> ch="Ch"
            'Ш' -> ch="Sh"
            'Щ' -> ch="Sh"
            'Ъ' -> ch=""
            'Ы' -> ch="I"
            'Ь' -> ch=""
            'Э' -> ch="E"
            'Ю' -> ch="Yu"
            'Я' -> ch="Ya"
        }
        return ch
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

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

    fun humaDay(diffT:Long,nazad:String,vpered:String):String{
        val ends = diffT.toString().takeLast(1)

        if (diffT.toString().takeLast(2) in "11".."14") {return "$vpered$diffT дней$nazad"}

        when (ends){
            "1" -> return "$vpered$diffT день$nazad"
            in "2".."4" -> return "$vpered$diffT дня$nazad"
            else -> return "$vpered$diffT дней$nazad"
        }
    }

    fun humaHour(diffT: Long,nazad:String,vpered:String):String{

        val ends = diffT.toString().takeLast(1)
        if (diffT.toString().takeLast(2) in "11".."14") {return "$vpered$diffT часов$nazad"}
        when (ends){
            "1" -> return "$vpered$diffT час$nazad"
            in "2".."4" -> return "$vpered$diffT часа$nazad"
            else -> return "$vpered$diffT часов$nazad"
        }
    }

    fun humaMin (diffT: Long,nazad:String,vpered:String):String{
        val ends = diffT.toString().takeLast(1)
        if (diffT.toString().takeLast(2) in "11".."14") {return "$vpered$diffT минут$nazad"}
        when (ends){
            "1" -> return "$vpered$diffT минуту$nazad"
            in "2".."4" -> return "$vpered$diffT минуты$nazad"
            else -> return "$vpered$diffT минут$nazad"
        }
    }

    fun humaSec (diffT: Long,nazad:String,vpered:String):String{
        val ends = diffT.toString().takeLast(1)
       // if (diffT.toString().takeLast(2) in "11".."14") {return "$vpered $diffT секунд $nazad"}

        when (ends){
            "1" ->  return "$vpered$diffT секунду$nazad"
            in "2".."4" -> return "$vpered$diffT секунды$nazad"
            else -> return "$vpered$diffT секунд$nazad"
        }
    }
}