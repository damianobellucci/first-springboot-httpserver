package com.example.demo;

import java.io.File;
import java.util.Scanner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        try {
            File file = new File(
                    "C:\\Users\\Damiano\\Google Drive\\coding\\first-springboot-httpserver\\src\\main\\java\\com\\example\\demo\\data.txt");
            Scanner myReader = new Scanner(file);
            String data = new String();

            while (myReader.hasNextLine()) {
                data = data.concat(myReader.nextLine());
            }
            myReader.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
