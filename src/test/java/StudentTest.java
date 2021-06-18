import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void verifyUpperLower() throws Validation {
        Student student = new Student("Ema","Iosif", "1991" , 22312, "Fm");
    }



    @Test
    void verifyEmpty() throws Validation {
        Student student = new Student("","Sebastian", "1998" , 22312, "m");
    }

    @Test
    void verifyYear() throws Validation {
        Student student = new Student("Daniel","Sebastian", "1899" , 22312, "m");
    }

}