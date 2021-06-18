package temaExceptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {
    private static Logger loggerStud = Logger.getLogger(Student.class.getName());

    private String firstName;
    private String lastName;
    private String dateBirth;
    private final int ID;
    private String gender;
    private final int age;
    private final String actualYear = "2021";
    private final int dateBirthValue;

    public Student(String firstName, String lastName, String dateBirth, int id, String gender) throws Validation {
        if (verifyYear(dateBirth)) {
            this.dateBirth = dateBirth;
        }
        if (verifyEmpty(firstName)) {
            this.firstName = firstName;
        }
        if (verifyEmpty(lastName)) {
            this.lastName = lastName;
        }
        ID = id;
        if (verifyUpperLower(gender)) {
            this.gender = gender;
        }
        dateBirthValue = Integer.valueOf(dateBirth);
        age = Integer.parseInt(actualYear) - dateBirthValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public int getID() {
        return ID;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getActualYear() {
        return actualYear;
    }

    public int getDateBirthValue() {
        return dateBirthValue;
    }

    public static boolean verifyYear(String year) {

        int yearvalue = Integer.valueOf(year);
        if (yearvalue < 1900 || yearvalue > 2021) {
            loggerStud.log(Level.SEVERE, "EROARE DATA DE NASTERE...! ");
            throw new IllegalArgumentException("ESTE IMPOSIBIL SA SETEZI ACEASTA DATA DE NASTERE!");
        }
        return true;
    }

    public static boolean verifyEmpty(@NotNull String name) throws Validation {
        if (name.equals("") || name.equals(" ")) {
            loggerStud.log(Level.SEVERE, "Eroare nume...");
            throw new Validation("INTRODU UN NUME!");
        }
        return true;
    }

    public static boolean verifyUpperLower(String genders) {
        if ((!genders.equalsIgnoreCase("m") && !genders.equalsIgnoreCase("F"))) {
            loggerStud.log(Level.SEVERE, "Eroare gen... ");
            throw new IllegalArgumentException("acesta nu este un gen valid!");
        }
        return true;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirth=" + dateBirth +
                ", ID=" + ID +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return dateBirth == student.dateBirth && ID == student.ID && age == student.age && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateBirth, ID, gender, age);
    }
}
