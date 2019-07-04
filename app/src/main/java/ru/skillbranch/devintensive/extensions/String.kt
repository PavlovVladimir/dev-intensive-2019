package ru.skillbranch.devintensive.extensions


    fun String.truncate(value: Int = 16): String {

        val str : String = this.trim()

            if (str.length <= value) return str else return "${str.take(value).trimEnd()}..."

    }


    fun String.stripHtml(): String {

        val spaces = Regex(" {2,}")
        val htmltags = Regex("(<.*?>)|(&[^ а-я]{1,4}?;)")

            return this.replace(htmltags, "").replace(spaces, " ")
    }