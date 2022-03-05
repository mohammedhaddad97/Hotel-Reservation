package com.example.LinkedInSpringBoot.data.web;

import com.example.LinkedInSpringBoot.data.business.GuestByNameService;
import com.example.LinkedInSpringBoot.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/guests/guest")
public class GuestByNameController {

    private final GuestByNameService mGuestByNameService;

    @Autowired
    public GuestByNameController(GuestByNameService guestByNameService) {
        mGuestByNameService = guestByNameService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuestByName(
            @RequestParam(value = "name", required = false) String guestName,
            Model model
    ) {
        List<Guest> guests = mGuestByNameService.getGuest(guestName);

        model.addAttribute("guestByName", guests);

        return "guest_name";
    }
}
