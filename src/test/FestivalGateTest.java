package tema_concurrency;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FestivalGateTest {
    TicketType ticketType;
    TicketType ticketType1;
    TicketType ticketType2;
    FestivalGate festivalGate;

    @Before
    public void setUp() {
        ticketType = TicketType.FULL;
        ticketType1 = TicketType.FULL;
        ticketType2 = TicketType.FULL_VIP;
        festivalGate = new FestivalGate();
        festivalGate.addTicket(ticketType);
        festivalGate.addTicket(ticketType1);
        festivalGate.addTicket(ticketType2);
    }

    @Test
    public void addTicketTest() {
        int expected = 3;
        assertEquals(expected, festivalGate.getTicketsList().size());
    }

    @Test
    public void getTicketsByTypeTest() {
        int expected = 2;
        int expected1 = 1;
        assertEquals(expected, festivalGate.getTicketsByType(ticketType).size());
        assertEquals(expected1, festivalGate.getTicketsByType(ticketType2).size());
    }
}