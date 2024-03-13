package StudentReg;

import static StudentReg.ConstantValues.ID_CENTURY_MARKS;
import static StudentReg.ConstantValues.ID_VALID_CHARS;
import static StudentReg.ConstantValues.MONTH_DAYS;

public class PersonID {
    private String birthDate = ConstantValues.NO_BIRTHDATE;

    public String getBirthDate() {
        return birthDate;
    }

    public String setPersonId(final String personID) {
        if (personID != null) {
            boolean validIDNumber = checkPersonIDNumber(personID);
            if (validIDNumber) {
                int century = 1800;
                for (int i = 0; i < ID_CENTURY_MARKS.length; i++) {
                    if (personID.charAt(6) == ID_CENTURY_MARKS[i]) {
                        century += 100 * i;
                        break;
                    }
                }
                century += Integer.parseInt(personID.substring(4, 6));
                String date = String.format("%s.%s.%d", personID.substring(0, 2), personID.substring(2, 4), century);
                boolean validBirthdate = checkBirthdate(date);
                if (validBirthdate) {
                    boolean validIDCharacter = checkValidCharacter(personID);
                    if (validIDCharacter) {
                        birthDate = date;
                        return ConstantValues.OK;
                    }
                    return ConstantValues.INCORRECT_CHECKMARK;
                }
            }
        }
        return ConstantValues.INVALID_BIRTHDAY;
    }

    private boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            return !(year % 100 == 0 && year % 400 != 0);
        }
        return false;
    }

    private boolean checkBirthdate(final String date) {
        String[] tmp = date.split("\\.");
        int day = Integer.parseInt(tmp[0]);
        int month = Integer.parseInt(tmp[1]);
        int year = Integer.parseInt(tmp[2]);
        if (0 < year && 0 < month && month < 13) {
            boolean leapYear = checkLeapYear(year);
            int monthDays = MONTH_DAYS[month - 1];
            if (leapYear && month == 2) {
                monthDays = 29;
            }
            return (0 < day && day <= monthDays);
        }
        return false;
    }

    private boolean checkPersonIDNumber(final String personID) {
        if (personID.length() == 11) {
            char centuryChar = personID.charAt(6);
            for (char idCenturyMark : ID_CENTURY_MARKS) {
                if (centuryChar == idCenturyMark) {
                    return true;
                }
            }
        }
        return false;
    }

    private int parseID(final String personID) {
        // Method to change personID's first 9 numbers to integer
        String tmp = personID.substring(0, personID.length() - 1);
        StringBuilder sb = new StringBuilder(tmp);
        sb.deleteCharAt(6);
        return Integer.parseInt(sb.toString());
    }

    private boolean checkValidCharacter(final String personID) {
        char IDLastChar = personID.charAt(personID.length() - 1);
        int numerator = parseID(personID);
        int remainder = numerator % ConstantValues.ID_DIVIDER;
        return IDLastChar == ID_VALID_CHARS.charAt(remainder);
    }

}
