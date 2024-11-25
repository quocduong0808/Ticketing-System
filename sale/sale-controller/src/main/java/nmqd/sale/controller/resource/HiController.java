package nmqd.sale.controller.resource;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import nmqd.sale.application.service.event.EventAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class HiController {

    @Autowired
    private EventAppService eventAppService;

    @RateLimiter(name = "backendA",fallbackMethod = "fallbackRareLimit")
    @GetMapping("/hi")
    public String hi(){
        log.info("Go to controller");
        return eventAppService.sayHi();
    }

    public String fallbackRareLimit(Throwable throwable){
        log.info(throwable.getMessage());
        return "Too many request !!!";
    }

    @GetMapping("/call")
    @CircuitBreaker(name = "backendB",fallbackMethod = "fallbackCircuit")
    public String call() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/todos/" + new Random().nextInt(10);
        return restTemplate.getForObject(url,String.class);
    }

    public String fallbackCircuit(Throwable throwable){
        log.info(throwable.getMessage());
        return "Service unavailable !!!";
    }

}
