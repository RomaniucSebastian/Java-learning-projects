import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AthleteTest {
    Athlete athlete;

    @Before
    public void setUp() {
        athlete = new Athlete();
    }

    @Test
    public void getAthleteAtributeFromCVSTest() {
        athlete.getAthleteAtributeFromCVS(athlete, 1);
        String name = "Umar Jorgson";
        String number = "11";
        String countryCode = "SK";
        String time = "0:30:27";
        String firstShoot = "xxxox";
        assertEquals(name, athlete.getName());
        assertEquals(number, athlete.getNumber());
        assertEquals(countryCode, athlete.getCountryCode());
        assertEquals(time, athlete.getTimeResult());
        assertEquals(firstShoot, athlete.getFirstShooting());
    }

    @Test
    public void calculatePenaltyForMissingShots() {
        athlete.setTimeResult("0:30:27");
        athlete.setFirstShooting("xxoxx");
        athlete.setSecondShooting("xxxox");

        athlete.calculatePenaltyForMissingShots(athlete, athlete.getFirstShooting());
        String expected = "0:30:37";
        assertEquals(expected, athlete.getTimeResult());

        athlete.calculatePenaltyForMissingShots(athlete, athlete.getSecondShooting());
        String expected2 = "0:30:47";
        assertEquals(expected2, athlete.getTimeResult());
    }
}