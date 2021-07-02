package temajava8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.ArrayUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public static void orderByMonthOfBirth(FileReader input, String monthOfBirth, FileWriter output) throws IOException {
        String[] strings = new String[0];
        List<Person> personList = createPersonFromList(getListFromFile(input, strings));
        BufferedWriter bfr = new BufferedWriter(output);
        personList.
                stream().
                filter(person -> {
                    List<String> strings1 = Arrays.asList(person.getDateOfBirth().split("\\."));
                    return strings1.get(1).equals(monthOfBirth);
                })
                .sorted(Comparator.comparing(Person::getFirstName))
                .forEach(person -> {
                    try {
                        bfr.write(person.getFirstName() + "," + person.getLastName() + "\n");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
        bfr.close();
    }

    public static List<Person> createPersonFromList(String[] strings) {
        List<String> strings1;
        List<Person> personList = new ArrayList<>();

        for (String string : strings) {
            strings1 = Arrays.asList(string.split(","));
            Person person = new Person();
            person.setFirstName(strings1.get(0));
            person.setLastName(strings1.get(1));
            person.setDateOfBirth(strings1.get(2));
            personList.add(person);
        }
        return personList;
    }

    public static String[] getListFromFile(FileReader fileReader, String[] strings) throws IOException {
        BufferedReader bf = new BufferedReader(fileReader);
        String line;
        while ((line = bf.readLine()) != null) {
            strings = (String[]) ArrayUtils.add(strings, line);
        }
        bf.close();
        return strings;
    }
}

