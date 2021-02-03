package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

            List<String> chapters = new ArrayList(Arrays.asList(data.split("\\*\\*\\*")));
            chapters.remove(0);

            int idxRandomChapter = 0 + (int) (Math.random() * chapters.size());

            return chapters.get(idxRandomChapter);

        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
