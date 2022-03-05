package com.example.LinkedInSpringBoot.data.business;

import com.example.LinkedInSpringBoot.data.entity.Guest;
import com.example.LinkedInSpringBoot.data.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository mGuestRepository;

    public GuestService(GuestRepository guestRepository) {
        mGuestRepository = guestRepository;
    }

    public List<Guest> getGuests() {
        return this.mGuestRepository.findAll();
    }

    public void saveGuest(Guest guest) {
        Optional<Guest> guestByNamePhoneNumber =
                mGuestRepository.findGuestByPhoneNumber(guest.getPhoneNumber());

        if(guest == null) {
            throw new IllegalStateException("Guest with phone number (" +
                    guest.getPhoneNumber() + ") already exists");
        }
        this.mGuestRepository.save(guest);
        System.out.println("Guest added Successfully");

    }
}
