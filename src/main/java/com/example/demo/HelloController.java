package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @CrossOrigin(origins = "http://localhost:3000") //endpoint accessibile solo dal frontend
    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public String index(@RequestBody Form form) {
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

            SQL db = new SQL();
            db.initSQLServer();

            db.statement.executeUpdate("INSERT INTO chapters(name) VALUES('capitolo di prova da java');");
            System.out.println(form.chapter);
            return questions.get(idxRandomQuestion);

        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}

