package io.pivotal.monitoring.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UnstableController {
    val quizScores = hashMapOf("Mark" to 100, "Brad" to 85, "Jordan" to 70)

    @GetMapping("/api/data/eventually")
    fun getDataEventually(): Map<String, Int> {
        if (unlucky()) tenSecondPenalty()
        return quizScores
    }

    @GetMapping("/api/data/maybe")
    fun getDataMaybe(): Map<String, Int> {
        if (unlucky()) blowUp()
        return quizScores
    }
}
