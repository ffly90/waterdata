package web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/measure/start")

    @RequestMapping("/measure/stop")

    @RequestMapping("/request/value/temp")

    @RequestMapping("/request/value/ph")

    @RequestMapping("/request/value/presure")

    @RequestMapping("/request/value/humidity")

    @RequestMapping("/request/value/tempdiff")
    public Function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Function(counter.incrementAndGet(),
                String.format(template, name));
    }
}