package com.tecmilenio.ormuz;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook {

    private HashMap<String, Contact> contacts = new HashMap<>();

    public void load() throws IOException {
        //Saves contacts of the file
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%stecmilenio%sormuz%scontacts.csv",separator, separator, separator, separator);
        Path path = Paths.get(fileName);

        ArrayList<String> lines = new ArrayList<>();

        if (!Files.exists(path)) {
            File file = new File(String.valueOf(path));
            file.createNewFile();
        }

        lines = (ArrayList<String>) Files.readAllLines(path);

        for (var line : lines) {
            var contactInfo = line.split(",");
            var contact = new Contact(contactInfo[1], contactInfo[0]);
            contacts.put(contact.getPhone(), contact);
        }
    }

        public void save () throws IOException {
            //Saves chances of the file
            String separator = FileSystems.getDefault().getSeparator();
            String fileName = String.format("src%scom%stecmilenio%sormuz%scontacts.csv",separator, separator, separator, separator);
            Path path = Paths.get(fileName);

            ArrayList<String> saveContacts = new ArrayList<>();
            for (var contact : contacts.entrySet()) {
                saveContacts.add(contact.getKey() + ", " + contact.getValue());
            }

            Files.write(path, saveContacts);
        }


        public void list() {
            //shows contacts od the address book
            for(var contact : contacts.entrySet()){
                System.out.println(String.format("Number: %s, Name: %s",
                    contact.getKey(),contact.getValue().getName()));
            }
        }

        public void create (String name, String phone) throws IOException {
            //creates new contact
            Contact contact = new Contact(name, phone);
            contacts.put(phone,contact);
            save();
            load();
        }

        public void delete (String phone) throws IOException {
            //deletes a contact
            contacts.remove(phone);
            save();
            load();
        }
    }
