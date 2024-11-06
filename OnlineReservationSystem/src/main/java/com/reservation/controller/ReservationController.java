package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Reservation;
import com.reservation.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/view/{pnrNumber}")
    public ResponseEntity<Reservation> viewReservation(@PathVariable String pnrNumber) {
        return reservationService.findReservation(pnrNumber)
                                 .map(ResponseEntity::ok)
                                 .orElse(ResponseEntity.status(404).body(null));
    }

    @DeleteMapping("/cancel/{pnrNumber}")
    public ResponseEntity<String> cancelReservation(@PathVariable String pnrNumber) {
        reservationService.cancelReservation(pnrNumber);
        return ResponseEntity.ok("Reservation canceled successfully");
    }
}

