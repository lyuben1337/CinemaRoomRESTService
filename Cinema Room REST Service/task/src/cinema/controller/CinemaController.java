package cinema.controller;

import cinema.model.request.Seat;
import cinema.model.request.Token;
import cinema.model.response.CinemaRoomInfo;
import cinema.model.response.MovieTheatreStats;
import cinema.model.response.PurchasedTicket;
import cinema.model.response.ReturnedTicket;
import cinema.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CinemaController {
    private CinemaService cinemaService;

    @GetMapping("/seats")
    CinemaRoomInfo availableSeats() {
        return cinemaService.getCinemaRoomInfo();
    }

    @PostMapping("/purchase")
    PurchasedTicket purchaseTicket(@RequestBody Seat seat) {
        return cinemaService.purchaseTicket(seat);
    }

    @PostMapping("/return")
    ReturnedTicket returnTicket(@RequestBody Token token) {
        return cinemaService.returnTicket(token.token());
    }

    @PostMapping("/stats")
    MovieTheatreStats getStats(@RequestParam(name = "password", required = false) String password) {
        return cinemaService.getMovieTheatreStats(password);
    }
}




