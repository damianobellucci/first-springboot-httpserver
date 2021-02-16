package com.example.demo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

@RestController
public class HelloController {

    SQL db;

    HelloController(){
        db = new SQL();
        db.initSQLServer();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/addChapter",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public String addChapter(@RequestBody Form form) {
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

    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/showChapters",
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json"
    )
    public String showChapters() {
        try {
            ResultSet result =  db.statement.executeQuery("SELECT * FROM chapters;");
            JSONArray array = new JSONArray();
            while(result.next()){
                array.put(result.getString(2));
            }
            JSONObject json = new JSONObject();
            json.put("list",array);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject json = new JSONObject();
            json.put("error","failure");
            return json.toString();
        }
    }
}

