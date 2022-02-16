package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    While I think hashmaps work fine here, I think a list of Event objects would be superior, hence why I created the Event class even though I still implement the hashmap per the exercise instructions.
    private static HashMap<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String name, @RequestParam String address, @RequestParam String description){
        Event newEvent = new Event(name, description, address);
        events.put(newEvent.getName(), newEvent.getDescription());
        return "redirect:";
    }

}
