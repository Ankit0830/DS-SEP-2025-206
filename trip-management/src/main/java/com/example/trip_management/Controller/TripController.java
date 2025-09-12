package com.example.trip_management.Controller;

import com.example.trip_management.Service.TripService;
import com.example.trip_management.model.Trip;
import com.example.trip_management.model.TripStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService service;

    public TripController(TripService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(service.createTrip(trip));
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(service.getAllTrips());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable Integer id) {
        return service.getTripById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Integer id, @RequestBody Trip trip) {
        try {
            return ResponseEntity.ok(service.updateTrip(id, trip));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Integer id) {
        service.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Trip>> searchByDestination(@RequestParam String destination) {
        return ResponseEntity.ok(service.searchByDestination(destination));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Trip>> filterByStatus(@RequestParam TripStatus status) {
        return ResponseEntity.ok(service.filterByStatus(status));
    }

    @GetMapping("/daterange")
    public ResponseEntity<List<Trip>> getTripsBetweenDates(@RequestParam String start, @RequestParam String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return ResponseEntity.ok(service.getTripsBetweenDates(startDate, endDate));
    }

    @GetMapping("/summary")
    public ResponseEntity<TripService.TripSummary> getTripSummary() {
        return ResponseEntity.ok(service.getTripSummary());
    }
}

