package ru.skillbranch.devintensive.models

import android.util.Log

class Bender (var status:Status=Status.NORMAL, var question: Question=Question.NAME){

    var positiveTmer :  Int = 1
    var negativeTimer : Int = 1
    var regex = Regex(pattern = "a")


    fun askQuestion():String = when (question){
                Question.NAME -> Question.NAME.question
                Question.PROFESSION -> Question.PROFESSION.question
                Question.MATERIAL -> Question.MATERIAL.question
                Question.BDAY -> Question.BDAY.question
                Question.SERIAL -> Question.SERIAL.question
                Question.IDLE -> Question.IDLE.question


    }

    fun listenAnswer (answer:String) : Pair<String,Triple<Int,Int,Int>>{

        if (positiveTmer == 6) {
            positiveTmer = 1
            status = Status.NORMAL
            question = Question.IDLE
            return "Отлично - ты справился\n${question.question}" to status.color
        }
        if (negativeTimer ==4) {
            negativeTimer = 1
            status = Status.NORMAL
            question = Question.NAME
            return "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
        }

        when (question){

            Question.NAME       -> {
                regex = Regex(pattern = "^[А-ЯA-Z]")

                if (!(regex.containsMatchIn(input = answer))) return "Имя должно начинаться с заглавной буквы\n" +
                        "${question.question}" to status.color
            }

            Question.PROFESSION -> {
                regex = Regex(pattern = "^[А-ЯA-Z]")
                if (regex.containsMatchIn(input = answer)) return "Профессия должна начинаться со строчной буквы\n" +
                        "${question.question}" to status.color
            }

            Question.MATERIAL   -> {
                regex = Regex(pattern = "\\d")
                if (regex.containsMatchIn(input = answer)) return "Материал не должен содержать цифр\n" +
                        "${question.question}" to status.color
            }

            Question.BDAY       -> {
                regex = Regex(pattern = "\\D")
                if (regex.containsMatchIn(input = answer)) return "Год моего рождения должен содержать только цифры\n" +
                        "${question.question}" to status.color
            }

            Question.SERIAL     ->{
                regex = Regex(pattern = "\\D")
                if ((regex.containsMatchIn(input = answer))or (answer.length !== 7)) {

                    return "Серийный номер содержит только цифры, и их 7\n" +
                        "${question.question}" to status.color}
            }

        }

        return if (question.answers.contains(answer)){
            positiveTmer ++
            question = question.nextQuestion()
            "Отлично, ты справился\n${question.question}" to status.color
        }else{
            negativeTimer ++
            status = status.nextStatus()
            "Это не правильный ответ!\n${question.question}" to status.color

        }

    }



    enum class Status (val color:Triple<Int, Int, Int>){
        NORMAL (Triple(255,255,255)),
        WARNING (Triple(255,120,0)),
        DANGER (Triple(255,60,60)),
        CRITICAL (Triple(255,0,0));


        fun nextStatus() : Status {
            return if (this.ordinal<values().lastIndex){
                values()[this.ordinal +1]
            }else{
                values()[0]
            }
        }

    }

    enum class Question (val question: String, val answers:List<String>){
        NAME("Как меня зовут?", listOf("Бендер","Bender")) {
            override fun nextQuestion(): Question = PROFESSION },

        PROFESSION ("Назови мою профессию?", listOf("сгибальщик","bender")){
            override fun nextQuestion(): Question = MATERIAL },

        MATERIAL ("Из чего я сделан?", listOf("металл","дерево","metal","iron","wood")){
            override fun nextQuestion(): Question = BDAY },

        BDAY ("Когда меня создали?", listOf("2993")){
            override fun nextQuestion(): Question = SERIAL },

        SERIAL ("Мой серийный номер?", listOf("2716057")){
            override fun nextQuestion(): Question = IDLE},

        IDLE ("На этом все, вопросов больше нет", listOf()){
            override fun nextQuestion(): Question = IDLE };

        abstract fun nextQuestion() : Question

    }

}