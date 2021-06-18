package temaCollection;

import java.util.*;

public class Persoana {

    private String name;
    private int age;
    private List<Hobby> hobbyList;

    public Persoana(String name, int age) {
        this.name = name;
        this.age = age;
        this.hobbyList = new ArrayList<>();
    }

    public void addHobby(Hobby hobbies) {
        hobbyList.add(hobbies);
    }

    public void afisareHobby() {
        System.out.println("Persoana " + this.name);
        Iterator<Hobby> iterator1 = hobbyList.listIterator();
        while (iterator1.hasNext()) {
            Hobby hobby = iterator1.next();
            System.out.println("Hobby-ul : " + hobby.getName() + " + frecventa este: " + hobby.getFrequency());
        }
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", age=" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoana)) return false;
        Persoana persoana = (Persoana) o;
        return age == persoana.age && Objects.equals(name, persoana.name) && Objects.equals(hobbyList, persoana.hobbyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, hobbyList);
    }
}
