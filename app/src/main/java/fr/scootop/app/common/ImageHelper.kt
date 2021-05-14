package fr.scootop.app.common

import fr.scootop.BuildConfig

/**
 * Created by ludovicriviere on 04/03/2018.
 */
object ImageHelper {

    private val IMG_USERS_PATH = "/images/users"

    fun getUserAvatarUrl(fileName: String): String {
        return BuildConfig.SC_BASE_API + IMG_USERS_PATH + "/" + fileName
    }
}
