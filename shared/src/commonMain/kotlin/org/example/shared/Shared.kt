package org.example.shared

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.projectA.loggingTestProjectA
import org.example.projectB.loggingTestProjectB
import org.example.projectB.loggingTestProjectBCallsProjectC
import org.example.projectC.loggingTestProjectC

private val log = KotlinLogging.logger {}

fun loggingTestShared() {
    println("Hello world from Shared module!")
    log.info { "Info from Shared module!" }
    log.debug { "Debug from Shared module!" }
    log.error { "Error from Shared module!" }
    log.trace { "Trace world from Shared module!" }
    try {
        throw IllegalStateException("test with IllegalStateException in module Shared")
    } catch (t: Throwable) {
        log.error(t) { "Error with throwable from Shared module!" }
    }
}

fun loggingTestSharedCallsProjectA() {
    println("Shared is calling A")
    loggingTestProjectA()
}

fun loggingTestSharedCallsProjectB() {
    println("Shared is calling B")
    loggingTestProjectB()
}

fun loggingTestSharedCallsProjectC() {
    println("Shared is calling C")
    loggingTestProjectC()
}

fun loggingTestSharedCallsProjectCViaB() {
    println("Shared is calling C via B")
    loggingTestProjectBCallsProjectC()
}
