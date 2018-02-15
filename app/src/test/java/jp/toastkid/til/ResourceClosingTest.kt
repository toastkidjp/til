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
            inputStream.let { nonNullInputStream ->
                 println(Okio.buffer(Okio.source(nonNullInputStream)).readUtf8())
            }
        } finally {
            inputStream.close()
        }

        Assertions.assertThrows(
                IOException::class.java,
                { inputStream.read(ByteArray(1), 0, 1) }
        )
    }

    @Test
    fun test_use() {
        inputStream.let { nonNullInputStream ->
            Okio.source(nonNullInputStream).use { println(Okio.buffer(it).readUtf8()) }
            Assertions.assertThrows(
                    IOException::class.java,
                    { nonNullInputStream.read(ByteArray(1), 0, 1) }
            )
        }
    }

    @Test
    fun test_using() {
        inputStream.let { nonNullInputStream ->
            val text = Single.using<String, InputStream>(
                    { nonNullInputStream },
                    { Single.just<String>(Okio.buffer(Okio.source(it)).readUtf8()) },
                    { it.close() }
            )
                    .blockingGet()
            println(text)
            Assertions.assertThrows(
                    IOException::class.java,
                    { nonNullInputStream.read(ByteArray(1), 0, 1) }
            )
        }
    }
}