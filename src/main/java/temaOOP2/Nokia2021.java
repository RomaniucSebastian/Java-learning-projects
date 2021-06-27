package temaOOP2;

import org.apache.commons.lang3.ArrayUtils;

/**
 * clasa ce contine :
 * lista contacte
 * extinde clasa generala nokia
 * implementeaza phone methods
 */

public class Nokia2021 extends Nokia {
    final private int IMEI;
    private Contact[] listContacts;

    /**
         Constructor
     name of the phone
     color of the phone
     material of the phone
     imei of the phone
     */

    public Nokia2021(String name, String color, String material, int imei) {
        super(name, color, material);
        IMEI = imei;
        listContacts = new Contact[0];
    }



     // Metoda adaugare contacte in lista

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
            System.out.println("Nu poti adauga contacte daca  " + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda afisare lista contacte

    @Override
    public void listContacts() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    System.out.println(contact.getFirstName());
                }
            } else {
                System.out.println("trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti afisa contactele daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda adaugare mesaj la un nr specific

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


     //Metoda afisare mesaje de la un numar specific

    @Override
    public void listMessages(int phoneNumber) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    if (contact.getPhoneNumber() == phoneNumber) {
                        for (Message message : contact.getListmessage()) {
                            System.out.println("Numarul de telefon este: " + contact.getPhoneNumber() + " - " + message.getMessage());
                        }
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci  " + getName());
            }
        } else {
            System.out.println("Nu poti afisa mesajele daca" + getName() + " e oprit. Descide-l! ");
        }
    }


     // Metoda apelare un numar specific di lista de contacte

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
            System.out.println("Nu poti sina daca " + getName() + " e oprit. deschide-l! ");
        }
    }


     // Metoda afisare lista apeluri

    @Override
    public void callHistory() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    for (Call call : contact.getCallHistory()) {
                        System.out.println("Numar de telefon: " + call.getPhoneNumber());
                    }
                }
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti sa vezi lista de apeluri daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


     // Metoda afisare nivel baterie

    @Override
    public void viewBattery() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                System.out.println("Nivelul bateriei este: " + getBatteryLife());
            } else {
                System.out.println("Trebuie sa incarci " + getName());
            }
        } else {
            System.out.println("Nu poti sa vezi nivelul bateriei daca " + getName() + " e oprit . Deschide-l! ");
        }
    }


     // Metoda incarcare in ore

    @Override
    public void charge(int chargedHours) {
        if (getBatteryLife() <= 10 && getBatteryLife() >= 0) {
            if (chargedHours + getBatteryLife() <= 10) {
                setBatteryLife(getBatteryLife() + chargedHours);
                System.out.println("Ai incarcat : " + chargedHours + " ore");
            } else {
                System.out.println("Baterie  plina!");
            }
        }
    }


     // Metoda deschidere telefon

    @Override
    public void turnOn() {
        if (getBatteryLife() > 0) {
            setOn(true);
            System.out.println("Acum deschizi" + getName());
        } else {
            System.out.println("Incarca " + getName());
        }
    }


      //Metoda ce inchide telefonul

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Acum inchizi" + getName());
    }
}
