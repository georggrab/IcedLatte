package apps.gjg.io.icedlatte

import android.app.Application
import com.facebook.stetho.Stetho

class IcedLatteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
