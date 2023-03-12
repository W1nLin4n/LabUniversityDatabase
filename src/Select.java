import java.util.ArrayList;
import java.util.List;

public class Select {
    /**
     * Finds student by name
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
     * @param year Students' year
     * @return students selected by year
     */
    public List<Student> studentsByYear(int year){
        List<Student> result = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == year) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * Finds student by group
     * @param group Students' group
     * @return students selected by group
     */
    public List<Student> studentsByGroup(String group){
        List<Student> result = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        for (Student student : students) {
            if (student.toString().equals(group)) {
                result.add(student);
            }
        }
        return result;
    }
}
