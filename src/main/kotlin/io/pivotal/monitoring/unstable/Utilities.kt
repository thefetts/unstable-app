package io.pivotal.monitoring.unstable

import java.util.*

fun unlucky(): Boolean =
    (0..10).random() < 7

fun ClosedRange<Int>.random() =
    Random().nextInt((endInclusive + 1) - start) + start

fun tenSecondPenalty() =
    Thread.sleep(10_000)

fun blowUp(): Nothing =
    throw RuntimeException("You are unlucky my friend.")
