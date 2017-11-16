import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by ashulman on 11/16/17.
 */
public class FlightManagerTest {

    @Test
    public void should_get_number_of_available_seats()
            throws Exception {
        //given
        FlightManager flightManager = new FlightManagerBuilder("AA100").
                withSeat(0, 33).
                withSeat(0, 44).
                build();

        //when
        int seats = flightManager.getAvailableSeatsForFlight("AA100");

        //then
        assertEquals(2, seats);
    }

    @Test
    public void should_fail_when_flight_not_found() throws Exception {
        //given
        FlightManager manager = new FlightManagerBuilder("AA100").
                withSeat(0, 33).
                withSeat(0, 44).
                build();

        //when/then
        Assertions.assertThatExceptionOfType(NoFlightFoundException.class).isThrownBy(() -> manager.getAvailableSeatsForFlight("AA101"));

    }

    @Test
    public void should_get_cheapest_seat_on_flight() throws Exception {
        //given
        FlightManager manager = new FlightManagerBuilder("AA100").
                withSeat(0, 33).
                withSeat(0, 44).
                build();

        //when
        Integer cheapestSeat = manager.get_cheapest_seat_for_flight("AA100");

        //then
        assertEquals((Integer)33, cheapestSeat);
    }


    @Test
    public void should_add_seats_to_flight() throws Exception {
        //given
        FlightManager manager = new FlightManagerBuilder("AA100").
                withSeat(0, 33).
                build();

        //when
        Set<Seat> seats = manager.getFlight("AA100").getSeats();

        //then
        assertEquals(1, seats.size());
        assertEquals((Integer)0, seats.iterator().next().getLabel());
        assertEquals((Integer)33, seats.iterator().next().getPrice());
    }

}
