package temaExceptions;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class University {

    private static Logger logger = Logger.getLogger(University.class.getName());

    List<Student> studentList;

    public University() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudentbyID(List<Student> students,int ids) throws Validation {
        if (!students.removeIf(student -> student.getID() == ids)) {
            logger.log(Level.SEVERE, "Eroare ,  nu este ni9meni inregistrat cu acest ID");
            throw new Validation("Student inexistent");
        }
        students.removeIf(student -> student.getID() == ids);
    }


    public void studentsAge(int age) {

        if (age < 0) {
            logger.log(Level.SEVERE, "eroare-varsta negativa" + logger.getName());
            throw new IllegalArgumentException("Varsta nu poate fi negativa");
        }
        for (Student student : studentList) {
            if (student.getAge() == age) {
                System.out.println("Student: " + student.getFirstName());
            }
        }
    }

    public void listStudentByLastName(List<Student> students) {
        if (students.isEmpty()) {
            logger.log(Level.SEVERE, "lista fara nici un nume de student !" + logger.getName());
            throw new IllegalArgumentException("Aceasta lista nu contine nici-un student. Adauga stuneti!");
        }
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println(students);
    }

    public void listStudentByBirthDate(List<Student> students) {
        if (students.isEmpty()) {
            logger.log(Level.SEVERE, "lista fara nici o data de nastere. ");
            throw new IllegalArgumentException("Aceasta lista nu contine nici-un student. Adauga stuneti!");
        }
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getDateBirthValue() - o1.getDateBirthValue();
            }
        });
        System.out.println(students);
    }
}


