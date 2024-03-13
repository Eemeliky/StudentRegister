package StudentReg;

import java.util.Locale;

public class StudentCourse {
    private Course course;
    private int gradeNum;
    private int yearCompleted;

    public StudentCourse() {
    }

    public StudentCourse(Course course, final int gradeNum,
                         final int yearCompleted) {
        setCourse(course);
        setYear(yearCompleted);
        setGrade(gradeNum);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    }

    public int getGradeNum() {
        return gradeNum;
    }

    public boolean isPassed() {
        return (gradeNum != 0 && gradeNum != 'F');
    }

    public int getYear() {
        return yearCompleted;
    }

    public void setYear(final int year) {
        int currentYear = ConstantValues.getCurrentYear();
        if (ConstantValues.MIN_START_YEAR < year && year <= currentYear) {
            this.yearCompleted = year;
        }
    }

    @Override
    public String toString() {
        String gradeStr = "\"Not graded\"";
        if (gradeNum != 0) {
            if (course.isNumericGrade()) {
                gradeStr = Integer.toString(gradeNum);
            } else {
                char tmp = (char) gradeNum;
                gradeStr = String.valueOf(tmp);
            }
        }
        return String.format(Locale.ROOT,
                "[%s (%5.2f cr), \"%s\". %s, period: %d.] " +
                        "Year: %d, Grade: %s.]",
                course.getCourseCode(),course.getCredits(), course.getName(),
                course.getCourseTypeString(), course.getPeriod(),
                yearCompleted, gradeStr);
    }

    public void printStudentCourse() {
        String text = this.toString();
        System.out.println(text);
    }

    protected void setGrade(int gradeNum) {
        boolean validGrade = checkGradeValidity(gradeNum);
        if (validGrade) {
            this.gradeNum = Character.toUpperCase((char) gradeNum);
            if (yearCompleted == 0) {
                yearCompleted = ConstantValues.getCurrentYear();
            }
        }
    }

    private boolean checkGradeValidity(final int gradeNum) {
        if (course.isNumericGrade()) {
            return (ConstantValues.MIN_GRADE <= gradeNum &&
                    gradeNum <= ConstantValues.MAX_GRADE);
        } else {
            char validChar = Character.toUpperCase((char) gradeNum);
            return (validChar == ConstantValues.GRADE_ACCEPTED ||
                    validChar == ConstantValues.GRADE_FAILED);
        }
    }
}
