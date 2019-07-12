package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.utils.Plurals
import ru.skillbranch.devintensive.utils.Utils
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = SECOND*60
const val HOUR = MINUTE*60
const val DAY = HOUR*24

fun Date.format (pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern,Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add (value:Int, units: TimeUnits = TimeUnits.SECOND):Date {

    var time = this.time

    time += when(units){
        TimeUnits.SECOND -> value* SECOND
        TimeUnits.MINUTE -> value* MINUTE
        TimeUnits.HOUR -> value* HOUR
        TimeUnits.DAY -> value* DAY
            }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()):String {

        val time = date.time
        val diffSec = if(time>getTime()){(time - getTime())/1000}else{(time-getTime())/1000-1}
        val diffMin = diffSec/60
        val diffHour = diffMin/60
        val diffDay = diffHour/24
    //println (diffMin)

    if (abs(diffSec.toInt()) in 1..75){
        if (diffSec in 0..1) return "только что"
        if (diffSec in 1..45) return "несколько секунд назад"
        if (diffSec in 45..75) return "минуту назад"
            //  when {
            //diffSec > 0 -> return Utils.humaSec(diffSec,"назад","")
            //diffSec < 0 -> return Utils.humaSec(abs(diffSec),"","через")
        //}
    }

    if (abs(diffMin.toInt()) in 1..75){
        if (diffMin in 46..75) return "час назад"
        when {
            diffMin > 0 -> return Utils.humaMin(diffMin," назад","")
            diffMin < 0 -> return Utils.humaMin(abs(diffMin),"","через ")
        }
    }

    if (abs(diffHour.toInt()) in 1..26){
        if (diffHour in 22..26) return "день назад"
        if (diffHour in 1..22) {

            when {
                diffHour > 0 -> return Utils.humaHour(diffHour, " назад", "")
                diffHour < 0 -> return Utils.humaHour(abs(diffHour), "", "через ")
            }
        }
    }

    if (abs(diffDay)>0){
        when{
            diffDay >= 361 -> return "более года назад"
            diffDay <= -361 -> return "более чем через год"
            else -> if (diffDay>0){return Utils.humaDay(diffDay," назад","")}else
            {return Utils.humaDay(abs(diffDay),"","через ")}
        }
    }







    return "hahaha"
}


enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int): String {

    return Plurals.pushPlural(value,this)
    }
}

