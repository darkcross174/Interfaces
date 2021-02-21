package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket implements Comparable{
    private int id;
    private int price;
    private String fromAirport;
    private String toAirport;
    private int time;

    @Override
    public int compareTo(Object o) {
        Ticket ticket = (Ticket) o;
        return price = ticket.price;
    }

}
