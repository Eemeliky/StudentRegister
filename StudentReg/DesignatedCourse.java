package StudentReg;

import java.util.Locale;

public class DesignatedCourse {
    private Course course;
    private boolean responsible;
    private int year;

    public DesignatedCourse() {
    }

    public DesignatedCourse(Course course, boolean resp, int year) {
        setCourse(course);
        setResponsible(resp);
        setYear(year);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    }

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (ConstantValues.MIN_START_YEAR <= year && year <= ConstantValues.getCurrentYear() + 1) {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT,
                "[course=[%s (%5.2f cr), \"%s\"." +
                        " %s, period: %d.], year=%d]",
                course.getCourseCode(), course.getCredits(), course.getName(),
                course.getCourseTypeString(), course.getPeriod(), getYear());
    }

    public String toStringStyleC() {
        // toString without Locale.ROOT formatting
        return String.format(
                "[course=[%s (%5.2f cr), \"%s\"." +
                        " %s, period: %d.], year=%d]",
                course.getCourseCode(), course.getCredits(), course.getName(),
                course.getCourseTypeString(), course.getPeriod(), getYear());
    }
}
