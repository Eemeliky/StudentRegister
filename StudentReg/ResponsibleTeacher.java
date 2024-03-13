package StudentReg;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ResponsibleTeacher extends Employee implements Payment, Teacher {
    private List<DesignatedCourse> courses = new ArrayList<>();

    public ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }

    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            for (DesignatedCourse dCourse : courses) {
                if (dCourse == null) {
                    return;
                }
            }
            this.courses = courses;
        }
    }
    @Override
    protected String getEmployeeIdString() {
        return "OY_TEACHER_";
    }

    @Override
    public String getCourses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            String preFix = "StudentRegister.Teacher: ";
            if (courses.get(i).isResponsible()) {
                preFix = "Responsible teacher: ";
            }
            sb.append(preFix);
            if (i == courses.size() - 1) {
                sb.append(courses.get(i).toString());
            }
            sb.append(courses.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        String indent = "        ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            String preFix = "StudentRegister.Teacher: ";
            if (courses.get(i).isResponsible()) {
                preFix = "Responsible teacher: ";
            }
            sb.append(indent).append(preFix);
            if (i == courses.size() - 1) {
                sb.append(courses.get(i).toStringStyleC());
            }
            sb.append(courses.get(i).toStringStyleC()).append("\n");
        }
        return String.format(Locale.ROOT,
                """
                StudentRegister.Teacher id: %s
                        First name: %s, Last name: %s
                        Birthdate: %s
                        Salary: %5.2f
                        StudentRegister.Teacher for courses:
                %s""",
                getIdString(), getFirstName(), getLastName(), getBirthDate(),
                calculatePayment(), sb);
    }

    public void printResponsibleTeacher() {
        String text = toString();
        System.out.println(text);
    }
}
