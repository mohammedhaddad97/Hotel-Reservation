package com.example.LinkedInSpringBoot.data.repository;

import com.example.LinkedInSpringBoot.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Iterable<Reservation> findReservationByReservationDate(Date reservationDate);
}
