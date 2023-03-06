package cinema.model;

public record PurchasedTicket(
        String token,
        Ticket ticket
) {
}
