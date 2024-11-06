package com.reservation.repository;

import com.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);

    Optional<Reservation> findByPnrNumber(String pnrNumber);
}
