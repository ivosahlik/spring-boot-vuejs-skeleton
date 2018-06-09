package cz.ivosahlik.controller;

import cz.ivosahlik.model.Message;
import cz.ivosahlik.service.BackendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Intellij Idea
 * Created by ivosahlik on 08/06/2018
 */

@Slf4j
@RestController()
@RequestMapping("/api")
public class BackendController {

    @Autowired
    private BackendService backendService;

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    public static final String SORRY_TEXT = "Sorry from Spring Boot Backend!";

    @GetMapping(path = "/helloaxios")
    public @ResponseBody String sayHelloAxios() {
        log.info("GET called on /helloaxios resource");
        return HELLO_TEXT;
    }

    @CrossOrigin
    @GetMapping(path = "/hellohttp")
    public @ResponseBody String saySorryHttp() {
        log.info("GET called on /hellohttp resource");
        return SORRY_TEXT;
    }

    @CrossOrigin
    @GetMapping("/test")
    public List<Message> test() {
        backendService.saveMessage();
        return backendService.listMessages();
    }

}
