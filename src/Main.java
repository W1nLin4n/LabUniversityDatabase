
import java.io.File;
import java.util.ArrayList;

public class Main {

    private static University NAUKMA;
    public static void main(String[] args) {
        int option;
        System.out.println("Use your default database(1), your own(2) or not use any(3)?");
        int database = Reader.readInt(1,2);
        switch (database) {
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
        do{
            System.out.print("MENU\n1)Edit faculty.\n2)Edit department.");
            System.out.println("\n3)Edit students.\n4)Edit teachers.\n5)Exit.");
            option =Reader.readInt(1,5);
            switch (option) {
                case 1:
                    System.out.println("1)Add faculty.\n2)Edit faculty.\n3)Delete faculty.\n4)Students of faculty list.\n5)Teachers of faculty list.");
                    int mode = Reader.readInt(1, 5);
                    switch (mode) {
                        case 1:
                            System.out.println("Enter the name of faculty:");
                            String facultyName = Reader.readLine();
                            NAUKMA.addFaculty(facultyName);
                            break;

                        case 2:
                            System.out.println("Choose the faculty to edit:");
                            facultyName = Reader.readLine();
                            System.out.println("Enter new name:");
                            String newFacultyName = Reader.readLine();
                            NAUKMA.editFaculty(facultyName, newFacultyName);
                            break;

                        case 3:
                            System.out.println("Choose the faculty to delete:");
                            facultyName = Reader.readLine();
                            NAUKMA.deleteFaculty(facultyName);
                            break;
                      /*  case 4:
                            System.out.println("Enter the faculty:");
                            facultyName = Reader.readLine();
                            ArrayList students = new ArrayList();
                            students.add();
                            break;
                        case 5:
                            System.out.println("Enter the faculty:");
                            facultyName = Reader.readLine();
                            ArrayList teachers = new ArrayList();
                            teachers.add();*/


                    }
                    break;
                case 2:
                    System.out.println("1)Add department.\n2)Edit department.\n3)Delete department.\n4)Students of department list.\n5)Teachers of department list.");
                    mode = Reader.readInt(1, 5);
                    switch (mode) {
                        case 1:
                            System.out.println("To what faculty do you want to add department?");
                            String facultyName = Reader.readLine();
                            System.out.println("Enter the name of department:");
                            String departmentName = Reader.readLine();
                            NAUKMA.addDepartment(departmentName, facultyName);
                            break;
                        case 2:
                            System.out.println("Choose the department to edit:");
                            departmentName = Reader.readLine();
                            System.out.println("Enter a new department name");
                            String newDepartmentName = Reader.readLine();
                            NAUKMA.editDepartment(departmentName, newDepartmentName);
                            break;

                        case 3:
                            System.out.println("Choose the department to delete:");
                            departmentName = Reader.readLine();
                            NAUKMA.deleteDepartment(departmentName);
                            break;
                        case 4:
                            System.out.println("Enter the name of department:");
                        case 5:
                            System.out.println("Enter the name of department:");
                    }
                    break;
                case 3:
                    System.out.println("1)Add student.\n2)Edit student\n3)Delete student.\n4)Get students.\n5)Find student.");
                    mode = Reader.readInt(1, 5);
                    switch (mode) {
                        case 1:
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
                            break;
                        case 2:
                            System.out.println("Choose the student to edit:");
                            String oldStudentName = Reader.readLine();
                            System.out.println("Enter the new name of student:");
                            studentName = Reader.readLine();
                            System.out.println("Enter the new age of student:");
                            studentAge = Reader.readInt();
                            System.out.println("Enter the new group of student:");
                            studentGroup = Reader.readLine();
                            System.out.println("Enter the new year of study of student:");
                            yearOfStudy = Reader.readInt();
                            NAUKMA.editStudent(oldStudentName, studentName, studentAge, yearOfStudy, studentGroup);
                            break;
                        case 3:
                            System.out.println("Choose the student to delete:");
                            studentName = Reader.readLine();
                            NAUKMA.deleteStudent(studentName);
                            break;
                        case 4:
                            System.out.println("Choose the way of getting list:\n1)By alphabetical order.\n2)By year of study.");
                            int way = Reader.readInt(1, 2);
                            switch (way) {
                                case 1:
                                    ArrayList students = new ArrayList();
                                    students.add(NAUKMA.getStudents());
                                    OrderBy.name(students);
                                    System.out.println(students);
                                    break;
                                case 2:
                                    ArrayList students2 = new ArrayList();
                                    students2.add(NAUKMA.getStudents());
                                    OrderBy.year(students2);
                                    System.out.println(students2);
                                    break;
                            }
                        case 5:
                            System.out.println("Choose the way of searching:\n1)By name.\n2)By year.\n3)By group.");
                            way = Reader.readInt(1,3);
                            switch (way) {
                                case 1:
                                studentName = Reader.readLine();
                                ArrayList students = new ArrayList();
                                students.add(NAUKMA.getStudents());
                                Select.studentByName(students, studentName);
                                System.out.println(students);
                                break;
                                case 2:
                                    yearOfStudy = Reader.readInt(1,6);
                                    ArrayList students2 = new ArrayList();
                                    students2.add(NAUKMA.getStudents());
                                    Select.studentsByYear(students2,yearOfStudy);
                                    System.out.println(students2);
                                    break;
                                case 3:
                                    studentGroup = Reader.readLine();
                                    ArrayList students3 = new ArrayList();
                                    students3.add(NAUKMA.getStudents());
                                    Select.studentsByGroup(students3,studentGroup);
                                    System.out.println(students3);
                                    break;
                            }


                    }
                    break;
                case 4:
                    System.out.println("1)Add teacher.\n2)Edit teacher\n3)Delete teacher.\n4)Get list of teachers by alphabetical order.\n5)Find teacher.");
                    mode = Reader.readInt(1, 4);
                    mode = Reader.readInt(1, 5);
                    switch (mode) {
                        case 1:
                            System.out.println("Enter the name of teacher:");
                            String teacherName = Reader.readLine();
                            System.out.println("Enter the age of teacher:");
                            int teacherAge = Reader.readInt();
                            System.out.println("Enter the department of teacher:");
                            String departmentName = Reader.readLine();
                            NAUKMA.addTeacher(teacherName, teacherAge, departmentName);
                            break;
                        case 2:
                            System.out.println("Choose the teacher to edit:");
                            String oldTeacherName = Reader.readLine();
                            System.out.println("Enter the name of teacher:");
                            teacherName = Reader.readLine();
                            System.out.println("Enter the age of teacher:");
                            teacherAge = Reader.readInt();
                            NAUKMA.editTeacher(oldTeacherName, teacherName, teacherAge);
                            break;
                        case 3:
                            System.out.println("Choose the teacher to delete:");
                            teacherName = Reader.readLine();
                            NAUKMA.deleteTeacher(teacherName);
                            break;
                        case 4:
                            ArrayList teachers = new ArrayList();
                            teachers.add(NAUKMA.getTeachers());
                            OrderBy.name(teachers);
                            System.out.println(teachers);
                            break;
                        case 5:
                            System.out.println("Enter the name of teacher:");
                            teacherName = Reader.readLine();
                            ArrayList teachers2 = new ArrayList();
                            teachers2.add(NAUKMA.getTeachers());
                            Select.teacherByName(teachers2, teacherName);
                            break;

                    }
                case 5:
                    break;
            }
            break;
        }while(option !=5);
        Save.save(new File("resultDatabase.txt"), NAUKMA);
    }
}
