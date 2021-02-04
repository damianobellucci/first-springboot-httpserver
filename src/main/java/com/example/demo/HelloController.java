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

            int idxRandomChapter = (int) (Math.random() * chapters.size());

            String randomChapter = chapters.get(idxRandomChapter);

            List<String> questions = new ArrayList(Arrays.asList(randomChapter.split("-")));
            questions.remove(0);
            questions.remove(0); // remove the title

            int idxRandomQuestion = (int) (Math.random() * questions.size());
            return questions.get(idxRandomQuestion);

        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
