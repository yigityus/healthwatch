package com.taygun.healthwatch.controller;

import com.taygun.healthwatch.domain.Activity;
import com.taygun.healthwatch.service.user.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Optional;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting login page, error={}", error);

        Collection<Activity> allActivitys = activityService.getAllActivitys();
        LOGGER.debug(String.valueOf(allActivitys.size()));


        return new ModelAndView("login", "error", error);
    }

}
