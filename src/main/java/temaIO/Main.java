package temaIO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Athlete athlete = new Athlete();
        Athlete athlete1 = new Athlete();
        Athlete athlete2 = new Athlete();
        athlete.getAthleteAtributeFromCVS(athlete, 1);
        athlete1.getAthleteAtributeFromCVS(athlete1, 2);
        athlete2.getAthleteAtributeFromCVS(athlete2, 3);

        athlete.calculatePenaltyForMissingShots(athlete, athlete.getFirstShooting());
        athlete.calculatePenaltyForMissingShots(athlete, athlete.getSecondShooting());
        athlete.calculatePenaltyForMissingShots(athlete, athlete.getThirdShooting());

        athlete1.calculatePenaltyForMissingShots(athlete1, athlete1.getFirstShooting());
        athlete1.calculatePenaltyForMissingShots(athlete1, athlete1.getSecondShooting());
        athlete1.calculatePenaltyForMissingShots(athlete1, athlete1.getThirdShooting());

        athlete2.calculatePenaltyForMissingShots(athlete2, athlete2.getFirstShooting());
        athlete2.calculatePenaltyForMissingShots(athlete2, athlete2.getSecondShooting());
        athlete2.calculatePenaltyForMissingShots(athlete2, athlete2.getThirdShooting());

        List<Athlete> athleteList = new ArrayList<>();
        athleteList.add(athlete);
        athleteList.add(athlete1);
        athleteList.add(athlete2);
        athleteList.sort(Comparator.comparing(Athlete::getTimeResult));

        System.out.println("Winner - " + athleteList.get(0).getName() + " " + athleteList.get(0).getTimeResult()
                + "\nRunner-up - " + athleteList.get(1).getName() + " " + athleteList.get(1).getTimeResult()
                + "\nThird Place - " + athleteList.get(2).getName() + " " + athleteList.get(2).getTimeResult());
    }
}
