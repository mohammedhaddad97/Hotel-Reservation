package com.example.LinkedInSpringBoot.data.repository;

import com.example.LinkedInSpringBoot.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Iterable<Guest> findGuestByFirstName(String firstName);
    Optional<Guest> findGuestByPhoneNumber(String phoneNumber);
}
