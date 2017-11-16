import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by ashulman on 11/16/17.
 */
public class FlightManagerTest {

    @Test
    public void should_get_number_of_available_seats() throws Exception {
        /*
        //given
        FlightManager manager = new FlightManager();
        manager.addFlight(new Flight("AA100", 10));


        //when
        int seats = manager.getAvailableSeatsForFlight("AA100");

        //then
        assertEquals(10, seats);
        */

        //given
        FlightManagerBuilder("AA100").withSeat(0, 33).withSeat(0,44).build()
        //when

        //then

    }

    @Test
    public void should_fail_when_flight_not_found() throws Exception {
        //given
        FlightManager manager = new FlightManager();
        manager.addFlight(new Flight("A100"));

        //when/then
        Assertions.assertThatExceptionOfType(NoFlightFoundException.class).isThrownBy(() -> manager.getAvailableSeatsForFlight("AA101"));

    }

    @Test
    public void should_get_cheapest_seat_on_flight() throws Exception {
        //given
        FlightManager manager = new FlightManager();
        Flight testFlight = new Flight("AA100");
        manager.addFlight(testFlight);
        List<Integer> priceList = Arrays.asList(new Integer[]{10,20});

        Set<Seat> seatSet = new HashSet();
        int counter = 0;
        for(Integer price : priceList) {
            seatSet.add(new Seat(counter++, price));
        }

        manager.addSeatsToFlight("AA100", seatSet);

        //when
        Integer cheapestSeat = manager.get_cheapest_seat_for_flight("AA100");

        //then
        assertEquals((Integer)10, cheapestSeat);
    }


    @Test
    public void should_add_seats_to_flight() throws Exception {
        //given
        Flight testFlight = new Flight("AA100");
        Seat s = new Seat(0);
        Set<Seat> seatSet = new HashSet<>();
        seatSet.add(s);
        testFlight.setSeats(seatSet);

        //when
        Set<Seat> seats = testFlight.getSeats();

        //then
        assertEquals(1, seats.size());
        assertEquals((Integer)0, seats.iterator().next().getLabel());
        assertEquals(Seat.UNSET_PRICE, seats.iterator().next().getPrice());
    }

}
