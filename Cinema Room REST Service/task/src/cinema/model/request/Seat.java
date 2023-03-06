package cinema.model.request;

import cinema.model.response.Ticket;

public record Seat(
        int row,
        int column
) {
    public Seat(Ticket ticket) {
        this(ticket.row(), ticket.column());
    }
}
