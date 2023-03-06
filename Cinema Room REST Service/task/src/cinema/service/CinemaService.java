package cinema.service;


import cinema.model.response.PurchasedTicket;
import cinema.model.response.ReturnedTicket;
import cinema.model.request.Seat;
import cinema.model.response.CinemaRoomInfo;
import cinema.model.response.MovieTheatreStats;

public interface CinemaService {

    public CinemaRoomInfo getCinemaRoomInfo();
    public PurchasedTicket purchaseTicket(Seat seat);
    public ReturnedTicket returnTicket(String token);
    public MovieTheatreStats getMovieTheatreStats(String password);

}
