package manager;

import domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 2999, "CEK", "DME", 120);
    Ticket ticket2 = new Ticket(2, 4999, "CEK", "LED", 180);
    Ticket ticket3 = new Ticket(3, 7999, "CEK", "AYT", 240);
    Ticket ticket4 = new Ticket(4, 12999, "CEK", "DME", 480);
    Ticket ticket5 = new Ticket(5, 29999, "DME", "FRA", 150);
    Ticket ticket6 = new Ticket(6, 49999, "CEK", "DME", 520);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldTicketFitSearchOne() {
        Ticket[] expected = new Ticket[]{ticket5};
        Ticket[] actual = manager.findAll("DME", "FRA");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketFitSearchMoreOne() {
        Ticket[] expected = new Ticket[]{ticket1, ticket4, ticket6};
        Ticket[] actual = manager.findAll("CEK", "DME");
        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldTicketFitSearchNo() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("CEK", "LSQ");
        assertArrayEquals(expected, actual);
    }

}
