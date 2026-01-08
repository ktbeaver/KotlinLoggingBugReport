package org.example.bugreport

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.projectA.loggingTestProjectA
import org.example.projectA.loggingTestProjectACallsProjectB
import org.example.projectA.loggingTestProjectACallsProjectC
import org.example.projectA.loggingTestProjectACallsProjectCViaB
import org.example.projectB.loggingTestProjectB
import org.example.projectB.loggingTestProjectBCallsProjectC
import org.example.projectC.loggingTestProjectC
import org.example.shared.loggingTestShared
import org.example.shared.loggingTestSharedCallsProjectA
import org.example.shared.loggingTestSharedCallsProjectB
import org.example.shared.loggingTestSharedCallsProjectC
import org.example.shared.loggingTestSharedCallsProjectCViaB

class Greeting {
    private val log = KotlinLogging.logger {}

    fun greet(): String {
        loggingTest()

        // shared features
        loggingTestShared()
        loggingTestSharedCallsProjectA()
        loggingTestSharedCallsProjectB()
        loggingTestSharedCallsProjectC()
        loggingTestSharedCallsProjectCViaB()

        // project A features
        loggingTestProjectA()
        loggingTestProjectACallsProjectB()
        loggingTestProjectACallsProjectC()
        loggingTestProjectACallsProjectCViaB()

        // project B features
        loggingTestProjectB()
        loggingTestProjectBCallsProjectC()

        // project C features
        loggingTestProjectC()

        return "Hello, world"
    }

    fun loggingTest() {
        println("Hello World from ComposeApp!")
        log.info { "Info from ComposeApp module!" }
        log.debug { "Debug from ComposeApp module!" }
        log.trace { "Trace from ComposeApp module!" }
        log.error { "Error from ComposeApp module!" }
        try {
            throw IllegalStateException("test with IllegalStateException in module ComposeApp")
        } catch (t: Throwable) {
            log.error(t) { "Error with throwable from ComposeApp module!" }
        }
    }
}
