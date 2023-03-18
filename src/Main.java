import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static University NAUKMA;

    public static void main(String[] args) {
        System.out.println("Use your default database(1), your own(2) or not use any(3)?");
        int databaseOption = Reader.readInt(1, 3);
        initializeUniversity(databaseOption);

        int menuOption;
        do {
            displayMenu();
            menuOption = Reader.readInt(1, 5);

            switch (menuOption) {
                case 1:
                    handleFacultyActions();
                    break;
                case 2:
                    handleDepartmentActions();
                    break;
                case 3:
                    handleStudentActions();
                    break;
                case 4:
                    handleTeacherActions();
                    break;
                case 5:
                    break;
            }
        } while (menuOption != 5);

        Save.save(new File("resultDatabase.txt"), NAUKMA);
    }

    private static void initializeUniversity(int databaseOption) {
        switch (databaseOption) {
            case 1:
                NAUKMA = new University(new File("database.txt"));
                System.out.println("Default base is used.");
                break;
            case 2:
                System.out.println("Enter the name of your database");
                String customDatabase = Reader.readLine();
                NAUKMA = new University(new File(customDatabase));
                System.out.println("Custom base is used.");
                break;
            case 3:
                break;
        }
    }

    private static void displayMenu() {
        System.out.print("MENU\n1) Edit faculty.\n2) Edit department.");
        System.out.println("\n3) Edit students.\n4) Edit teachers.\n5) Exit.");
    }

    private static void handleFacultyActions() {
        System.out.println("1) Add faculty.\n2) Edit faculty.\n3) Delete faculty.\n4) Students of faculty list.\n5) Teachers of faculty list.");
        int mode = Reader.readInt(1, 3);

        switch (mode) {
            case 1:
                addFaculty();
                break;
            case 2:
                editFaculty();
                break;
            case 3:
                deleteFaculty();
                break;


        }
    }

    private static void handleDepartmentActions() {
        System.out.println("1) Add department.\n2) Edit department.\n3) Delete department.\n4) Students of department list.\n5) Teachers of department list.");
        int mode = Reader.readInt(1, 3);

        switch (mode) {
            case 1:
                addDepartment();
                break;
            case 2:
                editDepartment();
                break;
            case 3:
                deleteDepartment();
                break;

        }
    }

    private static void handleStudentActions() {
        System.out.println("1) Add student.\n2) Edit student\n3) Delete student.\n4) Get students.\n5) Find student.");
        int mode = Reader.readInt(1, 5);

        switch (mode) {
            case 1:
                addStudent();
                break;
            case 2:
                editStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                getStudents();
                break;
            case 5:
                findStudent();
                break;
        }
    }

    private static void handleTeacherActions() {
        System.out.println("1) Add teacher.\n2) Edit teacher\n3) Delete teacher.\n4) Get list of teachers by alphabetical order.\n5) Find teacher.");
        int mode = Reader.readInt(1, 5);
        switch (mode) {
            case 1:
                addTeacher();
                break;
            case 2:
                editTeacher();
                break;
            case 3:
                deleteTeacher();
                break;
            case 4:
                getTeachersByAlphabeticalOrder();
                break;
            case 5:
                findTeacher();
                break;
        }
    }

    private static void addFaculty() {
        System.out.println("Enter the name of faculty:");
        String facultyName = Reader.readLine();
        NAUKMA.addFaculty(facultyName);
    }

    private static void editFaculty() {
        System.out.println("Choose the faculty to edit:");
        String facultyName = Reader.readLine();
        System.out.println("Enter new name:");
        String newFacultyName = Reader.readLine();
        NAUKMA.editFaculty(facultyName, newFacultyName);
    }

    private static void deleteFaculty() {
        System.out.println("Choose the faculty to delete:");
        String facultyName = Reader.readLine();
        NAUKMA.deleteFaculty(facultyName);
    }

    private static void displayStudentsOfFaculty() {
        System.out.println("Enter the faculty:");
        String facultyName = Reader.readLine();
        List<Student> students = Select.facultyByName(NAUKMA.getFaculties(), facultyName);
        System.out.println(students);
    }

    private static void displayTeachersOfFaculty() {
        System.out.println("Enter the faculty:");
        String facultyName = Reader.readLine();
        List<Teacher> teachers = Select.facultyByName(NAUKMA.getFaculties(), facultyName);
        System.out.println(teachers);
    }

    private static void addDepartment() {
        System.out.println("To what faculty do you want to add department?");
        String facultyName = Reader.readLine();
        System.out.println("Enter the name of department:");
        String departmentName = Reader.readLine();
        NAUKMA.addDepartment(departmentName, facultyName);
    }

    private static void editDepartment() {
        System.out.println("Choose the department to edit:");
        String departmentName = Reader.readLine();
        System.out.println("Enter a new department name");
        String newDepartmentName = Reader.readLine();
        NAUKMA.editDepartment(departmentName, newDepartmentName);
    }

    private static void deleteDepartment() {
        System.out.println("Choose the department to delete:");
        String departmentName = Reader.readLine();
        NAUKMA.deleteDepartment(departmentName);
    }

    private static void displayStudentsOfDepartment() {
        System.out.println("Enter the name of department:");
        String departmentName = Reader.readLine();
        List<Student> students = Select.departmentByName(NAUKMA.getDepartments(), departmentName);
        System.out.println(students);
    }

    private static void displayTeachersOfDepartment() {
        System.out.println("Enter the name of department:");
        String departmentName = Reader.readLine();
        List<Teacher> teachers = Select.departmentByName(NAUKMA.getDepartments(), departmentName);
        System.out.println(teachers);
    }

    private static void addStudent() {
        System.out.println("Enter the name of student:");
        String studentName = Reader.readLine();
        System.out.println("Enter the age of student:");
        int studentAge = Reader.readInt();
        System.out.println("Enter the department of student:");
        String departmentName = Reader.readLine();
        System.out.println("Enter the group of student:");
        String studentGroup = Reader.readLine();
        System.out.println("Enter the year of study of student:");
        int yearOfStudy = Reader.readInt();
        NAUKMA.addStudent(studentName, studentAge, departmentName, yearOfStudy, studentGroup);
    }

    private static void editStudent() {
        System.out.println("Choose the student to edit:");
        String oldStudentName = Reader.readLine();
        System.out.println("Enter the new name of student:");
        String studentName = Reader.readLine();
        System.out.println("Enter the new age of student:");
        int studentAge = Reader.readInt();
        System.out.println("Enter the new group of student:");
        String studentGroup = Reader.readLine();
        System.out.println("Enter the new year of study of student:");
        int yearOfStudy = Reader.readInt();
        NAUKMA.editStudent(oldStudentName, studentName, studentAge, yearOfStudy, studentGroup);
    }

    private static void deleteStudent() {
        System.out.println("Choose the student to delete:");
        String studentName = Reader.readLine();
        NAUKMA.deleteStudent(studentName);
    }

    private static void getStudents() {
        System.out.println("Choose the way of getting list:\n1) By alphabetical order.\n2) By year of study.");
        int way = Reader.readInt(1, 2);
        List<Student> students;

        switch (way) {
            case 1:
                students = OrderBy.name(NAUKMA.getStudents());
                break;
            case 2:
                students = OrderBy.year(NAUKMA.getStudents());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + way);
        }
        System.out.println(students);
    }

    private static void findStudent() {
        System.out.println("Choose the way of searching:\n1) By name.\n2) By year.\n3) By group.\n4)By faculty.\n5)By department.");
        int way = Reader.readInt(1, 5);
        List<Student> students;

        switch (way) {
            case 1:
                String studentName = Reader.readLine();
                students = Select.studentByName(NAUKMA.getStudents(), studentName);
                break;
            case 2:
                int yearOfStudy = Reader.readInt(1, 6);
                students = Select.studentsByYear(NAUKMA.getStudents(), yearOfStudy);
                break;
            case 3:
                String studentGroup = Reader.readLine();
                students = Select.studentsByGroup(NAUKMA.getStudents(), studentGroup);
                break;
            case 4:
                displayStudentsOfFaculty();
                break;
            case 5:
                displayStudentsOfDepartment();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + way);
        }
        System.out.println(students);
    }

    private static void addTeacher() {
        System.out.println("Enter the name of teacher:");
        String teacherName = Reader.readLine();
        System.out.println("Enter the age of teacher:");
        int teacherAge = Reader.readInt();
        System.out.println("Enter the department of teacher:");
        String departmentName = Reader.readLine();
        NAUKMA.addTeacher(teacherName, teacherAge, departmentName);
    }

    private static void editTeacher() {
        System.out.println("Choose the teacher to edit:");
        String oldTeacherName = Reader.readLine();
        System.out.println("Enter the name of teacher:");
        String teacherName = Reader.readLine();
        System.out.println("Enter the age of teacher:");
        int teacherAge = Reader.readInt();
        NAUKMA.editTeacher(oldTeacherName, teacherName, teacherAge);
    }

    private static void deleteTeacher() {
        System.out.println("Choose the teacher to delete:");
        String teacherName = Reader.readLine();
        NAUKMA.deleteTeacher(teacherName);
    }

    private static void getTeachersByAlphabeticalOrder() {
        List<Teacher> teachers = OrderBy.name(NAUKMA.getTeachers());
        System.out.println(teachers);
    }

    private static void findTeacher() {
        System.out.println("Choose the way of searching:\n1) By name.\n2)By faculty.\n3)By department.");
        int way = Reader.readInt(1, 3);
        switch (way) {
            case 1:
                System.out.println("Enter the name of teacher:");
                String teacherName = Reader.readLine();
                List<Teacher> teachers = Select.teacherByName(NAUKMA.getTeachers(), teacherName);
                break;
            case 2:
                displayTeachersOfFaculty();
                break;
            case 5:
                displayTeachersOfDepartment();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + way);
        }
        System.out.println(teachers);





    }
}

