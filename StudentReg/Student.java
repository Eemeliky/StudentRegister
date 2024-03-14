package StudentReg;

import java.util.*;

public class Student extends Person {

    private int id;
    private int startYear;
    private int graduationYear;
    private final List<Degree> degrees = new ArrayList<>();
    private final int DEGREE_COUNT = 3;



    public Student(String lastName, String firstName) {
        super(lastName, firstName);
        for (int i = 0; i < DEGREE_COUNT; i++) {
            degrees.add(i, new Degree());
        }
        id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
        startYear = ConstantValues.getCurrentYear();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        if (ConstantValues.MIN_STUDENT_ID <= id && id <= ConstantValues.MAX_STUDENT_ID) {
            this.id = id;
        }
    }

    public void setStartYear(final int startYear) {
        int currentYear = ConstantValues.getCurrentYear();
        if (ConstantValues.MIN_START_YEAR < startYear && startYear <= currentYear) {
            this.startYear = startYear;
        }
    }

    public int getStartYear() {
        return startYear;
    }

    public String setGraduationYear(final int graduationYear) {
        if (canGraduate()) {
            if (graduationYear > ConstantValues.MIN_START_YEAR) {
                int currentYear = ConstantValues.getCurrentYear();
                if (startYear <= graduationYear && graduationYear <= currentYear) {
                    this.graduationYear = graduationYear;
                    return ConstantValues.OK;
                }
            }
            return ConstantValues.GRAD_YEAR_ERROR;
        }
        return ConstantValues.GRAD_STUDIES_ERROR;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public boolean hasGraduated() {
        return (graduationYear > 0);
    }

    private boolean canGraduate() {
        Degree bachelor = degrees.get(ConstantValues.BACHELOR_TYPE);
        Degree masters = degrees.get(ConstantValues.MASTER_TYPE);
        String bachelorTitle = bachelor.getTitleOfThesis();
        String masterTitle = masters.getTitleOfThesis();
        if (!bachelorTitle.equals(ConstantValues.NO_TITLE) &&
                !masterTitle.equals(ConstantValues.NO_TITLE)) {

            if (bachelor.getCreditsByType(ConstantValues.MANDATORY) >= ConstantValues.BACHELOR_MANDATORY &&
            masters.getCreditsByType(ConstantValues.MANDATORY) >= ConstantValues.MASTER_MANDATORY) {

                return (bachelor.getCredits() >= ConstantValues.BACHELOR_CREDITS &&
                        masters.getCredits() >= ConstantValues.MASTER_CREDITS);
            }
        }
        return false;
    }

    public int getStudyYears() {
        if (hasGraduated()) {
            return graduationYear - startYear;
        } else {
            int currentYear = ConstantValues.getCurrentYear();
            return currentYear - startYear;
        }
    }

    private boolean isValidDegreeIndex(final int idx) {
        return (0 <= idx && idx <= DEGREE_COUNT);
    }

    public void setDegreeTitle(final int i, String dName) {
        if (dName != null && isValidDegreeIndex(i)) {
            degrees.get(i).setDegreeTitle(dName);
        }
    }

    public boolean addCourse(final int i, StudentCourse course) {
        if (course != null && isValidDegreeIndex(i)) {
            return degrees.get(i).addStudentCourse(course);
        }
        return false;
    }

    public int addCourses(final int i, List<StudentCourse> courses) {
        int count = 0;
        if (courses != null) {
            for (StudentCourse course : courses) {
                if (addCourse(i, course)) count++;
            }
        }
        return count;
    }

    public void printCourses() {
        for (Degree degree : degrees) {
            degree.printOnlyCourses();
        }
    }

    public void printDegrees() {
        for (Degree degree : degrees) {
            degree.printCourses();
        }
    }

    public void setTitleOfThesis(final int i, String title) {
        if (title != null && isValidDegreeIndex(i)) {
            degrees.get(i).setTitleOfThesis(title);
        }
    }

    private List<Double> getAllGPAs() {
        // Gets GPAs of all degrees and total GPA.
        // [0] = Bachelor, [1] = Masters, [2] = Doctoral, [Last] = Total GPA
        ArrayList<Double> GPAs = new ArrayList<>();
        List<Double> degreeGPA;
        double sum = 0;
        double count = 0;
        for (int i = 0; i < DEGREE_COUNT; i++) {
            degreeGPA = degrees.get(i).getGPA(ConstantValues.ALL);
            GPAs.add(i, degreeGPA.get(2));
            sum += degreeGPA.get(0);
            count += degreeGPA.get(1);
        }
        if (count > 0) {
            GPAs.add(DEGREE_COUNT, (sum / count));
        } else {
            GPAs.add(DEGREE_COUNT, 0.0);
        }
        return GPAs;
    }

    @Override
    public String getIdString() {
        return String.format("Student id: %d", getId());
    }

    @Override
    public String toString() {
        int studyYears = getStudyYears();
        double MScTotalCred = degrees.get(ConstantValues.MASTER_TYPE).getCredits();
        double MScMandatoryCred = degrees.get(ConstantValues.MASTER_TYPE).getCreditsByType(ConstantValues.MANDATORY);
        double BScTotalCred = degrees.get(ConstantValues.BACHELOR_TYPE).getCredits();
        double BScMandatoryCred = degrees.get(ConstantValues.BACHELOR_TYPE).getCreditsByType(ConstantValues.MANDATORY);
        double totalCredits = BScTotalCred + MScTotalCred;
        List<Double> GPAs = getAllGPAs();
        String GPAStringTotal = String.format("%.2f", GPAs.get(DEGREE_COUNT));
        String bachelorText = getBachelorText(GPAs.get(0), BScTotalCred, BScMandatoryCred);
        String mastersText = getMastersText(GPAs.get(1), MScTotalCred, MScMandatoryCred);
        return String.format(Locale.ROOT,
                """
                %s
                        First name: %s, Last name: %s
                        Date of birth: %s
                        Status: %s
                        Start year: %d (studies have lasted for %d years)
                        Total credits: %.1f (GPA = %s)
                        %s
                        %s
                        """,
                getIdString(), getFirstName(), getLastName(), getBirthDate(), getStatusString(),
                startYear, studyYears, totalCredits, GPAStringTotal, bachelorText, mastersText);
    }

    private String studiesToString(String passString, String failString,
                                   final double limit, final double points) {
        // Method to get correct studies line for degree text block.
        String line;
        String indent = "        ";
        if (points >= limit) {
            line = String.format(Locale.ROOT,
                    passString,
                    points, limit);
        } else {
            double diff = limit - points;
            line = String.format(Locale.ROOT,
                    failString,
                    diff, points, limit);
        }
        return indent + line + "\n";
    }


    private String getBachelorText(final double GPA, final double totalCred, final double mandatoryCred) {
        // Method to get correct bachelor text block for toString() method.
        String titleOfThesis = degrees.get(ConstantValues.BACHELOR_TYPE).getTitleOfThesis();
        String indent = "        ";
        return String.format(Locale.ROOT, "Bachelor credits: %.1f\n", totalCred) +
                indent + studiesToString("Total bachelor credits completed (%.1f/%.1f)",
                "Missing bachelor credits %.1f (%.1f/%.1f)", ConstantValues.BACHELOR_CREDITS, totalCred) +
                indent + studiesToString("All mandatory bachelor credits completed (%.1f/%.1f)",
                "Missing mandatory bachelor credits %.1f (%.1f/%.1f)",
                ConstantValues.BACHELOR_MANDATORY, mandatoryCred) +
                indent + String.format("%sGPA of bachelor studies: %.2f\n", indent, GPA) +
                indent + String.format("%sTitle of BSc Thesis: \"%s\"", indent, titleOfThesis);
    }

    private String getMastersText(final double GPA, final double totalCred, final double mandatoryCred) {
        // Method to get correct master's text block for toString() method.
        String titleOfThesis = degrees.get(ConstantValues.MASTER_TYPE).getTitleOfThesis();
        String indent = "        ";
        return String.format(Locale.ROOT, "Master credits: %.1f\n", totalCred) +
                indent + studiesToString("Total master's credits completed (%.1f/%.1f)",
                "Missing master's credits %.1f (%.1f/%.1f)", ConstantValues.MASTER_CREDITS, totalCred) +
                indent + studiesToString("All mandatory master's credits completed (%.1f/%.1f)",
                "Missing mandatory master's credits %.1f (%.1f/%.1f)",
                ConstantValues.MASTER_MANDATORY, mandatoryCred) +
                indent + String.format("%sGPA of master's studies: %.2f\n", indent, GPA) +
                indent + String.format("%sTitle of MSc Thesis: \"%s\"", indent, titleOfThesis);
    }

    public void printStudent() {
        String text = this.toString();
        System.out.println(text);
    }

    private String getStatusString() {
        // Method to get correct graduation String for toString() method.
        String gradLine = "The student has not graduated, yet";
        if (hasGraduated()) {
            gradLine = "The student has graduated in " + graduationYear;
        }
        return gradLine;
    }

}
