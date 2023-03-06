package cinema.model.response;

import cinema.model.entity.PurchasedTicketEntity;
import cinema.model.request.Seat;
import lombok.Builder;

@Builder
public record Ticket (
        int row,
        int column,
        int price
) {
    public Ticket(Seat seat, int price) {
        this(seat.row(), seat.column(), price);
    }

    public Ticket(PurchasedTicketEntity purchasedTicketEntity) {
        this(purchasedTicketEntity.getRow(), purchasedTicketEntity.getColumn(), purchasedTicketEntity.getPrice());
    }
}
