package com.example.eventerplanner.ui

import android.app.Application
import com.example.eventerplanner.di.DaggerApplicationComponent

class App : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}