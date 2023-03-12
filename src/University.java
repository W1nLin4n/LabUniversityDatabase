import java.util.ArrayList;
import java.util.List;

public class University {
    List<Faculty> faculties;

    /**
     * This method should add new Faculty to university(must be unique by name)
     * @param faculty New faculty
     */
    public void addFaculty(Faculty faculty){
    }

    /**
     * This method should delete a faculty from university
     * @param faculty Faculty to delete
     */
    public void deleteFaculty(Faculty faculty){

    }

    /**
     * This method should edit a faculty from university
     * @param oldFaculty Faculty to edit
     * @param newFaculty Parameters to change in faculty
     */
    public void editFaculty(Faculty oldFaculty, Faculty newFaculty){

    }

    /**
     * Get all students in university
     * @return all students
     */
    public List<Student> getStudents(){
        List<Student> result = new ArrayList<>();
        return result;
    }

    /**
     * Get all teachers in university
     * @return all teachers
     */
    public List<Teacher> getTeachers(){
        List<Teacher> result = new ArrayList<>();
        return result;
    }

}