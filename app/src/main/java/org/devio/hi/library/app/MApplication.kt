package org.devio.hi.library.app

import android.app.Application
import com.google.gson.Gson
import org.devio.hi.library.hilibrary.log.HiConsolePrinter
import org.devio.hi.library.hilibrary.log.HiLogConfig
import org.devio.hi.library.hilibrary.log.HiLogManager

class MApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(object : HiLogConfig() {
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun getGlobalTag(): String {
                return "Application"
            }

            override fun enable(): Boolean {
                return true
            }
        }, HiConsolePrinter())
    }
}