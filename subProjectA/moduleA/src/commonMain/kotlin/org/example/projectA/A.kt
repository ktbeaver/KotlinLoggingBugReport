package org.example.projectA

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.projectB.loggingTestProjectB
import org.example.projectB.loggingTestProjectBCallsProjectC
import org.example.projectC.loggingTestProjectC

private val log = KotlinLogging.logger {}

fun loggingTestProjectA() {
    println("Hello world from project A module!")
    log.info { "Info from project A module!" }
    log.debug { "Debug from project A module!" }
    log.error { "Error from project A module!" }
    log.trace { "Trace world from project A module!" }
    try {
        throw IllegalStateException("test with IllegalStateException in module A")
    } catch (t: Throwable) {
        log.error(t) { "Error with throwable from project A module!" }
    }
}

fun loggingTestProjectACallsProjectB() {
    println("Project A is calling B")
    loggingTestProjectB()
}

fun loggingTestProjectACallsProjectC() {
    println("Project A is calling C")
    loggingTestProjectC()
}

fun loggingTestProjectACallsProjectCViaB() {
    println("Project A is calling C via B")
    loggingTestProjectBCallsProjectC()
}
