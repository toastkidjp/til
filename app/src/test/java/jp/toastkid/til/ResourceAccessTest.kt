package jp.toastkid.til

import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

/**
 * @author toastkidjp
 */
@RunWith(RobolectricTestRunner::class)
class ResourceAccessTest {

    @Test
    fun test() {
        val message = RuntimeEnvironment.application.getString(R.string.app_name)
        println(message)
        assertNotNull(message)
    }
}