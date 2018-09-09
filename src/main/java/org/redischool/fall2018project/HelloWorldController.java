package org.redischool.fall2018project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HelloWorldController {
    @RequestMapping("/")
    public String greet(@RequestParam(value = "name", defaultValue = "World!") String name) {
        return "Hello, " + name;
    }
}
