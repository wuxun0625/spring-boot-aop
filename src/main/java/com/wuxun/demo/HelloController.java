package com.wuxun.demo;
 
import com.wuxun.demo.aop.testUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    testUtils testUtil;

    @RequestMapping("/hello")
    String home() {
        logger.info("This is log from HelloController!");

        String xxx = "";
        try {
            xxx  = testUtil.testString();
        } catch (Exception e) {
            logger.error("Exception in helloController!");
        }
        logger.info(xxx);

        return "Hello World!";
    }

    @RequestMapping("/1")
    int intUtil() {
        return 1;
    }
 
}