package temaConcurrency;

/**
 * @Class of Festival attendee which implement the Runnable interface
 */
public class FestivalAttendeeThread implements Runnable {
    TicketType ticketType;
    FestivalGate festivalGate;

    public FestivalAttendeeThread(FestivalGate festivalGate, TicketType ticketType) {
        this.festivalGate = festivalGate;
        this.ticketType = ticketType;
    }

    /**
     * method that take the TicketType and add it in the queue from the FestivalGate
     */
    @Override
    public void run() {
        festivalGate.addTicket(ticketType);
    }
}
