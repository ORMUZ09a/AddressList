package com.tecmilenio.ormuz;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private HashMap<String,String> contacts = new HashMap<>();

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

        for (var line : lines){
            var contactInfo = line.split(",");

            contacts.put(contactInfo[0].trim(),contactInfo[1].trim());
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

    public void list() throws IOException {
        load();
        if(contacts.size() < 1){
            System.out.println("Thre is no Contacts");
        }
        else{
            for(var contact : contacts.entrySet()){
                System.out.println(String.format("Numero: %s, Nombre: %s",
                        contact.getKey(),contact.getValue()));
            }
        }

    }

        public void create (String name, String phone) throws IOException {
            //creates new contact
            contacts.put(phone.trim(),name.trim());
            save();
            load();
        }

        public void delete (String phone) throws IOException {
            //deletes a contact
            var p = contacts.remove(phone);
            save();
            load();
        }
    }
