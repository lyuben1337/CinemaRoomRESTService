package cinema.service.mock;

import cinema.model.response.PurchasedTicket;
import cinema.model.response.ReturnedTicket;
import cinema.model.request.Seat;
import cinema.model.response.CinemaRoomInfo;
import cinema.model.response.MovieTheatreStats;
import cinema.service.CinemaService;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceMock implements CinemaService {
    @Override
    public CinemaRoomInfo getCinemaRoomInfo() {
        return null;
    }

    @Override
    public PurchasedTicket purchaseTicket(Seat seat) {
        return null;
    }

    @Override
    public ReturnedTicket returnTicket(String token) {
        return null;
    }

    @Override
    public MovieTheatreStats getMovieTheatreStats(String password) {
        return null;
    }
}
