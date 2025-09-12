package com.example.trip_management.Service;

import com.example.trip_management.model.Trip;
import com.example.trip_management.model.TripStatus;
import com.example.trip_management.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;


@Service
public class TripService {
    private final TripRepository repo;

    public TripService(TripRepository repo) { this.repo = repo; }

    public Trip createTrip(Trip trip) { return repo.save(trip); }
    public List<Trip> getAllTrips() { return repo.findAll(); }
    public Optional<Trip> getTripById(Integer id) { return repo.findById(id); }

    public Trip updateTrip(Integer id, Trip newTrip) {
        return repo.findById(id).map(trip -> {
            trip.setDestination(newTrip.getDestination());
            trip.setStartDate(newTrip.getStartDate());
            trip.setEndDate(newTrip.getEndDate());
            trip.setPrice(newTrip.getPrice());
            trip.setStatus(newTrip.getStatus());
            return repo.save(trip);
        }).orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    public void deleteTrip(Integer id) { repo.deleteById(id); }
    public List<Trip> searchByDestination(String dest) { return repo.findByDestinationContainingIgnoreCase(dest); }
    public List<Trip> filterByStatus(TripStatus status) { return repo.findByStatus(status); }
    public List<Trip> getTripsBetweenDates(LocalDate start, LocalDate end) { return repo.findTripsBetweenDates(start, end); }

    public TripSummary getTripSummary() {
        List<Trip> trips = repo.findAll();
        int total = trips.size();
        double min = trips.stream().mapToDouble(Trip::getPrice).min().orElse(0);
        double max = trips.stream().mapToDouble(Trip::getPrice).max().orElse(0);
        double avg = trips.stream().mapToDouble(Trip::getPrice).average().orElse(0);
        return new TripSummary(total, min, max, avg);
    }

    public record TripSummary(int totalTrips, double minPrice, double maxPrice, double averagePrice) {}
}
