package io.pivotal.monitoring.unstable

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UnstableApplication

fun main(args: Array<String>) {
    runApplication<UnstableApplication>(*args)
}
