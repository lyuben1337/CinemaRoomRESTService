package cinema.model;

public record Seat(
        int row,
        int column
) {
    public Seat(Ticket ticket) {
        this(ticket.row(), ticket.column());
    }
}
