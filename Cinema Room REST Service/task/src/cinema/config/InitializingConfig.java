package cinema.config;

import cinema.model.request.Seat;
import cinema.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class InitializingConfig implements CommandLineRunner {

    SeatRepository seatRepository;
    CinemaProps cinemaProps;

    @Override
    public void run(String... args) throws Exception {
        for (int iRow = 1; iRow <= cinemaProps.totalRows(); iRow++) {
            for (int iCol = 1; iCol <= cinemaProps.totalColumns(); iCol++) {
                    seatRepository.addSeat(new Seat(iRow, iCol));
            }
        }
    }
}