package com.target.interview.poc.commentmoderator.resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by m0m0180 on 8/15/18.
 */
@RestController
@EnableAutoConfiguration
public class HelloWorld {

    @RequestMapping(path = "helloworld")
    public String sayHello()
    {
        return "Hello";
    }

}
