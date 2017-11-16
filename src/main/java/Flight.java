import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashulman on 11/16/17.
 */
public class Flight {

    public String getFlightNo() {
        return flightNo;
    }

    final String flightNo;
    Set<Seat> seats;
    
    public Flight(
            String flightNo,
            int numberOfSeats) {

        this.flightNo = flightNo;
        seats = new HashSet();
        int counter = 0;
        // Initialize a set of empty seats with the default price of UNSET_PRICE
        for (int i=0; i<numberOfSeats; i++) {
            seats.add(new Seat(counter++));
        }
    }

    public Flight(String flightNo) {
        this.flightNo = flightNo;
        this.seats = new HashSet<>();
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Set<Seat> getSeats() {
        return seats;
    }
}
