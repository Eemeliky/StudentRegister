package StudentReg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // EXAMPLE FUNCTION CALLS
        // all personal IDs that are use in this example are test IDs (i.e. 900+ ending).
        ResponsibleTeacher respTeach = new ResponsibleTeacher("Mouse", "Mickey");
        respTeach.setBirthDate("090941-987F");
        MonthlyPayment salary = new MonthlyPayment();
        salary.setSalary(756.85);
        respTeach.setPayment(salary);
        AssistantTeacher assistTeach = new AssistantTeacher("The Dog", "Goofy");
        assistTeach.setBirthDate("170378-9538");
        HourBasedPayment hourBased = new HourBasedPayment();
        hourBased.setEurosPerHour(3.5);
        hourBased.setHours(11);
        assistTeach.setPayment(hourBased);

        Student stud1 = new Student("Duck", "Donald");
        Course course1 = new Course("Programming 1",811104,'P',1,1,5,true);
        Course course2 = new Course("All kinds of basic studies",112233,'P',1,2,45,true);
        Course course3 = new Course("More basic studies",223344,'a',1,1,50.5,true);
        Course course4 = new Course("Even more basic studies",556677,'a',0,3,50.0,true);
        Course course5 = new Course("Final basic studies",123123,'A',1,4,50.5,true);
        Course course6 = new Course("Programming 2",616161,'A',1,3,25.0,true);
        Course course7 = new Course("All kinds of master studies",717171,'P',0,2,45.0,true);
        Course course8 = new Course("More master studies",818181,'A',1,1,25.0,true);
        Course course9 = new Course("Even more master studies",919191,'S',1,3,20.0,true);
        Course course10 = new Course("Extra master studies",666666,'S',0,5,8.0,false);
        Course course11 = new Course("Final master studies",888888,'S',1,5,18.0,false);

        DesignatedCourse dCourse1 = new DesignatedCourse(course3, false, 2023);
        DesignatedCourse dCourse2 = new DesignatedCourse(course4, false, 2023);
        DesignatedCourse dCourse3 = new DesignatedCourse(course10, false, 2022);
        DesignatedCourse dCourse4 = new DesignatedCourse(course11, true, 2023);

        List<DesignatedCourse> dCourses = new ArrayList<>(Arrays.asList(dCourse1, dCourse2, dCourse3, dCourse4));

        respTeach.setCourses(dCourses);
        assistTeach.setCourses(dCourses);
        respTeach.printResponsibleTeacher();
        assistTeach.printAssistantTeacher();

        StudentCourse studCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studCourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse studCourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse studCourse11 = new StudentCourse(course11, 'f', 2022);

        List<StudentCourse> bachelor =
                new ArrayList<>(Arrays.asList(studCourse1, studCourse2, studCourse3, studCourse4, studCourse5));
        List<StudentCourse> master =
                new ArrayList<>(Arrays.asList(studCourse6, studCourse7, studCourse8,
                        studCourse9, studCourse10, studCourse11));

        stud1.setDegreeTitle(0, "Bachelor of Science");
        stud1.setDegreeTitle(1, "Master of Science");
        stud1.setTitleOfThesis(0, "Bachelor thesis title");
        stud1.setTitleOfThesis(1, "Masters thesis title");
        stud1.addCourses(ConstantValues.BACHELOR_TYPE, bachelor);
        stud1.addCourses(ConstantValues.MASTER_TYPE, master);
        stud1.setStartYear(2001);
        stud1.setGraduationYear(2020);
        stud1.setBirthDate("010106A9610");
        stud1.setTitleOfThesis(ConstantValues.BACHELOR_TYPE, "Christmas - The most wonderful time of the year");
        stud1.setTitleOfThesis(ConstantValues.MASTER_TYPE,"Dreaming of a white Christmas");
        studCourse9.setGrade(3);
        stud1.setGraduationYear(2020);
        stud1.printStudent();
        System.out.println("Degree information:");
        stud1.printDegrees();
        System.out.println("All courses:");
        stud1.printCourses();
    }
}
