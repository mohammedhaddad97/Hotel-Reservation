package com.example.LinkedInSpringBoot.WebServices;

import com.example.LinkedInSpringBoot.data.business.GuestService;
import com.example.LinkedInSpringBoot.data.business.ReservationService;
import com.example.LinkedInSpringBoot.data.business.RoomReservation;
import com.example.LinkedInSpringBoot.data.business.RoomService;
import com.example.LinkedInSpringBoot.data.entity.Guest;
import com.example.LinkedInSpringBoot.data.entity.Room;
import com.example.LinkedInSpringBoot.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class WebServicesController {
    private final DateUtils mDateUtils;
    private final ReservationService mReservationService;
    private final GuestService mGuestService;
    private final RoomService mRoomService;

    @Autowired
    public WebServicesController(
            DateUtils dateUtils,
            ReservationService reservationService,
            GuestService guestService,
            RoomService roomService) {
        mDateUtils = dateUtils;
        mGuestService = guestService;
        mReservationService = reservationService;
        mRoomService = roomService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(
            @RequestParam( value = "date", required = false) String dateString
    ) {
        Date date = this.mDateUtils.createDateFromDateString(dateString);
        return this.mReservationService.getRoomReservationsForDate(date);
    }
    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<Guest> getGuests() {
        return this.mGuestService.getGuests();
    }

    @PostMapping("/guests")
    public void addGuest(@RequestBody Guest guest) {
        this.mGuestService.saveGuest(guest);
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public  List<Room> getRooms() {
        return this.mRoomService.getRooms();
    }
}
