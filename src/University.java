import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties;

    public University(File input){
        FileParser.readUniversityData(input, this);
    }

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
     * Get all faculties
     * @return all faculties
     */
    public List<Faculty> getFaculties(){
        return faculties;
    }

    /**
     * Get all departments
     * @return all departments
     */
    public List<Department> getDepartments(){
        List<Department> result = new ArrayList<>();
        return result;
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