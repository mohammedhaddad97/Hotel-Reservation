package com.example.LinkedInSpringBoot.data.business;

import com.example.LinkedInSpringBoot.data.entity.Guest;
import com.example.LinkedInSpringBoot.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestByNameService {

    private final GuestRepository mGuestRepository;

    @Autowired
    public GuestByNameService(GuestRepository guestRepository) {
        mGuestRepository = guestRepository;
    }

    public List<Guest> getGuest(String guestName) {
        Iterable<Guest> guest = mGuestRepository.findGuestByFirstName(guestName);

        List<Guest> guests = new ArrayList<>();
        guest.forEach(guests::add);

        return guests;
    }
}
