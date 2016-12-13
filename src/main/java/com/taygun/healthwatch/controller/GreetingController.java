package com.taygun.healthwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        List<String> list = jdbcTemplate.queryForList("SELECT NAME FROM USER", String.class);

        model.addAttribute("name", name);
        return "greeting";
    }


    @RequestMapping("/searchFood")
    public String searchFood(@RequestParam(value="food", required=false, defaultValue="banana") String food, Model model) {

        RestTemplate restTemplate = new RestTemplate();

        String foodUrl =
                "http://api.nal.usda.gov/ndb/search/?format=json&api_key=fWxr5B47w0EqwrRfrrsiykCtziSZ94x6kyoHTI9r&q=";
        ResponseEntity<String> response =
                restTemplate.getForEntity(foodUrl + food, String.class);

        System.out.println(response);
        return "listfood";
    }

}
