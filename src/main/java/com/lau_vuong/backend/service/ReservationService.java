package com.lau_vuong.backend.service;

import com.lau_vuong.backend.model.Reservation;
import com.lau_vuong.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public Reservation createReservation(Reservation reservation) {
        // Generate random unique code starting with LV-
        int randomCode = 100000 + new Random().nextInt(900000);
        reservation.setCode("LV-" + randomCode);
        
        return repository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }
}
