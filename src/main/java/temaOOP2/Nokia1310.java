package temaOOP2;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Clasa ce :
 * contine lisat contacte,
 * extinde  clasa(Nokia)
 */
public class Nokia1310 extends Nokia {
    final private int IMEI;
    private Contact[] listContacts;

    /**
     * Contructor
     *   name of the phone
     *   color of the phone
     *  material of the phone
     * imei of the phone
     */
    public Nokia1310(String name, String color, String material, int imei) {
        super(name, color, material);
        IMEI = imei;
        listContacts = new Contact[0];
    }


     //Methoda adaugare contact la lista

    @Override
    public void addContact(int id, int phoneNumber, String firstName, String lastName) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                Contact contact = new Contact(id, phoneNumber, firstName, lastName);
                listContacts = ArrayUtils.add(listContacts, contact);
            } else {
                System.out.println("Trebuie sa-ti incarci " + getName());
            }
        } else {
            System.out.println("Nu poti adauga contacte daca  " + getName() + " e oprit. Deschide-l! ");
        }
    }

    //metoda afisare lista contacte
    @Override
    public void listContacts() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    System.out.println(contact.getFirstName());
                }
            } else {
                System.out.println("Trebuie sa-ti incarci " + getName());
            }
        } else {
            System.out.println("Nu poti afisa contactele daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


    //metoda  mesaj la un nr specific din lista
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
                System.out.println("Trebuie sa-ti incarci " + getName());
            }
        } else {
            System.out.println("Nu poti sa trimiti mesaj daca " + getName() + " e oprit. Deschide-l! ");
        }
    }


     //metoda afisare lista mesaje de la un numar specific din lista
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
                System.out.println("Trebuie sa-ti incarci  " + getName());
            }
        } else {
            System.out.println("Nu poti afisa mesajele daca " + getName() + " e oprit . Deschide-l! ");
        }
    }


     // Metoda ce suna un nr specific din lista de contacte

    @Override
    public void call(int phoneNumber) {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    if (contact.getPhoneNumber() == phoneNumber) {
                        Call call = new Call(phoneNumber);
                        contact.setCallHistory(call);
                        System.out.println(" apelezi numarul: " + call.getPhoneNumber());
                        setBatteryLife(getBatteryLife() - 2);
                    }
                }
            } else {
                System.out.println(" Trebuie sa incarci  " + getName());
            }
        } else {
            System.out.println("Nu poti Suna daca  " + getName() + " e oprit . Deschide-l! ");
        }
    }


     // Metoda ce afiseaja lista de apeluri

    @Override
    public void callHistory() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                for (Contact contact : listContacts) {
                    for (Call call : contact.getCallHistory()) {
                        System.out.println("Numar Telefon: " + call.getPhoneNumber());
                    }
                }
            } else {
                System.out.println("Incarca telefonul " + getName());
            }
        } else {
            System.out.println("NU poti vedea arhiva istorica daca  " + getName() + " e oprit . Descide-l! ");
        }
    }


    // Metoda afisare nivel baterie

    @Override
    public void viewBattery() {
        if (isOn() == true) {
            if (getBatteryLife() > 0) {
                System.out.println("nivelul tau de baterie este: " + getBatteryLife());
            } else {
                System.out.println("Trebuie sa-ti incarci " + getName());
            }
        } else {
            System.out.println("Nu poti sa vezi nivelul bateriei daca " + getName() + " e oprit. Deschide-l! ");
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
                System.out.println("Baterie Plina!");
            }
        }
    }


     //Metoda deschidere telefon

    @Override
    public void turnOn() {
        if (getBatteryLife() > 0) {
            setOn(true);
            System.out.println("Acum pornesti " + getName() );
        } else {
            System.out.println("Incarca" + getName());
        }
    }


     // Metoda inchidere telefon

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Acum inchizi " + getName());
    }
}
