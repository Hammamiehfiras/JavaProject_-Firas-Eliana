package com.yellowbook;

public class Profile {
    private String firstName;
    private String lastName;
    private int age;
    private String street;
    private String city;
    private String zipCode;
    private String apartmentNumber; // Added for apartment number
    private String id;

    // Konstruktor
    public Profile(String firstName, String lastName, int age, String street, String city, String zipCode, String apartmentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.apartmentNumber = apartmentNumber;
        this.id = generateProfileId(); // Generate a unique ID
    }

    // Getter och Setter
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getZipCode() { return zipCode; }
    public String getApartmentNumber() { return apartmentNumber; }
    public String getId() { return id; }

    // Generera ett unikt ID för varje profil
    private String generateProfileId() {
        return this.firstName.substring(0, 1) + this.lastName.substring(0, 1) + (int)(Math.random() * 1000);
    }
    @Override
    public String toString() {
        return String.format(
                "+----------------------------------------------+\n" +
                        "| %-12s: %-30s|\n" +  // Profile ID
                        "| %-12s: %-30s|\n" +  // Name
                        "| %-12s: %-30d|\n" +  // Age
                        "| %-12s: %-30s|\n" +  // Street
                        "| %-12s: %-30s|\n" +  // City
                        "| %-12s: %-30s|\n" +  // Zip Code
                        "| %-12s: %-30s|\n" +  // Apartment
                        "+----------------------------------------------+",
                "Profile ID", id,
                "Name", firstName + " " + lastName,
                "Age", age,
                "Street", street,
                "City", city,
                "Zip Code", zipCode,
                "Apartment", apartmentNumber
        );
    }


    // Jämför profiler för att förhindra duplicering
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Profile profile = (Profile) obj;
        return firstName.equals(profile.firstName) && lastName.equals(profile.lastName) && street.equals(profile.street) && city.equals(profile.city);
    }

    // HashCode metod för att möjliggöra korrekt jämförelse och användning i datastrukturer
    @Override
    public int hashCode() {
        return 31 * firstName.hashCode() + lastName.hashCode() + street.hashCode() + city.hashCode();
    }
}
