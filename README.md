# Student Register

This project is designed to manage student information. This includes: **student id, list of completed courses, 
3 different degrees, GPA, status of studies, study years and personal data of student**. project can also 
manage some teacher information like: **teacher's courses, hourly wage, salary, employee ID and personal data of 
teacher**.

### Output of the main.java with example values:
```plaintext
Teacher id: OY_TEACHER_2152
        First name: Mickey, Last name: Mouse
        Birthdate: 09.09.1941
        Salary: 756.85
        Teacher for courses:
        Teacher: [course=[223344A (50,50 cr), "More basic studies". Mandatory, period: 1.], year=2023]
        Teacher: [course=[556677A (50,00 cr), "Even more basic studies". Optional, period: 3.], year=2023]
        Teacher: [course=[666666S ( 8,00 cr), "Extra master studies". Optional, period: 5.], year=2022]
        Responsible teacher: [course=[888888S (18,00 cr), "Final master studies". Mandatory, period: 5.], year=2023]

Teacher id: OY_ASSISTANT_2733
        First name: Goofy, Last name: The Dog
        Birthdate: 17.03.1978
        Salary: 38.50
        Assistant for courses:
        [course=[223344A (50,50 cr), "More basic studies". Mandatory, period: 1.], year=2023]
        [course=[556677A (50,00 cr), "Even more basic studies". Optional, period: 3.], year=2023]
        [course=[666666S ( 8,00 cr), "Extra master studies". Optional, period: 5.], year=2022]
        [course=[888888S (18,00 cr), "Final master studies". Mandatory, period: 5.], year=2023]

Student id: 56
        First name: Donald, Last name: Duck
        Date of birth: 01.01.2006
        Status: The student has graduated in 2020
        Start year: 2001 (studies have lasted for 19 years)
        Total credits: 324.0 (GPA = 2,11)
        Bachelor credits: 201.0
                Total bachelor credits completed (201.0/180.0)
                All mandatory bachelor credits completed (151.0/150.0)
                GPA of bachelor studies: 2,40
                Title of BSc Thesis: "Christmas - The most wonderful time of the year"
        Master credits: 123.0
                Total master's credits completed (123.0/120.0)
                All mandatory master's credits completed (70.0/50.0)
                GPA of master's studies: 1,75
                Title of MSc Thesis: "Dreaming of a white Christmas"

Degree information:
Degree [Title: "Bachelor of Science" (courses: 5)
         Thesis title: "Christmas - The most wonderful time of the year"
         1. [811104P ( 5.00 cr), "Programming 1". Mandatory, period: 1.] Year: 2013, Grade: 1.]
         2. [112233P (45.00 cr), "All kinds of basic studies". Mandatory, period: 2.] Year: 2014, Grade: 1.]
         3. [223344A (50.50 cr), "More basic studies". Mandatory, period: 1.] Year: 2015, Grade: 1.]
         4. [556677A (50.00 cr), "Even more basic studies". Optional, period: 3.] Year: 2016, Grade: 4.]
         5. [123123A (50.50 cr), "Final basic studies". Mandatory, period: 4.] Year: 2017, Grade: 5.]]

Degree [Title: "Master of Science" (courses: 6)
         Thesis title: "Dreaming of a white Christmas"
         1. [616161A (25.00 cr), "Programming 2". Mandatory, period: 3.] Year: 2018, Grade: 1.]
         2. [717171P (45.00 cr), "All kinds of master studies". Optional, period: 2.] Year: 2019, Grade: 1.]
         3. [818181A (25.00 cr), "More master studies". Mandatory, period: 1.] Year: 2020, Grade: 2.]
         4. [919191S (20.00 cr), "Even more master studies". Mandatory, period: 3.] Year: 2021, Grade: 3.]
         5. [666666S ( 8.00 cr), "Extra master studies". Optional, period: 5.] Year: 2021, Grade: A.]
         6. [888888S (18.00 cr), "Final master studies". Mandatory, period: 5.] Year: 2022, Grade: F.]]

Degree [Title: "No title" (courses: 0)
         Thesis title: "No title"]

All courses:
[811104P ( 5.00 cr), "Programming 1". Mandatory, period: 1.] Year: 2013, Grade: 1.]
[112233P (45.00 cr), "All kinds of basic studies". Mandatory, period: 2.] Year: 2014, Grade: 1.]
[223344A (50.50 cr), "More basic studies". Mandatory, period: 1.] Year: 2015, Grade: 1.]
[556677A (50.00 cr), "Even more basic studies". Optional, period: 3.] Year: 2016, Grade: 4.]
[123123A (50.50 cr), "Final basic studies". Mandatory, period: 4.] Year: 2017, Grade: 5.]
[616161A (25.00 cr), "Programming 2". Mandatory, period: 3.] Year: 2018, Grade: 1.]
[717171P (45.00 cr), "All kinds of master studies". Optional, period: 2.] Year: 2019, Grade: 1.]
[818181A (25.00 cr), "More master studies". Mandatory, period: 1.] Year: 2020, Grade: 2.]
[919191S (20.00 cr), "Even more master studies". Mandatory, period: 3.] Year: 2021, Grade: 3.]
[666666S ( 8.00 cr), "Extra master studies". Optional, period: 5.] Year: 2021, Grade: A.]
[888888S (18.00 cr), "Final master studies". Mandatory, period: 5.] Year: 2022, Grade: F.]
