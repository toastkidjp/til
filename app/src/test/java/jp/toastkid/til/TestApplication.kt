package jp.toastkid.til

import android.app.Application
import org.robolectric.TestLifecycleApplication
import java.lang.reflect.Method

/**
 * @author toastkidjp
 */
class TestApplication: Application(), TestLifecycleApplication {
    override fun beforeTest(method: Method?) = Unit

    override fun prepareTest(test: Any?) = Unit

    override fun afterTest(method: Method?) = Unit
}