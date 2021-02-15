package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    SQL db;

    HelloController(){
        db = new SQL();
        db.initSQLServer();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public String index(@RequestBody Form form) {
        try {
            String chapter = form.chapter;
            db.statement.executeUpdate("INSERT INTO chapters(name) VALUES('"+chapter+"');");
            System.out.println(form.chapter);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}

