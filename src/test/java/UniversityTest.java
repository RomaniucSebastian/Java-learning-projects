import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UniversityTest {
    University university;
    Student s1;
    Student s2;
    List<Student> list;

    @org.junit.Before
    public void setUp() throws Exception {
        university = new University();
        s1 = new Student("Sebastian", "Romaniuc", "1995", 12345, "M");
        s2 = new Student("Emanuela", "Diaconu", "1991", 23456, "f");
        list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addStudent() throws Validation {
        Student s3 = new Student("Olivia", "Roman", "1998", 34567, "F");
        list.add(s3);
        System.out.println(list.get(2));

    }

    @org.junit.Test
    public void deleteStudentbyID() throws Validation {
        university.deleteStudentbyID(list, 12345);
        for (Student student : list) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getID());
        }
    }
}