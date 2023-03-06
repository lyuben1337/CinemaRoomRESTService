package cinema.repository.inmemory;

import cinema.model.response.PurchasedTicket;
import cinema.model.response.Ticket;
import cinema.repository.PurchasedTicketRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class PurchasedTicketRepositoryInMemo implements PurchasedTicketRepository {

    private final Map<String, Ticket> purchasedTickets = new HashMap<>();

    public List<Ticket> getPurchasedTickets() {
        return purchasedTickets.values().stream().toList();
    }

    public void addTicket(PurchasedTicket purchasedTicket) {
        purchasedTickets.put(purchasedTicket.token(), purchasedTicket.ticket());
    }

    public boolean exists(String token) {
        return purchasedTickets.containsKey(token);
    }

    public Optional<Ticket> removeTicket(String token) {
        return Optional.of(purchasedTickets.remove(token));
    }

}
