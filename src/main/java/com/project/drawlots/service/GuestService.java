package com.project.drawlots.service;

import com.project.drawlots.dto.GuestParamsDTO;
import com.project.drawlots.model.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> findGuests();
    Guest create(GuestParamsDTO guestParamsDTO);
}
