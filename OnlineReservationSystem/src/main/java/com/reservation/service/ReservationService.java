package com.reservation.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        reservation.setPnrNumber(UUID.randomUUID().toString());
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> findReservation(String pnrNumber) {
        return reservationRepository.findByPnrNumber(pnrNumber);
    }

    public void cancelReservation(String pnrNumber) {
        reservationRepository.findByPnrNumber(pnrNumber).ifPresent(reservationRepository::delete);
    }
}

