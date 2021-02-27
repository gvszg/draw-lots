package com.project.drawlots.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = {"/guests"})
public class GuestController {

    @GetMapping(value = {"", "/"})
    public String index() {
        log.info("Requested Controller - GuestController\nAction - index");
        return "guests/index";
    }

    @PostMapping(value = {"", "/"})
    public String fillIn(ModelAttribute modelAttribute) {
        log.info(String.valueOf(modelAttribute));
        return "guests/thanks";
    }
}
