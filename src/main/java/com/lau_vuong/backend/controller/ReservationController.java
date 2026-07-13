package com.lau_vuong.backend.controller;

import com.lau_vuong.backend.model.Reservation;
import com.lau_vuong.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping
    public ResponseEntity<Reservation> bookTable(@Valid @RequestBody Reservation reservation) {
        Reservation savedReservation = service.createReservation(reservation);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> list = service.getAllReservations();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
