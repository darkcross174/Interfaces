package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    private Ticket ticket1 = new Ticket(1, 2999, "CEK", "DME", 120);
    private Ticket ticket2 = new Ticket(2, 4999, "CEK", "LED", 180);
    private Ticket ticket3 = new Ticket(3, 7999, "CEK", "AYT", 240);
    private Ticket ticket4 = new Ticket(4, 12999, "CEK", "DME", 480);
    private Ticket ticket5 = new Ticket(5, 29999, "DME", "FRA", 150);
    private Ticket ticket6 = new Ticket(6, 49999, "CEK", "DME", 520);

    @Test
    public void shouldTicketTest() {
        Ticket[] expected=new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual=new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }
}
