package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.R.attr.top
import android.R.attr.bottom
import android.graphics.Rect
import android.opengl.ETC1.getHeight
import android.util.Log


fun Activity.hideKeyboard()  {
    val view = this.currentFocus
    view?.let { v ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.let { it.hideSoftInputFromWindow(v.windowToken, 0) }
    }
}

fun Activity.isKeyboardOpen ():Boolean {
    val r = Rect()
    val rootview = this.getWindow().getDecorView()
    rootview.getWindowVisibleDisplayFrame(r)

    val keyboardHeight = rootview.getHeight()- r.bottom
   // val heightDifference = screenHeight - (r.bottom - r.top)
    Log.d("M_Activity","$keyboardHeight")
    Log.d("M_Activity","${keyboardHeight!==0}")
    return keyboardHeight!==0
}


fun Activity.isKeyboardClosed () = !isKeyboardOpen()