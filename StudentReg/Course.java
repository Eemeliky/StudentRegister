package StudentReg;

import java.util.Locale;

public class Course {

    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private char courseBase = ' ';
    private int courseType = ConstantValues.OPTIONAL;
    private int period = 0;
    private double credits = ConstantValues.MIN_CREDITS;
    private boolean numericGrade;

    public Course() {
    }

    public Course(String name, final int code, Character courseBase,
                  final int type, final int period, final double credits,
                  boolean numericGrade){
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }

    public Course(Course course) {
        String courseCode = course.getCourseCode();
        courseCode = courseCode.substring(0,courseCode.length() - 1);
        int courseCodeInt = Integer.parseInt(courseCode);
        setName(course.getName());
        setCourseCode(courseCodeInt, course.getCourseBase());
        setCourseType(course.getCourseType());
        setPeriod(course.getPeriod());
        setCredits(course.getCredits());
        setNumericGrade(course.isNumericGrade());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getCourseTypeString() {
        return (courseType == ConstantValues.MANDATORY) ? "Mandatory" : "Optional";
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(final int type) {
        if (type == 0 || type == 1) {
            courseType = type;
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        if (0 < courseCode && courseCode < 1000000) {
            char upperCaseBase = Character.toUpperCase(courseBase);
            for (char c : ConstantValues.COURSE_BASES) {
                if (upperCaseBase == c) {
                    String courseString = Integer.toString(courseCode);
                    this.courseCode = courseString + upperCaseBase;
                    this.courseBase = upperCaseBase;
                    return;
                }
            }
        }
    }

    public char getCourseBase() {
        return courseBase;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(final int period) {
        if (ConstantValues.MIN_PERIOD <= period &&
                period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    public double getCredits() {
        return credits;
    }

    private void setCredits(final double credits) {
        if (ConstantValues.MIN_CREDITS <= credits &&
                credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    public boolean isNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    @Override
    public String toString() {
        String typeString = getCourseTypeString();
        if (name.equals(ConstantValues.NO_NAME)) {
            return String.format(Locale.ROOT,
                    "[%s (%5.2f cr), %s. %s, period: %d.]",
                    courseCode,credits,name,typeString,period);
        }
        return String.format(Locale.ROOT,
                "[%s (%5.2f cr), \"%s\". %s, period: %d.]",
                courseCode,credits,name,typeString,period);
    }

    public void printCourse() {
        String text = this.toString();
        System.out.println(text);
    }
}
