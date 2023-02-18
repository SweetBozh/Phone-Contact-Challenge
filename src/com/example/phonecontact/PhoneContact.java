package com.example.phonecontact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneContact {
    private static final ArrayList<Contact> contactList = new ArrayList<>(); //Declare contactList to use in methods of this class
    private static final ArrayList<Messages> messageList = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Phone's contacts and Messages");
        showMenu();
    }

    private static void showMenu() {
        scanner = new Scanner(System.in);
        try { //Create New Scanner
            System.out.println("""
                    ---------------------------
                    Please select:
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
            } else {
                System.out.println("Scanner scan nothing");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    private static void manageContacts() {
        scanner = new Scanner(System.in);
        try {
            System.out.println("""
                    ---------------------------
                    Options for Manage Contacts:
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
        scanner.close();
    }

    private static void showAllContacts() {
        System.out.println("""
                --------------------------
                Contacts available:""");
        for (Contact c : contactList) {
            c.showContact();
        }
        showMenu();
    }

    private static void addNewContact() {
        scanner = new Scanner(System.in);
        try {
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
        scanner.close();
    }

    private static void searchContact() {
        scanner = new Scanner(System.in);
        try {
            boolean contactExist;
            System.out.println("""
                    ---------------------------
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

        showMenu();
        scanner.close();
    }

    private static void deleteContact() {
        scanner = new Scanner(System.in);
        List<Contact> removeList = new ArrayList<>();
        try {
            String name = "";
            boolean contactExist = false;
            System.out.println("""
                    ---------------------------
                    Please Enter Contact Name to delete:""");
            if (scanner.hasNext()) {
                name = scanner.next();
                for (Contact c : contactList) {
                    if (c.getName().equals(name)) {
                        removeList.add(c);
                        contactExist = true;
                        System.out.println(c.getName() + " was deleted");
                    }
                }
                contactList.removeAll(removeList);
                if (!contactExist) {
                    System.out.println("Contact not found !");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showMenu();
        scanner.close();
    }

    private static void manageMessages() {
        scanner = new Scanner(System.in);
        try {
            System.out.println("""
                    ---------------------------
                    Options for Manage Messages:
                    \t1. View list of all messages
                    \t2. Send a new message""");
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
        scanner.close();
    }

    private static void viewMessageList() {
        System.out.println("""
                ---------------------------
                Message List""");
        for (Messages m : messageList) {
            m.showMessage();
        }
        showMenu();
    }

    private static void sendMessage() {
        scanner = new Scanner(System.in);
        System.out.println("""
                ---------------------------
                Sending Message""");
        System.out.println("To: ");
        String destination = scanner.next();

        boolean contactExist = false;
        for (Contact c : contactList) {
            if (destination.equals(c.getName())) {
                contactExist = true;
            }
            if (contactExist) {
                System.out.println("Message: ");
                scanner.nextLine();
                String message = scanner.nextLine();
                messageList.add(new Messages(message, c));
            } else {
                System.out.println("Contact not exist");
            }
        }
        showMenu();
        scanner.close();
    }

}
