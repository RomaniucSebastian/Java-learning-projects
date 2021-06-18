package temaOOP2;

public class Main {
    public static void main(String[] args) {

        //Samsungj5


        //creez telefonul
        Phone firstPhone = new SamsungJ5("SamsungJ5", "Alb", "Metal", 13467356);
        // deschid telefon
        firstPhone.turnOn();

        // add cointact
        firstPhone.addContact(1, 12343441, "Sebastian", "Romaniuc");
        firstPhone.addContact(2, 15523662, "Ema", "Rotariu");
        //afisare   TOATE nr  la acest tel
        firstPhone.listContacts();

        //trimit mesaj la acest tel
        firstPhone.sendMessage(12343441, "Salut!");

        // afisej Toate mesajele acest tel
        firstPhone.listMessages(12343441);

        //trimitere din nou mesaje
        firstPhone.sendMessage(15523662, "Ema, m-am bucurat sa te cunosc astazi!");
        firstPhone.sendMessage(15523662, "Daca e poate, as vrea sa mai discutam cand ai tu timp");
        firstPhone.listMessages(15523662);

        //apelare nr tel
        firstPhone.call(12343441);
        firstPhone.call(15523662);
        firstPhone.call(15523662);

        //afisare arhiva istorica apeluri
        firstPhone.callHistory();

        //verificare nivel barerie
        firstPhone.viewBattery();

        // incarcare telefon
        firstPhone.charge(10);
        firstPhone.viewBattery();

        //inchidere telefon
        firstPhone.turnOff();

        //SamsungGalaxyS10
        Phone secondPhone = new SamsungGalaxyS10("SamsungGalaxyS10", "Negru", "Metal si plastic", 9573243);

        secondPhone.addContact(1, 1345, "Maria", "Popescu");
        secondPhone.addContact(2, 1400, "Ion", "Lopataru");
        secondPhone.listContacts();

        secondPhone.sendMessage(1345, "Sa nu uiti sa paltesti intretinerea Maria");
        secondPhone.listMessages(1345);

        secondPhone.sendMessage(1400, "Maine ai o programare la dentist  pe numele Ion Lopataru");
        secondPhone.listMessages(1400);

        secondPhone.call(1345);
        secondPhone.callHistory();

        secondPhone.viewBattery();
        secondPhone.charge(5);
        secondPhone.viewBattery();

        //Nokia1310
        Phone thirdPhone = new Nokia2021("Nokia1310", "Albastru", "Plastic si sticla", 231124);
        thirdPhone.turnOn();

        thirdPhone.addContact(1, 225, "Alexandru", "Macedon");
        thirdPhone.addContact(2, 336, "Narcis", "Abazei");
        thirdPhone.listContacts();

        thirdPhone.sendMessage(225, "Ai un nume interesant Alex.");
        thirdPhone.listMessages(225);

        thirdPhone.sendMessage(336, "Narcis, sa nu uiti ca maine e ultima zi pentru depunerea actelor");
        thirdPhone.listMessages(336);

        thirdPhone.call(335);
        thirdPhone.callHistory();

        thirdPhone.viewBattery();
        thirdPhone.charge(3);
        thirdPhone.viewBattery();

        thirdPhone.turnOff();

        //Nokia2021
        Phone fourthPhone = new Nokia1310("Nokia1310", "Albasteru inchis", "Plastic si aluminiu", 233211124);
        fourthPhone.turnOn();

        fourthPhone.addContact(1, 447, "Olivia", "Hlamaga");
        fourthPhone.addContact(2, 558, "Cornelia", "Gherman");
        fourthPhone.listContacts();

        fourthPhone.sendMessage(447, "Olivia, sa nu uiti ca maine e ziua de nastere a Corneliei. Te rog sa ii cumperi un cadou !");
        fourthPhone.listMessages(447);

        fourthPhone.sendMessage(558, "Salut Cornelia! Ai putea maine seara sa treci pe la mine ? !");
        fourthPhone.listMessages(558);

        fourthPhone.call(447);
        fourthPhone.callHistory();

        fourthPhone.viewBattery();
        fourthPhone.charge(2);
        fourthPhone.viewBattery();

        fourthPhone.turnOff();
    }
}
