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

    public int mainMenu() throws IOException {
        addressBook.load();
        System.out.println("-Personal Organizer-");
        System.out.println("" +
                "(1) Contact View \n" +
                "(2) Add Contacts \n" +
                "(3) Delete Contacts \n" +
                "(4) Exit");

        return sc.nextByte();
    }

    public void menuAdd() throws Exception {
        Scanner add = new Scanner(System.in);

        System.out.println("Name: ");
        String name = add.nextLine();

        System.out.println("Phone: ");
        var phone = add.nextLine();

        addressBook.create(name, phone);
    }

    public void menuDelete() throws Exception {
        System.out.printf("Phone: ");
        var phone = sc.next();

        addressBook.delete(phone);
        System.out.println();
    }

    public void menuList() throws IOException {
        addressBook.list();
        System.out.println();
    }

    private String getName() {
        var name = sc.nextLine();
        System.out.println("Name");
        return name;
    }
}

