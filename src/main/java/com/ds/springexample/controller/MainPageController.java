package com.ds.springexample.controller;

/**
 * @author Dogukan Sonmez
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainPageController {

    private static final Logger logger = LoggerFactory.getLogger(MainPageController.class);


    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("controllerMessage", "Welcome to Home page of Spring example application");
        logger.info("requesting home");
        return "home";
    }

}

