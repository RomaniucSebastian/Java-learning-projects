package temaCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hobby {
    private String name;
    private int frequency;
    private List<Adresa> adresaList;
    private List<Tara> taraList;

    public Hobby(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
        adresaList = new ArrayList<>();
        taraList = new ArrayList<>();
    }

    public void addAdresa(String numeAdresa) {
        Adresa adresa = new Adresa(numeAdresa);
        adresaList.add(adresa);
    }

    public void addTara(String numeTara) {
        Tara tara = new Tara(numeTara);
        taraList.add(tara);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<Tara> getTaraList() {
        return taraList;
    }

    @Override
    public String toString() {
        return "Hobby " + name + " frecventa " + frequency +
                ", adresaList=" + adresaList +
                ", taraList=" + taraList;
    }
}
