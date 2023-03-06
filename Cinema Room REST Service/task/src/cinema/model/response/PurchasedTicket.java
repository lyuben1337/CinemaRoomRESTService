package cinema.model.response;

public record PurchasedTicket(
        String token,
        Ticket ticket
) {
}
