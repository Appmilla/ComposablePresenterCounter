package appmilla.composablepresenter.counter.app

import android.app.Application
import di.androidModule
import di.commonInitKoin

class CounterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        commonInitKoin(platformSpecific = androidModule)
    }
}
