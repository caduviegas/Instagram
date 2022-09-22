package com.innaval.instagram.splash.data

interface SplashDataSource {
    fun session(callback: SplashCallback)
}