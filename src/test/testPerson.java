import org.apache.commons.lang.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {
    FileReader fileReader;
    BufferedReader bf;
    FileWriter fileWriter;
    String[] strings;
    List<Person> personList;

    @Before
    public void setUp() throws Exception {
        fileReader = new FileReader("C:\\User\\domnu\\Desktop\\JavaHomework\\TemeJavaGrupa6\\src\\main\\resources\\table.cvs");
        fileWriter = new FileWriter("C:\\User\\domnu\\Desktop\\JavaHomework\\TemeJavaGrupa6\\src\\main\\resources\\newtable.cvs");
        bf = new BufferedReader(new FileReader("C:\\User\\domnu\\Desktop\\JavaHomework\\TemeJavaGrupa6\\src\\main\\resources\\newtable.cvs"));
        strings = new String[0];
    }

    @Test
    public void orderByMonthOfBirthTest() throws IOException {
        Person.orderByMonthOfBirth(fileReader,"02",fileWriter);
        String expected = "Olivia,Romaniuc";
        String expected2 = "Sebastian,Romaniuc";
        String line;
        while ((line = bf.readLine()) != null){
            strings = (String[]) ArrayUtils.add(strings, line);
        }
        String actual = strings[0];
        String actual2 = strings[1];

        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void createPersonFromListTest() throws IOException {
        personList = Person.createPersonFromList(Person.getListFromFile(fileReader,strings));
        String expected = "Sebastian";
        String expected2 = "Romaniuc";
        String actual = personList.get(0).getFirstName();
        String actual2 = personList.get(0).getLastName();
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void getListFromFileTest() throws IOException {
        String expected = "Andrei,Diaconu,22.04.1992";
        String actual = Person.getListFromFile(fileReader, strings)[1];
        assertEquals(expected,actual);
    }
}