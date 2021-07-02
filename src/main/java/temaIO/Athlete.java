package temaIO;

import com.jramoyo.io.IndexedFileReader;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Athlete {

    private String number;
    private String name;
    private String countryCode;
    private String timeResult;
    private String firstShooting;
    private String secondShooting;
    private String thirdShooting;

    public void getAthleteAtributeFromCVS(Athlete athlete, int lineNumberCVS) {
        IndexedFileReader reader;
        try {
            reader = new IndexedFileReader(new File("src/main/resources/rezultatRomaniuc.csv"));
            Map<Integer, String> lines = reader.readLines(1, 1000);
            String[] strings = lines.get(lineNumberCVS).split(",");
            athlete.setNumber(strings[0]);
            athlete.setName(strings[1]);
            athlete.setCountryCode(strings[2]);
            athlete.setTimeResult(strings[3]);
            athlete.setFirstShooting(strings[4]);
            athlete.setSecondShooting(strings[5]);
            athlete.setThirdShooting(strings[6]);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void calculatePenaltyForMissingShots(Athlete athlete, String shoot) {
        String[] timeList = athlete.getTimeResult().split(":");
        int hours = Integer.parseInt(timeList[0]);
        int minutes = Integer.parseInt(timeList[1]);
        int seconds = Integer.parseInt(timeList[2]);
        Character o = 'o';
        for (int i = 0; i < shoot.length(); i++) {
            Character c = shoot.charAt(i);
            if (c.equals(o)) {
                seconds = seconds + 10;
                if (seconds > 60) {
                    seconds = seconds - 60;
                    minutes = minutes + 1;
                } else if (minutes > 60) {
                    minutes = minutes - 60;
                    hours = hours + 1;
                }
            }
        }
        String ex = hours + ":" + minutes + ":" + seconds;
        athlete.setTimeResult(ex);
    }
}
