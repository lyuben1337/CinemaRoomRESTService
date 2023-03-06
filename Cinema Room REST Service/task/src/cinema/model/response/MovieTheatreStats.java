package cinema.model.response;

public record MovieTheatreStats(
        int currentIncome,
        int numberOfAvailableSeats,
        int numberOfPurchasedTickets
) {
}
