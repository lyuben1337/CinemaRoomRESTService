package cinema.repository;

import cinema.model.response.PurchasedTicket;
import cinema.model.response.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface PurchasedTicketRepository {

    public List<Ticket> getPurchasedTickets();

    public void addTicket(PurchasedTicket purchasedTicket);

    public boolean exists(String token);

    public Optional<Ticket> removeTicket(String token);

}
