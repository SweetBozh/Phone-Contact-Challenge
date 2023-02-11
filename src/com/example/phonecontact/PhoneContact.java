package com.example.phonecontact;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneContact {
    private static final ArrayList<Contact> contactList = new ArrayList<>(); //Declare contactList to use in methods of this class

    public static void main(String[] args) {
        System.out.println("Phone's contacts and Messages");
        showMenu();
    }

    private static void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) { //Create New Scanner
            System.out.println("""
                    Please select:\s
                    \t1. Manage Contacts
                    \t2. Messages
                    \t3. Quit""");
            if (scanner.hasNext()) {
                int choice;
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> manageContacts();
                    case 2 -> manageMessages();
                    default -> {
                    } //Quit
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void manageContacts() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("""
                    Options for Manage Contacts:\s
                    \t1. Show all contacts
                    \t2. Add a new contact
                    \t3. Search for a contact
                    \t4. Delete a contact
                    \t5. Go back to the previous menu""");
            if (scanner.hasNext()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> showAllContacts();
                    case 2 -> addNewContact();
                    case 3 -> searchContact();
                    case 4 -> deleteContact();
                    default -> showMenu();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showAllContacts() {
        System.out.println("Contacts available:");
        for (Contact c : contactList) {
            c.showContact();
        }

        showMenu();
    }

    private static void addNewContact() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Adding New Contact");
            System.out.println("Name: ");
            String name = scanner.next();
            System.out.println("Phone Number: ");
            String phoneNumber = scanner.next();
            contactList.add(new Contact(name, phoneNumber));

        } catch (Exception e) {
            e.printStackTrace();
        }
        showMenu();
    }

    private static void searchContact() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean contactExist;
            System.out.println("""
                    Search Contact from
                    \t1.Name
                    \t2.Phone Number"""); //Search from number / name
            if (scanner.hasNext()) {
                int searchChoice = scanner.nextInt();
                switch (searchChoice) {
                    case 1 -> {
                        String name = "";
                        contactExist = false;
                        System.out.println("Please Enter Contact Name: ");
                        if (scanner.hasNext()) {
                            name = scanner.next();
                            for (Contact c : contactList) {
                                if (c.getName().equals(name)) {
                                    c.showContact();
                                    contactExist = true;
                                }
                            }
                            if (!contactExist) {
                                System.out.println("Contact not found !");
                            }
                        }
                    }
                    case 2 -> {
                        contactExist = false;
                        System.out.println("Please Enter Contact Phone Number:");
                        if (scanner.hasNext()) {
                            String phoneNumber = scanner.next();
                            for (Contact c : contactList) {
                                if (c.getPhoneNumber().equals(phoneNumber)) {
                                    c.showContact();
                                    contactExist = true;
                                }
                            }
                            if (!contactExist) {
                                System.out.println("Contact not found !");
                            }
                        }
                    }
                    default -> showMenu();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteContact() {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = "";
            boolean contactExist = false;
            System.out.println("Please Enter Contact Name to delete:");
            if (scanner.hasNext()) {
                name = scanner.next();
                for (Contact c : contactList) {
                    if (c.getName().equals(name)) {
                        contactList.remove(c);
                        contactExist = true;
                        System.out.println(c.getName() + " was deleted");
                    }
                }
                if (!contactExist) {
                    System.out.println("Contact not found !");
                }
            }
        } catch (Exception e) {
            System.err.println("Error Occurs");
        }
        showMenu();
    }

    private static void manageMessages() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("""
                    Options for Manage Contacts:\s
                    \t1. Show all contacts
                    \t2. Add a new contact
                    \t3. Search for a contact
                    \t4. Delete a contact
                    \t5. Go back to the previous menu""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> viewMessageList();
                case 2 -> sendMessage();
                default -> showMenu();//Quit to showMenu()
            }
        } catch (Exception e) {
            e.printStackTrace();
            manageMessages();
        }

    }

    private static void viewMessageList() {

    }

    private static void sendMessage() {

    }

}
