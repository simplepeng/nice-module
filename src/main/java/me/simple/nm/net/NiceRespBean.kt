package me.simple.nm.net

import androidx.annotation.Keep

@Keep
abstract class NiceRespBean {

//    abstract fun isSuccessful(): Boolean

    abstract fun isDefeated(): Boolean

    abstract fun dataIsNullOrEmpty()
}