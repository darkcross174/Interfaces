package manager;

import domain.Ticket;
import repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager() {
    }

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add (Ticket ticket) {
        repository.save(ticket);
    }

    public void removeById (int id) {
        repository.removeById(id);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.matches(from, to)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                // копируем поэлементно все элементы из Ticket[]
                System.arraycopy(result, 0, tmp, 0, result.length);
                //добавляем найденный элемент в result
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
