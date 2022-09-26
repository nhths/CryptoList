package io.github.nhths.cryptolist

import android.app.Application
import io.github.nhths.cryptolist.App.AppStore.app

class App : Application() {

    object AppStore{
        lateinit var app: App
    }

    init {
        app = this
    }
}