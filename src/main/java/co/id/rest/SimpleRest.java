package co.id.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRest {
    /**
     * Untuk Test Run Spring Boot pertama kali
     */
    @RequestMapping("/")
    String index(){
        return "Rest Spring Boot Running";
    }
}