package ru.skillbranch.devintensive

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import ru.skillbranch.devintensive.repositories.PreferencesRepository

class App : Application() {

    companion object {
        private var instance:App? = null
        fun applicationContext () : Context{
            return instance!!.applicationContext
        }
    }

    init {
        instance = this
    }
    override fun onCreate() {


        PreferencesRepository.getAppTheme().also {
            AppCompatDelegate.setDefaultNightMode(it)
        }
        super.onCreate()
//TODO call once when application created
    }
}