package com.yellowbook;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        User currentUser = null;

        // Log in menu
        while (currentUser == null) {
            System.out.println("Welcome to the Yellow Book!");
            System.out.println("1. Log in as Admin");
            System.out.println("2. Log in as Guest");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Admin username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Admin password: ");
                    String password = scanner.nextLine();
                    if ("Admin".equals(username) && "12345".equals(password)) {
                        currentUser = new Admin(username, password);
                        System.out.println("Logged in as Admin.");
                    } else {
                        System.out.println("Invalid Admin credentials. Try again.");
                    }
                }
                case 2 -> {
                    currentUser = new Guest("Guest", "guest123");
                    System.out.println("Logged in as Guest.");
                }
                default -> System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }

        // Main menu
        while (true) {
            if (currentUser instanceof Admin) {
                System.out.println("\nChoose an action: ");
                System.out.println("1. Add Profile");
                System.out.println("2. Update Profile");
                System.out.println("3. Delete Profile");
                System.out.println("4. Search Profiles");
                System.out.println("5. Exit");
            } else {
                System.out.println("\nChoose an action: ");
                System.out.println("4. Search Profiles");
                System.out.println("5. Exit");
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> {
                    if (currentUser instanceof Admin) addProfile(phoneBook, scanner);
                    else System.out.println("Access denied.");
                }
                case 2 -> {
                    if (currentUser instanceof Admin) updateProfile(phoneBook, scanner);
                    else System.out.println("Access denied.");
                }
                case 3 -> {
                    if (currentUser instanceof Admin) deleteProfile(phoneBook, scanner);
                    else System.out.println("Access denied.");
                }
                case 4 -> searchProfile(phoneBook, scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProfile(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Profile profile = new Profile(firstName, lastName, address, phoneNumber);
        phoneBook.addProfile(profile);
        System.out.println("Profile added successfully!");
    }

    private static void updateProfile(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Enter last name of profile to update: ");
        String lastName = scanner.nextLine();
        Profile existingProfile = phoneBook.getProfileByLastName(lastName);

        if (existingProfile != null) {
            System.out.println("Current Profile: " + existingProfile);
            System.out.print("Enter new first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String newLastName = scanner.nextLine();
            System.out.print("Enter new address: ");
            String address = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();

            Profile updatedProfile = new Profile(firstName, newLastName, address, phoneNumber);
            phoneBook.updateProfile(lastName, updatedProfile);
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Profile not found.");
        }
    }

    private static void deleteProfile(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Enter last name of profile to delete: ");
        String lastName = scanner.nextLine();
        phoneBook.deleteProfile(lastName);
        System.out.println("Profile deleted successfully!");
    }

    private static void searchProfile(PhoneBook phoneBook, Scanner scanner) {
        System.out.println("Search by: ");
        System.out.println("1. Last Name");
        System.out.println("2. Address");
        System.out.print("Your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1 -> {
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                Profile profile = phoneBook.getProfileByLastName(lastName);
                if (profile != null) {
                    System.out.println("\nProfile found: ");
                    System.out.println("----------------------------");
                    System.out.printf("| %-15s | %-15s | %-20s | %-15s |\n", "First Name", "Last Name", "Address", "Phone Number");
                    System.out.println("----------------------------");
                    System.out.printf("| %-15s | %-15s | %-20s | %-15s |\n", profile.getFirstName(), profile.getLastName(), profile.getAddress(), profile.getPhoneNumber());
                    System.out.println("----------------------------");
                } else {
                    System.out.println("No profile found with that last name.");
                }
            }
            case 2 -> {
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                Profile profile = phoneBook.getProfileByAddress(address);
                if (profile != null) {
                    System.out.println("\nProfile found: ");
                    System.out.println("----------------------------");
                    System.out.printf("| %-15s | %-15s | %-20s | %-15s |\n", "First Name", "Last Name", "Address", "Phone Number");
                    System.out.println("----------------------------");
                    System.out.printf("| %-15s | %-15s | %-20s | %-15s |\n", profile.getFirstName(), profile.getLastName(), profile.getAddress(), profile.getPhoneNumber());
                    System.out.println("----------------------------");
                } else {
                    System.out.println("No profile found with that address.");
                }
            }
            default -> System.out.println("Invalid input. Please try again.");
        }
    }
}
