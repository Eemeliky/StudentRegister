package StudentReg;

import java.util.Calendar;

public final class ConstantValues {
    public static final String NO_NAME = "\"No name\"";
    public static final String NO_TITLE = "No title";
    public static final String NO_BIRTHDATE = "\"Not available\"";
    public static final String NOT_AVAILABLE = "Not available";
    public static final String INVALID_BIRTHDAY = "Invalid birthday!";
    public static final String INCORRECT_CHECKMARK = "Incorrect check mark!";
    public static final String OK = "Ok";
    public static final String GRAD_YEAR_ERROR = "Check graduation year";
    public static final String GRAD_STUDIES_ERROR = "Check amount of required credits";
    public static final String NO_CHANGE = "No change";
    public static final int MIN_STUDENT_ID = 1;
    public static final int MIN_EMP_ID = 2001;
    public static final int MAX_EMP_ID = 3000;
    public static final int MAX_STUDENT_ID = 100;
    public static final int MIN_START_YEAR = 2000;
    public static final int ID_DIVIDER = 31;
    public static final int MIN_PERIOD = 1;
    public static final int MAX_PERIOD = 5;
    public static final int BACHELOR_TYPE = 0;
    public static final int MASTER_TYPE = 1;
    public static final int OPTIONAL = 0;
    public static final int MANDATORY = 1;
    public static final int ALL = 2;
    public static final int MIN_GRADE = 0;
    public static final int MAX_GRADE = 5;
    public static final int[] MONTH_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static final char GRADE_FAILED = 'F';
    public static final char GRADE_ACCEPTED = 'A';
    public static final char[] ID_CENTURY_MARKS = {'+','-','A'};
    public static final char[] COURSE_BASES = {'A','P','S'};
    public static final String ID_VALID_CHARS = "0123456789ABCDEFHJKLMNPRSTUVWXY";
    public static final double MIN_CREDITS = 0.0;
    public static final double BACHELOR_CREDITS = 180.0;
    public static final double MASTER_CREDITS = 120.0;
    public static final double MAX_COURSE_CREDITS = 55.0;
    public static final double BACHELOR_MANDATORY = 150.0;
    public static final double MASTER_MANDATORY = 50.0;

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
