package StudentReg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Degree {

    private static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private final List<StudentCourse> myCourses = new ArrayList<>();

    public List<StudentCourse> getCourses() {
        return myCourses;
    }

    public void addStudentCourses(List<StudentCourse> courses) {
        if (courses != null) {
            for (StudentCourse course : courses) {
                if (count == MAX_COURSES) {
                    return;
                }
                addStudentCourse(course);
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            myCourses.add(count, course);
            count++;
            return true;
        }
        return false;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }

    public String getTitleOfThesis() {
        return titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    public double getCreditsByBase(Character base) {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            Course course = myCourses.get(i).getCourse();
            if (course.getCourseBase() == base && myCourses.get(i).isPassed()) {
                sum += course.getCredits();
            }
        }
        return sum;
    }

    public double getCreditsByType(final int courseType) {
        double sum = 0;
        if (count > 0) {
            if (courseType == ConstantValues.ALL) {
                return getCredits();
            }
            for (int i = 0; i < count; i++) {
                Course course = myCourses.get(i).getCourse();
                if (course.getCourseType() == courseType && myCourses.get(i).isPassed()) {
                    sum += course.getCredits();
                }
            }

        }
        return sum;
    }

    public double getCredits() {
        double sum = 0;
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                Course course = myCourses.get(i).getCourse();
                if (myCourses.get(i).isPassed()) {
                    sum += course.getCredits();
                }
            }
        }
        return sum;
    }

    public List<Double> getGPA(int type) {
        double sum = 0;
        double avg = 0;
        double rollingNum = 0;
        if (count > 0) {
            if (type == ConstantValues.ALL) {
                for (int i = 0; i < count; i++) {
                    Course course = myCourses.get(i).getCourse();
                    if (course.isNumericGrade()) {
                        sum += myCourses.get(i).getGradeNum();
                        rollingNum++;
                    }
                }
            } else {
                for (int i = 0; i < count; i++) {
                    Course course = myCourses.get(i).getCourse();
                    if (course.getCourseType() == type && course.isNumericGrade()) {
                        sum += myCourses.get(i).getGradeNum();
                        rollingNum++;
                    }
                }
            }
        }
        if (rollingNum > 0) {
            avg = sum / rollingNum;

            // quick rounding for .2f
            avg *= 100;
            avg = Math.round(avg);
            avg /= 100;
        }
        return new ArrayList<>(Arrays.asList(sum, rollingNum, avg));
    }

    private boolean isCourseCompleted(StudentCourse c) {
        if (c != null) {
            return c.isPassed();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rollingNum = 0;
        String indent = "         ";
        sb.append(String.format("Degree [Title: \"%s\" (courses: %d)\n", degreeTitle, count));
        sb.append(indent).append(String.format("Thesis title: \"%s\"",titleOfThesis));
        if (count > 0) {
            sb.append("\n");
            for (StudentCourse studCourse : myCourses) {
                String line = String.format("%d. %s",rollingNum + 1,studCourse.toString());
                line = indent + line;
                if (rollingNum == count - 1) {
                    sb.append(line);
                    break;
                }
                sb.append(line).append("\n");
                rollingNum++;
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    public void printCourses() {
        String text = this.toString();
        System.out.println(text);
    }

    public void printOnlyCourses() {
        // Prints only the courses without degree title or thesis title.
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                myCourses.get(i).printStudentCourse();
            }
        }
    }
}
