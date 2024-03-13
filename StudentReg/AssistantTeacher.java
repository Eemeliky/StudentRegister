package StudentReg;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AssistantTeacher extends Employee implements Payment, Teacher {
    private List<DesignatedCourse> courses = new ArrayList<>();

    public AssistantTeacher(String lname, String fname) {
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
        return "OY_ASSISTANT_";
    }

    @Override
    public String getCourses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
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
            sb.append(indent);
            if (i == courses.size() - 1) {
                sb.append(courses.get(i).toStringStyleC());
            }
            sb.append(courses.get(i).toStringStyleC()).append("\n");
        }
        return String.format(Locale.ROOT,
                            """
                            Teacher id: %s
                                    First name: %s, Last name: %s
                                    Birthdate: %s
                                    Salary: %5.2f
                                    Assistant for courses:
                            %s""",
                getIdString(), getFirstName(), getLastName(), getBirthDate(),
                calculatePayment(), sb);
    }

    public void printAssistantTeacher() {
        String text = toString();
        System.out.println(text);
    }
}
