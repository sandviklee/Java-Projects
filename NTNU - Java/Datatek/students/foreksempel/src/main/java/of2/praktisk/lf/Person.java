package of2.praktisk.lf;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
    private String phoneNumber;

    public Person(String firstName, String lastName, LocalDateTime birthDate, String phoneNumber) {
        this.requireValidBirthDate(birthDate);
        this.requireValidPhoneNumber(phoneNumber);

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    // Hjelpemetoder

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.requireValidPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(this.getBirthDate(), LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Person [birthDate=" + birthDate +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + this.getAge() +
                ", phoneNumber=" + phoneNumber + "]";
    }

    private void requireValidBirthDate(LocalDateTime birthDate) {
        if (!birthDate.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Personen er ikke født???");
        }
    }

    private void requireValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8 || !this.isAllDigit(phoneNumber)) {
            throw new IllegalArgumentException("Ugyldig telefonnummer " + phoneNumber);
        }
    }

    private boolean isAllDigit(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
}
