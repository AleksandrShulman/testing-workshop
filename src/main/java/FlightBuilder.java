/**
 * Created by ashulman on 11/16/17.
 */
public class FlightBuilder {

    Flight flight;

    public FlightBuilder(String flightNo) {
        flight = new Flight(flightNo);
    }

    public FlightBuilder withSeat(
            int label,
            int cost) {
        flight.getSeats().add(new Seat(label, cost));
        return this;
    }

    public Flight build() {
        return flight;
    }
}
