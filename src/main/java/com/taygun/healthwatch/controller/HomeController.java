package com.taygun.healthwatch.controller;

import com.taygun.healthwatch.domain.Activity;
import com.taygun.healthwatch.domain.CurrentUser;
import com.taygun.healthwatch.service.user.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    ActivityService activityService;

    @RequestMapping("/")
    public String getHomePage(CurrentUser currentUser) {
        LOGGER.debug("Getting home page" + currentUser);
        if (currentUser==null) {
            return "redirect:login";
        }
        return "home";
    }

    @RequestMapping("/add")
    public String add(@RequestParam(name = "activity") String activity, Model model) {
        LOGGER.debug("Getting home page " + activity);

        List<Activity> activities = activityService.getActivityContaining(activity);
        model.addAttribute("activities", activities);

        return "home";
    }

}
