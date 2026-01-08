package org.example.projectC

import io.github.oshai.kotlinlogging.KotlinLogging

private val log = KotlinLogging.logger {}

fun loggingTestProjectC() {
    println("Hello world from project C module!")
    log.info { "Info from project C module!" }
    log.debug { "Debug from project C module!" }
    log.error { "Error from project C module!" }
    log.trace { "Trace world from project C module!" }
    try {
        throw IllegalStateException("test with IllegalStateException")
    } catch (t: Throwable) {
        log.error(t) { "Error with throwable from project C module!" }
    }
}
