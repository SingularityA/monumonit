package com.monumonit.controllers;

import com.monumonit.entities.Event;
import com.monumonit.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("event/")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("view/{id}/")
    public String view(Model model, @PathVariable Long id) {
        final Event event = eventService.find(id);
        model.addAttribute("event", event);
        return "events/view";
    }
}
