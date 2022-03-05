package com.example.LinkedInSpringBoot.data.web;

import com.example.LinkedInSpringBoot.data.business.ReservationService;
import com.example.LinkedInSpringBoot.data.business.RoomReservation;
import com.example.LinkedInSpringBoot.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final DateUtils mDateUtils;
    private final ReservationService mReservationService;

    public RoomReservationController(
            DateUtils dateUtils,
            ReservationService reservationService) {

        this.mDateUtils = dateUtils;
        this.mReservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(
            @RequestParam(value = "date", required = false) String dateString,
            Model model
    ) {
        Date date = this.mDateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations =
                this.mReservationService.getRoomReservationsForDate(date);

        model.addAttribute("roomReservations", roomReservations);

        return "roomres";
    }
}
