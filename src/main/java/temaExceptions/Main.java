package temaExceptions;

import java.util.logging.Logger;

public class Main {

    public static Logger logger = Logger.getLogger(University.class.getName());

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        Main.logger = logger;
    }

    public static void main(String[] args) throws Validation {


        Student s1 = new Student("Sebastian", "Romaniuc", "1995", 12345, "m");
        Student s2 = new Student("Emanuela", "Diaconu", "1991", 23456, "F");
        Student s3 = new Student("Olivia", "Roman", "1998", 34567, "f");
        Student s4 = new Student("Iosif", "Lupu", "1997", 45678, "m");
        Student s5 = new Student("Daniel", "Lupu", "1986", 56789, "m");
        Student s6 = new Student("Andrei", "Diaconu", "1993", 67890, "m");
        University university2 = new University();

        University university = new University();
        university.addStudent(s1);
        university.addStudent(s2);
        university.addStudent(s3);
        university.addStudent(s4);
        university.addStudent(s5);
        university.addStudent(s6);


        //stergere student dupoa ID
       university.deleteStudentbyID(university.studentList,56789);

        // CAUTARE STUDENTI DUPA VARSTA SI AFISAREA LOR
        university.studentsAge(41);

        //AFISARE STUDENTI DUPA NUME SAU DATA NASTERII
        university.listStudentByLastName(university.studentList);
        university.listStudentByBirthDate(university.studentList);

        // LISTA DE LA UNIVERSITATEA  IN CARE  NU ESTE NICI UN STUDENT
        university2.listStudentByBirthDate(university2.studentList);

       System.out.println(university.studentList);

    }


}
