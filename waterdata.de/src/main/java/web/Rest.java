package web;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/measure/start")
    public function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new function(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/measure/stop")
    public function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new function(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/request/value/temp")
    public function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new function(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/request/value/ph")
    public function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new function(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/request/value/presure")
    public function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new function(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/request/value/humidity")
    public function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new function(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/request/value/tempdiff")
    public function greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new function(counter.incrementAndGet(),
                String.format(template, name));
    }
}