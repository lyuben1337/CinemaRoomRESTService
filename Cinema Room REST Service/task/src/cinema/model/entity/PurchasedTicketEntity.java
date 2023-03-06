package cinema.model.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PurchasedTicketEntity {
    @Id
    String token;
    @Column(name = "row_num")
    int row;
    int column;
    int price;
}
