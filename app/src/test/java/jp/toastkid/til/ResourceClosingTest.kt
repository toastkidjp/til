/*
 * Copyright (c) 2018 toastkidjp.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html.
 */
package jp.toastkid.til

import io.reactivex.Single
import okio.Okio
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException
import java.io.InputStream

/**
 * @author toastkidjp
 */
class ResourceClosingTest {

    private lateinit var inputStream: InputStream

    @BeforeEach
    fun setUp() {
        inputStream = javaClass.classLoader.getResourceAsStream("text/sample.txt")
    }

    @Test
    fun test_try_finally() {
        try {
            println(Okio.buffer(Okio.source(inputStream)).readUtf8())
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        Assertions.assertThrows(
                IOException::class.java,
                { inputStream.read(ByteArray(1), 0, 1) }
        )
    }

    @Test
    fun test_use() {
        val text: String = inputStream.use { Okio.buffer(Okio.source(it)).readUtf8() }
        println(text)
        Assertions.assertThrows(
                IOException::class.java,
                { inputStream.read(ByteArray(1), 0, 1) }
        )
    }

    @Test
    fun test_using() {
        val text = Single.using<String, InputStream>(
                { inputStream },
                { Single.just<String>(Okio.buffer(Okio.source(it)).readUtf8()) },
                { it.close() }
        ).blockingGet()

        println(text)

        Assertions.assertThrows(
                IOException::class.java,
                { inputStream.read(ByteArray(1), 0, 1) }
        )
    }
}