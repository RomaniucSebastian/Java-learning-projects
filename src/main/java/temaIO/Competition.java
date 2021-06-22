package temaIO;

import java.io.IOException;
import java.util.*;

public class Competition {

    public Competition() {
    }

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/rezultatRomaniuc.csv";
        Competitor competitor = new Competitor();
        competitor.copyCompetitor(filePath);
        transformTimeAndSetIt(competitor.competitors);
        setPenaltyToList(competitor.competitors);
        retriveTotalTimeInSeconds(competitor.competitors);
        transformNewTime(competitor.competitors);

        Competition competition = new Competition();
        competition.competitonResult(competitor.competitors);

    }

    public void competitonResult(List<Competitor> competitorsResult) {
        competitorsResult.sort(new WinnerComparator());
        Competitor first = competitorsResult.get(0);
        Competitor second = competitorsResult.get(1);
        Competitor third = competitorsResult.get(2);
        Competitor fourth = competitorsResult.get(3);

        System.out.println("LOCU 1  - " + first.getAthleteName() + " " + first.getTotalMin() + ":" + first.getTotalSec() + " (" + first.getSkiTimeResult() + " + " + first.getPenality() + ")");
        System.out.println("LOCUL 2- " + second.getAthleteName() + " " + second.getTotalMin() + ":" + second.getTotalSec() + " (" + second.getSkiTimeResult() + " + " + second.getPenality() + ")");
        System.out.println("LOCUL 3 - " + third.getAthleteName() + " " + third.getTotalMin() + ":" + third.getTotalSec() + " (" + third.getSkiTimeResult() + " + " + third.getPenality() + ")");
        System.out.println("MENTIUNE - " + fourth.getAthleteName() + " " + fourth.getTotalMin() + ":" + fourth.getTotalSec() + " (" + fourth.getSkiTimeResult() + " + " + fourth.getPenality() + ")");
    }


    private static void setPenaltyToList(List<Competitor> competitorsResult) {
        for (Competitor competitor : competitorsResult) {
            String[] first = competitor.getFirstShooting().split("");
            String[] second = competitor.getSecondShooting().split("");
            String[] third = competitor.getThirdShooting().split("");

            int penality = 0;
            for (String shots : first) {
                if (shots.equalsIgnoreCase("o")) {
                    penality += 10;
                }
            }
            for (String shots2 : second) {
                if (shots2.equalsIgnoreCase("o")) {
                    penality += 10;
                }
            }
            for (String shots3 : third) {
                if (shots3.equalsIgnoreCase("o")) {
                    penality += 10;
                }
            }
            competitor.setPenality(penality);
        }
    }

    public static void transformTimeAndSetIt(List<Competitor> competitorstime) {
        int min;
        int sec;
        int total;
        for (Competitor competitor : competitorstime) {
            String[] times = competitor.getSkiTimeResult().split(":");
            min = Integer.parseInt(times[0]);
            sec = Integer.parseInt(times[1]);
            competitor.setMin(min);
            competitor.setSec(sec);
            int convertedMin = min * 60;
            total = convertedMin + sec;
            competitor.setSkiTimeResultValue(total);
        }
    }

    public static void transformNewTime(List<Competitor> competitors) {
        for (Competitor competitor : competitors) {
            competitor.setTotalSec(competitor.getSec() + competitor.getPenality());
            competitor.setTotalMin(competitor.getMin());
            if (competitor.getTotalSec() >= 60) {
                competitor.setTotalMin(competitor.getMin() + 1);
                competitor.setTotalSec(competitor.getTotalSec() - 60);
            }
        }
    }

    public static void retriveTotalTimeInSeconds(List<Competitor> competitors) {
        int total = 0;
        for (Competitor competitor1 : competitors) {
            total = competitor1.getSkiTimeResultValueInSeconds() + competitor1.getPenality();
            competitor1.setTotalTimeInSeconds(total);
        }
    }
}
