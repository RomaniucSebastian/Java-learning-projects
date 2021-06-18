package temaOOP2;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Clasa ce contine
 * lista de contacte
 * extinde clasa Samsung
 * implementeaza metoda phone
 */
public class SamsungGalaxyS10 extends Samsung {
    final private int IMEI;
    private Contact[] listContacts;


     // Constructor

    public SamsungGalaxyS10(String name, String color, String material, int imei) {
        super(name, color, material);
        IMEI = imei;
        listContacts = new Contact[0];
    }


     // Metoda ce adauga un noua contact in lista

    @Override
    public void addContact(int id, int phoneNumber, String firstName, String lastName) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                Contact contact = new Contact(id, phoneNumber, firstName, lastName);
                listContacts = ArrayUtils.add(listContacts, contact);
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti adauga un nou contact daca  " + getName() + " e oprit . Deschide-l! ");
        }
    }


      //Metoda afisare lista contacte

    @Override
    public void listContacts() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    System.out.println(contact.getFirstName());
                }
            } else {
                System.out.println("Trebuie sa incarci: " + getName());
            }
        } else {
            System.out.println("Nu poti afisa contactele daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


      //Metoda ce trimite un mesaj la un numar specific din lista de contacte

    @Override
    public void sendMessage(int phoneNumber, String msg) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                if (msg.length() < 500) {
                    for (Contact contact : listContacts) {
                        if (phoneNumber == contact.getPhoneNumber()) {
                            Message message = new Message(msg);
                            contact.setListmessage(message);
                            setBatteryLife(getBatteryLife() - 1);
                        }
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti trimite mesaj daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


      // Metoda ce afiseaja lista de mesaje de la un numar specific

    @Override
    public void listMessages(int phoneNumber) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    if (contact.getPhoneNumber() == phoneNumber) {
                        for (Message message : contact.getListmessage()) {
                            System.out.println("Numarul de telefon : " + contact.getPhoneNumber() + " - " + message.getMessage());
                        }
                    }
                }
            } else {
                System.out.println("trebuie sa incarci" + getName());
            }
        } else {
            System.out.println("Nu poti afisa mesaj daca " + getName() + " e oprit. SDeschide-l! ");
        }
    }


     // Metoda apelare la un nr specific din lista

    @Override
    public void call(int phoneNumber) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    if (contact.getPhoneNumber() == phoneNumber) {
                        Call call = new Call(phoneNumber);
                        contact.setCallHistory(call);
                        System.out.println("Se apeleaza: " + call.getPhoneNumber());
                        setBatteryLife(getBatteryLife() - 2);
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti apela daca " + getName() + " e oprit . Deschide-l! ");
        }
    }


    // Metoda afisare lista apekuri

    @Override
    public void callHistory() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    for (Call call : contact.getCallHistory()) {
                        System.out.println("Numar telefon: " + call.getPhoneNumber());
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti vedea istoricul de apeluri daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


      //Metoda afisare nivel baterie

    @Override
    public void viewBattery() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                System.out.println("Nivelul bateriei este: " + getBatteryLife());
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti vedea nivelul bateriei daca " + getName() + "e oprit. Deschide-l! ");
        }
    }


     // Metoda incarcare baterie in ore

     @Override
    public void charge(int chargedHours) {
        if (getBatteryLife() <= 10 && getBatteryLife() >= 0) {
            if (chargedHours + getBatteryLife() <= 10) {
                setBatteryLife(getBatteryLife() + chargedHours);
                System.out.println("Ai incarcat: " + chargedHours + " ore");
            } else {
                System.out.println("Baterie plina!");
            }
        }
    }


     // Metoda deschidere telefon

    @Override
    public void turnOn() {
        if (getBatteryLife() > 0) {
            setOn(true);
            System.out.println("Acum  deschizi " + getName());
        } else {
            System.out.println("Incarca " + getName());
        }
    }


     // Metoda inchidere telefon

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Acum inchizi " + getName());
    }
}