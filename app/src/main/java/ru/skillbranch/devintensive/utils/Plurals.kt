package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.TimeUnits
import kotlin.math.abs

object Plurals {
    fun pushPlural (value:Int, timeUnits: TimeUnits) : String {
        var str : String = "$value "
        val result = when {
            value in 11..20 -> getMANYplural(timeUnits)
            value in 2..4 -> get2Plural(timeUnits)
            value ==1 -> get1Plural(timeUnits)
            abs(value)%10 == 1 -> get1Plural(timeUnits)
            abs(value)%10 in 2..4 -> get2Plural(timeUnits)
            else -> getMANYplural(timeUnits)
        }
    return str + result

    }
    private fun get1Plural(timeUnits: TimeUnits): String {
        return when (timeUnits) {
            TimeUnits.SECOND -> "секунду"
            TimeUnits.MINUTE -> "минуту"
            TimeUnits.HOUR -> "час"
            TimeUnits.DAY -> "день"
        }
    }

    private fun get2Plural(timeUnits: TimeUnits): String {
        return when (timeUnits) {
            TimeUnits.SECOND -> "секунды"
            TimeUnits.MINUTE -> "минуты"
            TimeUnits.HOUR -> "часа"
            TimeUnits.DAY -> "дня"
        }
    }

    private fun getMANYplural(timeUnits: TimeUnits): String {
        return when (timeUnits) {
            TimeUnits.SECOND -> "секунд"
            TimeUnits.MINUTE -> "минут"
            TimeUnits.HOUR -> "часов"
            TimeUnits.DAY -> "дней"
        }
    }
}