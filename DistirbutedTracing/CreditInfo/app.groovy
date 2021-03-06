@Grab("org.springframework.kafka:spring-kafka:1.1.1.RELEASE")
@Grab("org.springframework.integration:spring-integration-kafka:2.1.0.RELEASE")
@Grab("org.apache.kafka:kafka_2.11:0.10.0.0")
@GrabExclude("org.slf4j:slf4j-log4j12")
@Grab("spring-cloud-starter-bus-kafka")
@Grab("spring-cloud-sleuth-stream")
@Grab("spring-cloud-starter-consul-discovery")

@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
@Log
class Application {


    int credit = 700

    @RequestMapping(value = "/credit", produces = "application/json")
    String getCredit() {
        credit = 1000 * Math.random()
        log.info("Produced a value: ${credit}")

        "{\"value\": ${credit}}"
    }
}