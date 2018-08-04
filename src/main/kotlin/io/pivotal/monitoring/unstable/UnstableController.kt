package io.pivotal.monitoring.unstable

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UnstableController {
    val quizScores = hashMapOf("Mark" to 100, "Brad" to 85, "Jordan" to 70)

    @Autowired
    private lateinit var registry: MeterRegistry

    @GetMapping("/api/data/eventually")
    fun getDataEventually(): Map<String, Int> {
        val timer = registry.timer("slow.integration.call")
        timer.record({
            if (unlucky()) tenSecondPenalty()
        })
        return quizScores
    }

    @GetMapping("/api/data/maybe")
    fun getDataMaybe(): Map<String, Int> {
        if (unlucky()) blowUp()
        return quizScores
    }

    @GetMapping("/api/data/costly")
    fun getDataWithCustomMetric(): Map<String, Int> {
        val counter = registry.counter("costly.service.call")
        counter.increment()
        return quizScores
    }
}
