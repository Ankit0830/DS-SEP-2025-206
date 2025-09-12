package com.example.trip_management.repository;

import com.example.trip_management.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.trip_management.model.TripStatus;

import java.time.LocalDate;
import java.util.List;
public interface TripRepository extends JpaRepository<Trip, Integer> {

    List<Trip> findByDestinationContainingIgnoreCase(String destination);
    List<Trip> findByStatus(TripStatus status);

    @Query("SELECT t FROM Trip t WHERE t.startDate >= :start AND t.endDate <= :end")
    List<Trip> findTripsBetweenDates(LocalDate start, LocalDate end);

}
