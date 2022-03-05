package com.example.LinkedInSpringBoot.data.web;

import com.example.LinkedInSpringBoot.data.business.GuestService;
import com.example.LinkedInSpringBoot.data.entity.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final GuestService mGuestService;

    public GuestController(GuestService guestService) {
        mGuestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model) {

        List<Guest> guests = this.mGuestService.getGuests();

        model.addAttribute("guests", guests);

        return "guests";
    }
}
