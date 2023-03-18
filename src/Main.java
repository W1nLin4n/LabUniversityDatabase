import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

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
        System.out.println("1) Add faculty.\n2) Edit faculty.\n3) Delete faculty.");
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
        System.out.println("1) Add department.\n2) Edit department.\n3) Delete department.");
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
        System.out.println("1) Add teacher.\n2) Edit teacher\n3) Delete teacher.\n4) Get teachers.\n5) Find teacher.");
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
                getTeachers();
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
        System.out.println("Choose where to get students from:\n1) From university.\n2) From faculty.\n3) From department.");
        int from = Reader.readInt(1, 3);
        List<Student> students = null;
        switch (from) {
            case 1:
                students = NAUKMA.getStudents();
                break;
            case 2:
                System.out.println("Enter faculty name:");
                String facultyName = Reader.readLine();
                if(Select.facultyByName(NAUKMA.getFaculties(), facultyName) == null){
                    System.out.println("There is no such faculty");
                    return;
                }
                students = Select.facultyByName(NAUKMA.getFaculties(), facultyName).getStudents();
                break;
            case 3:
                System.out.println("Enter department name:");
                String departmentName = Reader.readLine();
                if(Select.departmentByName(NAUKMA.getDepartments(), departmentName) == null){
                    System.out.println("There is no such department");
                    return;
                }
                students = Select.departmentByName(NAUKMA.getDepartments(), departmentName).getStudents();
                break;
        }
        if(students.isEmpty()){
            System.out.println("There are no students matching criteria");
            return;
        }
        System.out.println("Choose order and selection type:\n1) Alphabetical order.\n2) Order by year.\n3) Alphabetical order with year selection.");
        int type = Reader.readInt(1, 3);
        switch (type) {
            case 1:
                OrderBy.name(students);
                break;
            case 2:
                OrderBy.year(students);
                break;
            case 3:
                System.out.println("Enter year:");
                int year = Reader.readInt();
                students = Select.studentsByYear(students, year);
                if(students.isEmpty()){
                    System.out.println("There are no students matching criteria");
                    return;
                }
                OrderBy.name(students);
                break;
        }
        students.forEach(System.out::println);
    }

    private static void findStudent() {
        System.out.println("Choose the way of searching:\n1) By name.\n2) By year.\n3) By group.");
        int way = Reader.readInt(1, 3);
        switch (way) {
            case 1:
                System.out.println("Enter name:");
                String name = Reader.readLine();
                if(Select.studentByName(NAUKMA.getStudents(), name) == null){
                    System.out.println("There is no student with this name");
                    return;
                }
                System.out.println(Select.studentByName(NAUKMA.getStudents(), name));
                break;
            case 2:
                System.out.println("Enter year:");
                int year = Reader.readInt();
                if(Select.studentsByYear(NAUKMA.getStudents(), year).isEmpty()){
                    System.out.println("There are no students with this year of study");
                    return;
                }
                Select.studentsByYear(NAUKMA.getStudents(), year).forEach(System.out::println);
                break;
            case 3:
                System.out.println("Enter group:");
                String group = Reader.readLine();
                if(Select.studentsByGroup(NAUKMA.getStudents(), group).isEmpty()){
                    System.out.println("There are no students with this group");
                    return;
                }
                Select.studentsByGroup(NAUKMA.getStudents(), group).forEach(System.out::println);
                break;
        }
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

    private static void getTeachers() {
        System.out.println("Choose where to get teachers from:\n1) From university.\n2) From faculty.\n3) From department.");
        int from = Reader.readInt(1, 3);
        List<Teacher> teachers = null;
        switch (from) {
            case 1:
                teachers = NAUKMA.getTeachers();
                break;
            case 2:
                System.out.println("Enter faculty name:");
                String facultyName = Reader.readLine();
                if(Select.facultyByName(NAUKMA.getFaculties(), facultyName) == null){
                    System.out.println("There is no such faculty");
                    return;
                }
                teachers = Select.facultyByName(NAUKMA.getFaculties(), facultyName).getTeachers();
                break;
            case 3:
                System.out.println("Enter department name:");
                String departmentName = Reader.readLine();
                if(Select.departmentByName(NAUKMA.getDepartments(), departmentName) == null){
                    System.out.println("There is no such department");
                    return;
                }
                teachers = Select.departmentByName(NAUKMA.getDepartments(), departmentName).getTeachers();
                break;
        }
        if(teachers.isEmpty()){
            System.out.println("There are no teachers matching criteria");
            return;
        }
        OrderBy.name(teachers);
        teachers.forEach(System.out::println);
    }

    private static void findTeacher() {
        System.out.println("Enter name:");
        String name = Reader.readLine();
        if(Select.teacherByName(NAUKMA.getTeachers(), name) == null){
            System.out.println("There is no teacher with this name");
            return;
        }
        System.out.println(Select.teacherByName(NAUKMA.getTeachers(), name));
    }
}

