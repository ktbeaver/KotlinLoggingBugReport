package org.example.projectB

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.projectC.loggingTestProjectC

private val log = KotlinLogging.logger {}

fun loggingTestProjectB() {
    println("Hello world from project B module!")
    log.info { "Info from project B module!" }
    log.debug { "Debug from project B module!" }
    log.error { "Error from project B module!" }
    log.trace { "Trace world from project B module!" }
    try {
        throw IllegalStateException("test with IllegalStateException in Module B")
    } catch (t: Throwable) {
        log.error(t) { "Error with throwable from project B module!" }
    }
}

fun loggingTestProjectBCallsProjectC() {
    println("Project B is calling C")
    loggingTestProjectC()
}
