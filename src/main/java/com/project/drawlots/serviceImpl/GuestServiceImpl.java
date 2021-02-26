package com.project.drawlots.serviceImpl;

import com.project.drawlots.dto.GuestParamsDTO;
import com.project.drawlots.model.Guest;
import com.project.drawlots.repository.GuestRepository;
import com.project.drawlots.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> findGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest create(GuestParamsDTO guestParamsDTO) {
        Guest guest = Guest.builder()
                .username(guestParamsDTO.getUsername())
                .age(guestParamsDTO.getAge())
                .build();

        return guestRepository.save(guest);
    }
}
