package temaOOP2;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Clasa ce contine
 * lista contacte
 * extinde clasa  Samsung
 * implementeaza metoda phone
 */
public class SamsungJ5 extends Samsung {
    final private int IMEI;
    private Contact[] listContacts;


     // Constructor

    public SamsungJ5(String name, String color, String material, int imei) {
        super(name, color, material);
        this.IMEI = imei;
        listContacts = new Contact[0];
    }


     // Metoda adaugare un nou contact la lista

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
            System.out.println("Nu poti adauga contacte daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


    //Metoda afisare list5a contacte that display the list of contacts

    @Override
    public void listContacts() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    System.out.println(contact.getFirstName());
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti afisa contactele daca " + getName() + " e oprit. Deschide-l! ");
        }
    }

     //Metoda trimitere masaj la un nr specific din lista de contacte

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
                System.out.println("trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti trimite mesaj daca" + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda afisare lista mesaje de la un nr specific

    @Override
    public void listMessages(int phoneNumber) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    if (contact.getPhoneNumber() == phoneNumber) {
                        for (Message message : contact.getListmessage()) {
                            System.out.println("Numarul : " + contact.getPhoneNumber() + " - " + message.getMessage());
                        }
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti afisa mesajele daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda ce apeleaza un nr specific din lista de contacte

    @Override
    public void call(int phoneNumber) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    if (contact.getPhoneNumber() == phoneNumber) {
                        Call call = new Call(phoneNumber);
                        contact.setCallHistory(call);
                        System.out.println("Se apeleaza numarul: " + call.getPhoneNumber());
                        setBatteryLife(getBatteryLife() - 2);
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti suna daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda ce afiseaza lista de apleuri

    @Override
    public void callHistory() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    for (Call call : contact.getCallHistory()) {
                        System.out.println("Numarul : " + call.getPhoneNumber());
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti vedea istoricul de apeluri daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda afesare baterie


    @Override
    public void viewBattery() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                System.out.println("Nivelul bateriei este: " + getBatteryLife());
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti vedea nivelul bateriei daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda incarcare bateire in ore

    @Override
    public void charge(int chargedHours) {
        if (getBatteryLife() <= 10 && getBatteryLife() >= 0) {
            if (chargedHours + getBatteryLife() <= 10) {
                setBatteryLife(getBatteryLife() + chargedHours);
                System.out.println("Ai incarcat bateria: " + chargedHours + " ore");
            } else {
                System.out.println("Baterie plina!");
            }
        }
    }


     // Metoda deschidere baterie

    @Override
    public void turnOn() {
        if (getBatteryLife() > 0) {
            setOn(true);
            System.out.println("Acum deschizi " + getName());
        } else {
            System.out.println("Incarca  " + getName());
        }
    }


     //Metoda inchidere telefon

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Acum inchizi " + getName());
    }
}
