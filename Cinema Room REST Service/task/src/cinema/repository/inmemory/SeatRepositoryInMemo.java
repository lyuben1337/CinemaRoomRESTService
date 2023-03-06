package cinema.repository.inmemory;

import cinema.model.request.Seat;
import cinema.repository.SeatRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
public class SeatRepositoryInMemo implements SeatRepository {

    private final Set<Seat> availableSeats = new LinkedHashSet<>();

    public List<Seat> getAvailableSeatList() {
        return availableSeats.stream().toList();
    }

    public void addSeat(Seat seat) {
        availableSeats.add(seat);
    }

    public void removeSeat(Seat seat) {
        availableSeats.remove(seat);
    }

    public boolean exists(Seat seat) {
        return availableSeats.contains(seat);
    }

}

