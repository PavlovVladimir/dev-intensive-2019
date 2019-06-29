package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView():UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials =Utils.toInintials(firstName,lastName)
    val status = if (lastVisit==null)"Еще ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initial = initials,
        status = status)
}

