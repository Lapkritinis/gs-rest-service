package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @DeleteMapping(value = "/greeting")
    public Greeting notWorking(@RequestParam(value="name") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @GetMapping(value = "/greeting")
    public Greeting working(@RequestParam(value="name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
