package test.kool.stream

import kotlin.test.*

import io.kool.stream.*

import org.junit.Test as test

import java.util.*

class TimeWindowTest {

    test fun streamWithWindow() {
        var value = 0.0
        fun value(): Double {
            value += 0.1
            return value
        }

        val stream = SimpleStream<Double>()
        // TODO compile error if you miss out this type
        val window: Stream<List<Double>> = stream.timeWindow(1000)
        window.take(9).open { println("Has window of $it") }

        for (i in 0.upto(10)) {
            stream.onNext(value())
            stream.onNext(value())
            Thread.sleep(800)
        }

        Thread.sleep(1000)
    }
}