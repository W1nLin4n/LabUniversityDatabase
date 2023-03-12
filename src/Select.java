import java.util.ArrayList;
import java.util.List;

public class Select {
    /**
     * Finds student by name
     * @param list List of students
     * @param name Student's name
     * @return student or null if there is no such student
     */
    public static Student studentByName(List<Student> list, String name){
        for (Student student : list) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Finds teacher by name
     * @param list List of teachers
     * @param name Teacher's name
     * @return teacher or null if there is no such teacher
     */
    public static Teacher teacherByName(List<Teacher> list, String name){
        for (Teacher teacher : list) {
            if (teacher.getName().equals(name)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Finds students by year
     * @param list List of students
     * @param year Students' year
     * @return students selected by year
     */
    public static List<Student> studentsByYear(List<Student> list, int year){
        List<Student> result = new ArrayList<>();
        for (Student student : list) {
            if (student.getAge() == year) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * Finds student by group
     * @param list List of students
     * @param group Students' group
     * @return students selected by group
     */
    public static List<Student> studentsByGroup(List<Student> list, String group){
        List<Student> result = new ArrayList<>();
        for (Student student : list) {
            if (student.toString().equals(group)) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * Finds faculty by name
     * @param list List of faculties
     * @param name Faculty's name
     * @return faculty or null if there is no such faculty
     */
    public static Faculty facultyByName(List<Faculty> list, String name){
        for(Faculty faculty : list){
            if(faculty.getName().equals(name)){
                return faculty;
            }
        }
        return null;
    }

    /**
     * Finds department by name
     * @param list List of departments
     * @param name Department's name
     * @return department or null if there is no such department
     */
    public static Department departmentByName(List<Department> list, String name){
        for(Department department : list){
            if(department.getName().equals(name)){
                return department;
            }
        }
        return null;
    }

}
