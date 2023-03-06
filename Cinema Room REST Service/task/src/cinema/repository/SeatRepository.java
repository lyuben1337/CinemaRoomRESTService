package cinema.repository;

import cinema.model.request.Seat;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public interface SeatRepository {


    public List<Seat> getAvailableSeatList();

    public void addSeat(Seat seat);

    public void removeSeat(Seat seat);

    public boolean exists(Seat seat);

}
