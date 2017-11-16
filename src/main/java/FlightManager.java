import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by ashulman on 11/16/17.
 */
public class FlightManager {

    Set<Flight> flights = new HashSet();


    final static Integer PRICE_NOT_FOUND = -999;

    public void addFlight(
            Flight flightNo) {

        flights.add(flightNo);
    }

    public int getAvailableSeatsForFlight(String flightNo) {
        Optional<Flight> matchedFlight = flights.stream().filter(f -> f.getFlightNo().equals(flightNo)).findFirst();
        if (matchedFlight.isPresent()) {
            return matchedFlight.get().getSeats().size();
        } else {
            throw new NoFlightFoundException();
        }
    }

    public int get_cheapest_seat_for_flight(String flightNo)
            throws NoFlightFoundException {
        Optional<Flight> matchedFlight = flights.stream().filter(f -> f.getFlightNo().equals(flightNo)).findFirst();
        if (matchedFlight.isPresent()) {
            return matchedFlight.get().getSeats().stream().
                    map(seat -> seat.getPrice()).
                    sorted(Comparator.naturalOrder()).
                    findFirst().
                    orElse(PRICE_NOT_FOUND);
        } else {
            throw new NoFlightFoundException();
        }
    }

    public void addSeatsToFlight(String flightNo, Set<Seat> seats)
            throws NoFlightFoundException {
        Optional<Flight> matchedFlight = flights.stream().filter(f -> f.getFlightNo().equals(flightNo)).findFirst();
        if (matchedFlight.isPresent()) {
            matchedFlight.get().setSeats(seats);
        } else {
            throw new NoFlightFoundException();
        }
    }
}
