package temajava8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\User\\domnu\\Desktop\\JavaHomework\\TemeJavaGrupa6\\src\\main\\resources\\table.cvs");
        FileWriter fileWriter = new FileWriter("C:\\User\\domnu\\Desktop\\JavaHomework\\TemeJavaGrupa6\\src\\main\\resources\\newtable.cvs");
        Person.orderByMonthOfBirth(fileReader,"02",fileWriter);
    }
}
