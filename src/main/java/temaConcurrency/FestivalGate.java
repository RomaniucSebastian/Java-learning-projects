package temaConcurrency;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Class FestivalGate that contain the Festival Gate
 * ticketsList is a queue of Tickets Type from the festival attendee
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class FestivalGate {
    Queue<TicketType> ticketsList;

    public FestivalGate() {
        this.ticketsList = new LinkedList<>();
    }

    /**
     * method that add tickets to the queue
     */
    public synchronized void addTicket(TicketType ticketType) {
        ticketsList.add(ticketType);
    }

    /**
     * Method that take as param a TicketType and
     *
     * @return a queue of that kind of TicketType
     */
    public synchronized Queue<TicketType> getTicketsByType(TicketType ticketType) {
        Queue<TicketType> newList = new LinkedList<>();
        for (TicketType ticketType1 : ticketsList) {
            if (ticketType1.equals(ticketType)) {
                newList.add(ticketType1);
            }
        }
        return newList;
    }

    /**
     * @return a random TicketType
     */
    public synchronized TicketType getRandomTicket() {
        Random random = new Random();
        TicketType ticketType;
        int number = random.nextInt(5);
        switch (number) {
            case 0:
                ticketType = TicketType.FULL;
                break;
            case 1:
                ticketType = TicketType.FULL_VIP;
                break;
            case 2:
                ticketType = TicketType.FREE_PASS;
                break;
            case 3:
                ticketType = TicketType.ONE_DAY;
                break;
            case 4:
                ticketType = TicketType.ONE_DAY_VIP;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }
        return ticketType;
    }
}
