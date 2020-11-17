package com.tecmilenio.ormuz;

import java.io.IOException;
import java.util.Scanner;

public class MenuSchedule {
    private Scanner sc;
    private AddressBook addressBook;

    public MenuSchedule(Scanner sc) {
        this.sc = sc;
        addressBook = new AddressBook();
    }

    public  int mainMenu() throws IOException {
        addressBook.load();
        System.out.println("---------------Personal Organizer---------------");
        System.out.println("" +
                "(1) Contact View \n" +
                "(2) Add Contacts \n" +
                "(3) Delete Contacts \n" +
                "(4) Exit");

        return sc.nextByte();
    }

    public void menuAdd() throws Exception {
        System.out.printf("Name: ");
        var nombre = sc.next();

        System.out.printf("Numero: ");
        var telefono = sc.next();

        addressBook.create(nombre,telefono);
        System.out.println();
    }

    public void menuDelete() throws Exception {
        System.out.printf("Numero: ");
        var telefono = sc.next();

        addressBook.delete(telefono);
        System.out.println();
    }

    public void menuList() {
        addressBook.list();
        System.out.println();
    }
}
