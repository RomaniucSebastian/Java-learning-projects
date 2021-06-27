package temaCollection;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lista dupa varsta:");
        afisare(initializareListaDupaVarsta());

        System.out.println("Lista dupa nume:");
        afisare(initializareListaDupaNume());

        Persoana persoana1 = new Angajat("Alin", 35);
        persoana1.setHobbyList(initializareHobbyuri1());

        Persoana persoana2 = new Angajat("Maria", 28);
        persoana2.setHobbyList(initializareHobbyuri2());

        Map<Persoana, List<Hobby>> listMap = new HashMap<>();
        listMap.put(persoana1, persoana1.getHobbyList());
        listMap.put(persoana2, persoana2.getHobbyList());

        afisareHobbyuriPersDinMap(persoana1, listMap);
    }


    private static void afisareHobbyuriPersDinMap(Persoana persoana, Map<Persoana, List<Hobby>> listMap) {
        System.out.println("Nume este: " + persoana.getName());
        for (Persoana persoana1 : listMap.keySet()) {
            if (persoana1.equals(persoana)) {
                for (Hobby hobby : persoana1.getHobbyList()) {
                    System.out.println("Hobby-ul  <" + hobby.getName() + "> intalnit in : " + hobby.getTaraList());
                }
            }
        }
    }


    private static List<Hobby> initializareHobbyuri1() {
        List<Hobby> hobbyList = new ArrayList<>();
        Hobby hobby1 = new Hobby("surf", 10);
        hobby1.addAdresa("Hameiului 22");
        hobby1.addAdresa("Unirii 34");
        hobby1.addTara("Franta");
        hobby1.addTara("Ungaria");

        Hobby hobby2 = new Hobby("Vanatoare", 50);
        hobby2.addAdresa("Minerva 23");
        hobby2.addAdresa("Mircea Zaciu 17");
        hobby2.addTara("Romania");
        hobby2.addTara("Rusia");

        hobbyList.add(hobby1);
        hobbyList.add(hobby2);

        return hobbyList;
    }


    private static List<Hobby> initializareHobbyuri2() {
        List<Hobby> hobbyList = new LinkedList<>();
        Hobby hobby3 = new Hobby("Jogging", 100);
        hobby3.addAdresa("Tavernelor");
        hobby3.addAdresa("Observator");
        hobby3.addTara("Grecia");
        hobby3.addTara("Norvegia");

        Hobby hobby2 = new Hobby("Pescuit", 500);
        hobby2.addAdresa("Bucium 3");
        hobby2.addAdresa("Mihai Viteazu 4");
        hobby2.addTara("Germania");
        hobby2.addTara("India");

        hobbyList.add(hobby2);
        hobbyList.add(hobby3);

        return hobbyList;
    }


    public static void afisare(Set<Persoana> lista) {
        Iterator<Persoana> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Persoana persoana = iterator.next();
            System.out.println("Nume: " + persoana.getName());
            System.out.println("Varsta: " + persoana.getAge());
        }
    }


    public static Set<Persoana> initializareListaDupaVarsta() {
        TreeSet<Persoana> lista = new TreeSet<Persoana>(new PersoanaAgeComparator());

        Persoana persoana1 = new Angajat("Alin", 35);
        Persoana persoana2 = new Angajat("Maria", 28);
        Persoana persoana3 = new Angajat("Cosmin", 32);
        Persoana persoana4 = new Student("Nicu", 72);
        Persoana persoana5 = new Student("Ioana", 53);
        Persoana persoana6 = new Somer("Ema", 47);
        Persoana persoana7 = new Somer("Marcel", 21);

        lista.add(persoana1);
        lista.add(persoana2);
        lista.add(persoana3);
        lista.add(persoana4);
        lista.add(persoana5);
        lista.add(persoana6);
        lista.add(persoana7);

        return lista;
    }


    public static TreeSet<Persoana> initializareListaDupaNume() {
        TreeSet<Persoana> lista = new TreeSet<>(new PersoanaNameComparator());

        lista.add(new Angajat("Alin", 35));
        lista.add(new Angajat("Maria", 28));
        lista.add(new Angajat("Cosmin", 32));
        lista.add(new Student("Nicu", 72));
        lista.add(new Student("Ioana", 53));
        lista.add(new Somer("Ema", 47));
        lista.add(new Somer("Marcel", 21));

        return lista;
    }
}

