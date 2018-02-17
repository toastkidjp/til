/*
 * Copyright (c) 2018 toastkidjp.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html.
 */
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