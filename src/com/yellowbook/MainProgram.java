package com.yellowbook;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // Create scanner and phonebook
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        // Add some profiles for testing
        phoneBook.addProfile(new Profile("Eliana", "Johansson", 25, "Eriksbergsvägen 12", "Malmö", "21145", "1201"));
        phoneBook.addProfile(new Profile("Firas", "Hammamieh", 31, "Hjalmar Söderbergs Väg 10", "Kristianstad", "29145", "1501"));

        // Start the program
        while (true) {
            System.out.println("Select user type:");
            System.out.println("1. Admin");
            System.out.println("2. Guest");
            System.out.println("3. Exit program");
            String userType = scanner.nextLine();

            // Guest user type
            if (userType.equals("2")) {
                guestActions(scanner, phoneBook);
            }
            // Admin user type
            else if (userType.equals("1")) {
                adminActions(scanner, phoneBook);
            }
            // Exit the program
            else if (userType.equals("3")) {
                System.out.println("Exiting the program...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Guest actions
    private static void guestActions(Scanner scanner, PhoneBook phoneBook) {
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Search for profile");
            System.out.println("2. Show all profiles");
            System.out.println("3. Go back");
            System.out.println("4. Exit");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter search term (first name, last name, address, or free search):");
                String searchTerm = scanner.nextLine();
                phoneBook.searchByAnyProperty(searchTerm);
            } else if (choice.equals("2")) {
                phoneBook.displayAllProfiles(); // Show all profiles
            } else if (choice.equals("3")) {
                return; // Go back to the main menu
            } else if (choice.equals("4")) {
                System.out.println("Exiting the program...");
                System.exit(0); // Exit the program
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Admin actions
    private static void adminActions(Scanner scanner, PhoneBook phoneBook) {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (password.equals("admin123")) {
            while (true) {
                System.out.println("What would you like to do?");
                System.out.println("1. Search for profile");
                System.out.println("2. Add profile");
                System.out.println("3. Remove profile");
                System.out.println("4. Update profile");
                System.out.println("5. Show all profiles");
                System.out.println("6. Go back");
                System.out.println("7. Exit");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Enter search term:");
                        String searchTerm = scanner.nextLine();
                        phoneBook.searchByAnyProperty(searchTerm);
                        break;
                    case "2":
                        addProfile(scanner, phoneBook);
                        break;
                    case "3":
                        removeProfile(scanner, phoneBook);
                        break;
                    case "4":
                        updateProfile(scanner, phoneBook);
                        break;
                    case "5":
                        phoneBook.displayAllProfiles(); // Show all profiles
                        break;
                    case "6":
                        return; // Go back to the main menu
                    case "7":
                        System.out.println("Exiting the program...");
                        System.exit(0); // Exit the program
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
        } else {
            System.out.println("Incorrect password, please try again.");
        }
    }

    // Add profile
    private static void addProfile(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter street:");
        String street = scanner.nextLine();
        System.out.println("Enter city:");
        String city = scanner.nextLine();
        System.out.println("Enter postal code:");
        String postalCode = scanner.nextLine();
        System.out.println("Enter apartment number:");
        String apartmentNumber = scanner.nextLine();

        Profile profile = new Profile(firstName, lastName, age, street, city, postalCode, apartmentNumber);
        phoneBook.addProfile(profile);
        System.out.println("Profile added by Admin.");
    }

    // Remove profile
    private static void removeProfile(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Enter first name of the profile to remove:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the profile to remove:");
        String lastName = scanner.nextLine();

        // Find profile and remove it
        Profile profileToRemove = null;
        for (Profile profile : phoneBook.getProfiles()) {
            if (profile.getFirstName().equalsIgnoreCase(firstName) && profile.getLastName().equalsIgnoreCase(lastName)) {
                profileToRemove = profile;
                break;
            }
        }

        if (profileToRemove != null) {
            phoneBook.removeProfile(profileToRemove);
            System.out.println("Profile removed.");
        } else {
            System.out.println("No profile found with that name.");
        }
    }

    // Update profile
    private static void updateProfile(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Enter first name of the profile to update:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the profile to update:");
        String lastName = scanner.nextLine();

        // Find profile for updating
        Profile profileToUpdate = null;
        for (Profile profile : phoneBook.getProfiles()) {
            if (profile.getFirstName().equalsIgnoreCase(firstName) && profile.getLastName().equalsIgnoreCase(lastName)) {
                profileToUpdate = profile;
                break;
            }
        }

        if (profileToUpdate != null) {
            System.out.println("Enter new information:");
            System.out.println("Enter first name:");
            String newFirstName = scanner.nextLine();
            System.out.println("Enter last name:");
            String newLastName = scanner.nextLine();
            System.out.println("Enter age:");
            int newAge = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter street:");
            String newStreet = scanner.nextLine();
            System.out.println("Enter city:");
            String newCity = scanner.nextLine();
            System.out.println("Enter postal code:");
            String newPostalCode = scanner.nextLine();
            System.out.println("Enter apartment number:");
            String newApartmentNumber = scanner.nextLine();

            // Create a new profile with updated data
            Profile updatedProfile = new Profile(newFirstName, newLastName, newAge, newStreet, newCity, newPostalCode, newApartmentNumber);
            phoneBook.updateProfile(profileToUpdate, updatedProfile);
            System.out.println("Profile updated.");
        } else {
            System.out.println("No profile found with that name.");
        }
    }
}
