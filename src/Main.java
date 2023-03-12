import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Faculty> faculties;

    public static void main(String[] args) {
    }

    /**
     * This method creates a menu with options
     */
    public static void menu(){

    }

    /**
     * This method should add new Faculty to university(must be unique by name)
     * @param faculty New faculty
     */
    public static void addFaculty(Faculty faculty){
    }

    /**
     * This method should delete a faculty from university
     * @param faculty Faculty to delete
     */
    public static void deleteFaculty(Faculty faculty){

    }

    /**
     * This method should edit a faculty from university
     * @param oldFaculty Faculty to edit
     * @param newFaculty Parameters to change in faculty
     */
    public static void editFaculty(Faculty oldFaculty, Faculty newFaculty){

    }

    /**
     * Get all students in university
     * @return all students
     */
    public static List<Student> getStudents(){
        List<Student> result = new ArrayList<>();
        return result;
    }

    /**
     * Get all teachers in university
     * @return all teachers
     */
    public static List<Teacher> getTeachers(){
        List<Teacher> result = new ArrayList<>();
        return result;
    }

}