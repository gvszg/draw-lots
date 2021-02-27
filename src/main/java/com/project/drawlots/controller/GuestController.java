package com.project.drawlots.controller;

import com.project.drawlots.dto.GuestParamsDTO;
import com.project.drawlots.model.Guest;
import com.project.drawlots.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = {"/guests"})
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        log.info("Requested Controller - GuestController\nAction - index");
        model.addAttribute("guest", new GuestParamsDTO());
        return "guests/index";
    }

    @PostMapping(value = {"", "/"})
    public String fillIn(@ModelAttribute("guest")GuestParamsDTO guestParamsDTO, HttpServletRequest request) {

        try {
            Map<String, String[]> parameters = request.getParameterMap();
            String username = parameters.get("guest[username]")[0];
            int age = Integer.parseInt(parameters.get("guest[age]")[0]);
            GuestParamsDTO guestParams = new GuestParamsDTO(username, age);

            Guest guest = this.guestService.create(guestParams);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "redirect:/guests/thanks";
    }

    @GetMapping(value = {"thanks"})
    public String thanks() {
        return "guests/thanks";
    }
}
