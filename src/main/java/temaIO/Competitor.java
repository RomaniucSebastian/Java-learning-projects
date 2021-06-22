package temaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Competitor {
    List<Competitor> competitors;

    private String AthleteNumber;
    private String AthleteName;
    private String CountryCode;
    private String SkiTimeResult;
    private String FirstShooting;
    private String SecondShooting;
    private String ThirdShooting;
    private int SkiTimeResultValueInSeconds;
    private int penality;
    private int totalTimeInSeconds;
    private int min;
    private int sec;
    private int totalMin;
    private int totalSec;

    public Competitor() {
        competitors = new ArrayList<>();
    }

    public void setAthleteNumber(String athleteNumber) {
        AthleteNumber = athleteNumber;
    }

    public String getAthleteName() {
        return AthleteName;
    }

    public void setAthleteName(String athleteName) {
        AthleteName = athleteName;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getSkiTimeResult() {
        return SkiTimeResult;
    }

    public void setSkiTimeResult(String skiTimeResult) { SkiTimeResult = skiTimeResult; }

    public void setSkiTimeResultValue(int skiTimeResultValue) {
        SkiTimeResultValueInSeconds = skiTimeResultValue;
    }

    public int getSkiTimeResultValueInSeconds() {
        return SkiTimeResultValueInSeconds;
    }

    public String getFirstShooting() {
        return FirstShooting;
    }

    public void setFirstShooting(String firstShooting) {
        FirstShooting = firstShooting;
    }

    public String getSecondShooting() {
        return SecondShooting;
    }

    public void setSecondShooting(String secondShooting) {
        SecondShooting = secondShooting;
    }

    public String getThirdShooting() {
        return ThirdShooting;
    }

    public void setThirdShooting(String thirdShooting) {
        ThirdShooting = thirdShooting;
    }

    public int getPenality() {
        return penality;
    }

    public void setPenality(int penality) {
        this.penality = penality;
    }

    public int getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(int totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getTotalMin() {
        return totalMin;
    }

    public void setTotalMin(int totalMin) {
        this.totalMin = totalMin;
    }

    public int getTotalSec() {
        return totalSec;
    }

    public void setTotalSec(int totalSec) {
        this.totalSec = totalSec;
    }

    public void listCompetitors() {
        for (Competitor competitor : competitors) {
            System.out.println(competitor);
        }
    }

    public void copyCompetitor(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            Competitor competitor = retriveCompetitor(line);
            competitors.add(competitor);
        }
    }

    private Competitor retriveCompetitor(String line) {
        Competitor competitor = new Competitor();

        Scanner s = new Scanner(line);
        s.useDelimiter(",");
        if (s.hasNext()) {
            competitor.setAthleteNumber(s.next());
            competitor.setAthleteName(s.next());
            competitor.setCountryCode(s.next());
            competitor.setSkiTimeResult(s.next());
            competitor.setFirstShooting(s.next());
            competitor.setSecondShooting(s.next());
            competitor.setThirdShooting(s.next());
        }
        return competitor;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "competitors=" + competitors +
                ", AthleteNumber='" + AthleteNumber + '\'' +
                ", AthleteName='" + AthleteName + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", SkiTimeResult='" + SkiTimeResult + '\'' +
                ", FirstShooting='" + FirstShooting + '\'' +
                ", SecondShooting='" + SecondShooting + '\'' +
                ", ThirdShooting='" + ThirdShooting + '\'' +
                ", SkiTimeResultValueInSeconds=" + SkiTimeResultValueInSeconds +
                ", penality=" + penality +
                ", totalTimeInSeconds=" + totalTimeInSeconds +
                ", min=" + min +
                ", sec=" + sec +
                ", totalMin=" + totalMin +
                ", totalSec=" + totalSec +
                '}';
    }
}
