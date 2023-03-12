import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Save {

    public static void save(File output, University university){
        PrintWriter pw = null;
        List<Faculty> faculties = university.getFaculties();
        List<Department> departments = university.getDepartments();
        List<Student> students = university.getStudents();
        List<Teacher> teachers = university.getTeachers();
        try {
            pw = new PrintWriter(new FileWriter(output));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println("Faculty");
        for(Faculty faculty : faculties){
            pw.println(faculty.getName());
        }
        pw.println();
        pw.println("Department");
        for(Department department : departments){
            pw.println(department.getName() + "," + department.getFaculty().getName());
        }
        pw.println();
        pw.println("Student");
        for(Student student : students){
            pw.println(student.getName() + "," + student.getAge() + "," + student.getDepartment().getName() + "," + student.getYear() + "," + student.getGroup());
        }
        pw.println();
        pw.println("Teacher");
        for(Teacher teacher : teachers){
            pw.println(teacher.getName() + "," + teacher.getAge() + "," + teacher.getDepartment().getName());
        }
        pw.println();
    }
}
