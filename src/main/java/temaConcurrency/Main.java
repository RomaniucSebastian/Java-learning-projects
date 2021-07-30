package temaConcurrency;

/**
 * @Class that run the program
 */
@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    public static void main(String[] args) {
        FestivalGate festivalGate = new FestivalGate();
        FestivalStatisticThread festivalStatisticThread = new FestivalStatisticThread(festivalGate);
        Thread thread1 = new Thread(festivalStatisticThread);
        thread1.start();


        while (true) {
            FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(festivalGate, festivalGate.getRandomTicket());
            Thread thread = new Thread(festivalAttendeeThread);
            thread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
