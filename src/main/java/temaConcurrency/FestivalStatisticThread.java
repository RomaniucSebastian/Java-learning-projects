package temaConcurrency;

import lombok.NonNull;
import lombok.SneakyThrows;

/**
 * @Class that makes a statistic of the tickets types of the festival attendees  which implement the Runnable interface
 */
public class FestivalStatisticThread implements Runnable {
    FestivalGate festivalGate;

    public FestivalStatisticThread(@NonNull FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while (true) {
            TicketType ticketType = TicketType.FULL;
            TicketType ticketType1 = TicketType.FULL_VIP;
            TicketType ticketType2 = TicketType.FREE_PASS;
            TicketType ticketType3 = TicketType.ONE_DAY;
            TicketType ticketType4 = TicketType.ONE_DAY_VIP;

            System.out.println(festivalGate.getTicketsList().size() + " people entered");
            System.out.println(festivalGate.getTicketsByType(ticketType).size() + " people have Full tickets");
            System.out.println(festivalGate.getTicketsByType(ticketType1).size() + " people have Full VIP tickets");
            System.out.println(festivalGate.getTicketsByType(ticketType2).size() + " people have Free Pass tickets");
            System.out.println(festivalGate.getTicketsByType(ticketType3).size() + " people have One Day tickets");
            System.out.println(festivalGate.getTicketsByType(ticketType4).size() + " people have One Day VIP tickets");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

