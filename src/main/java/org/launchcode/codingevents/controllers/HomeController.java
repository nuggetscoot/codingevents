package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private EventRepository eventRepository;
    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam int[] eventIds) {
         for (int id : eventIds) {
             eventRepository.deleteById(id);
         }
         return "redirect:";
    }

}
