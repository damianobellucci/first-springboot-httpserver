package com.example.demo;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        try {
            URL url = getClass().getResource("data.txt");
            File file = new File(url.getPath());
            return file.toString();
        } catch (Exception e) {
            return "failure";
        }
    }
}