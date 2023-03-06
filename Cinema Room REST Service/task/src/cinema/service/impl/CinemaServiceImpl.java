package cinema.service.impl;

import cinema.config.CinemaProps;
import cinema.exception.TicketAlreadyPurchasedException;
import cinema.exception.TicketOutOfBoundsException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import cinema.model.response.PurchasedTicket;
import cinema.model.response.ReturnedTicket;
import cinema.model.request.Seat;
import cinema.model.response.Ticket;
import cinema.model.response.CinemaRoomInfo;
import cinema.model.response.MovieTheatreStats;
import cinema.repository.PurchasedTicketRepository;
import cinema.repository.SeatRepository;
import cinema.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Primary
@AllArgsConstructor
@Service
public class CinemaServiceImpl implements CinemaService {
    private CinemaProps cinemaProps;
    private SeatRepository seatRepository;
    private PurchasedTicketRepository purchasedTicketRepository;

    public CinemaRoomInfo getCinemaRoomInfo() {

        return new CinemaRoomInfo(
                cinemaProps.totalRows(),
                cinemaProps.totalColumns(),
                seatRepository.getAvailableSeatList().stream()
                        .map(this::addPrice).toList()
        );

    }

    private boolean validate(Seat seat) {
        return seat.row() > 0 && seat.row() <= cinemaProps.totalRows()
                && seat.column() > 0 && seat.column() <= cinemaProps.totalColumns();
    }

    public PurchasedTicket purchaseTicket(Seat seat) {
        if(!validate(seat)) {
            throw new TicketOutOfBoundsException("The number of a row or a column is out of bounds!");
        }
        if(!seatRepository.exists(seat)) {
            throw new TicketAlreadyPurchasedException("The ticket has been already purchased!");
        }
        seatRepository.removeSeat(seat);
        PurchasedTicket purchasedTicket = new PurchasedTicket(
                UUID.randomUUID().toString(),
                addPrice(seat)
        );
        purchasedTicketRepository.addTicket(purchasedTicket);
        return purchasedTicket;
    }

    private Ticket addPrice(Seat seat) {
        return new Ticket(seat, calcPrice(seat));
    }

    private int calcPrice(Seat seat) {
        if(seat.row() <= cinemaProps.firstRows())
            return cinemaProps.price().high();
        return cinemaProps.price().low();
    }

    public ReturnedTicket returnTicket(String token) {
        if(!purchasedTicketRepository.exists(token)){
            throw new WrongTokenException("Wrong token!");
        }
        var returnedTicket = purchasedTicketRepository.removeTicket(token);
        seatRepository.addSeat(new Seat(returnedTicket.get()));
        return new ReturnedTicket(returnedTicket.get());
    }

    public MovieTheatreStats getMovieTheatreStats(String password) {
        if(!cinemaProps.superSecret().equals(password)) {
            throw new WrongPasswordException("The password is wrong!");
        }
        return new MovieTheatreStats(
                calcIncome(),
                seatRepository.getAvailableSeatList().size(),
                purchasedTicketRepository.getPurchasedTickets().size()
        );
    }

    private int calcIncome() {
        return purchasedTicketRepository.getPurchasedTickets()
                .stream()
                .mapToInt(Ticket::price)
                .sum();
    }
}
