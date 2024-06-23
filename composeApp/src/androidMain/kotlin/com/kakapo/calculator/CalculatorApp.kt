package com.kakapo.calculator

import android.app.Application
import com.kakapo.calculator.di.appModule
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class CalculatorApp: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            modules(appModule)
        }
        Napier.base(DebugAntilog())
    }
}