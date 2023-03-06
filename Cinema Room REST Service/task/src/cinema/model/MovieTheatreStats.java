package cinema.model;

public record MovieTheatreStats(
        int currentIncome,
        int numberOfAvailableSeats,
        int numberOfPurchasedTickets
) {
}
