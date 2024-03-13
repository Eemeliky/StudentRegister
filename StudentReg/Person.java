package StudentReg;

import java.util.Random;

public abstract class Person {
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NO_BIRTHDATE;

    public Person(String lastName, String firstName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String setBirthDate(String personId) {
        if (personId != null) {
            PersonID tmp = new PersonID();
            String flag = tmp.setPersonId(personId);
            if (flag.equals(ConstantValues.OK)) {
                birthDate = tmp.getBirthDate();
                return birthDate;
            }
        }
        return ConstantValues.NO_CHANGE;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    protected int getRandomId(final int min, final int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public abstract String getIdString();
}
