package com.example.LinkedInSpringBoot.util;

import com.example.LinkedInSpringBoot.data.business.ReservationService;
import com.example.LinkedInSpringBoot.data.business.RoomReservation;
import com.example.LinkedInSpringBoot.data.entity.Guest;
import com.example.LinkedInSpringBoot.data.entity.Reservation;
import com.example.LinkedInSpringBoot.data.entity.Room;
import com.example.LinkedInSpringBoot.data.repository.GuestRepository;
import com.example.LinkedInSpringBoot.data.repository.ReservationRepository;
import com.example.LinkedInSpringBoot.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService mReservationService;
    private final DateUtils mDateUtils;

    public AppStartupEvent(
            ReservationService reservationService,
            DateUtils dateUtils) {

        mReservationService = reservationService;
        mDateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.mDateUtils.createDateFromDateString("2022-01-01");

        List<RoomReservation> reservations =
                this.mReservationService.getRoomReservationsForDate(date);

        reservations.forEach(System.out::println);

    }
}
