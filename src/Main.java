import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
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
     * Finds student by name
     * @param name Student's name
     * @return student or null if there is no such student
     */
    public Student findStudentByName(String name){
        Student result = null;
        return result;
    }

    /**
     * Finds students by year
     * @param year Students' year
     * @return students or null if there is no such student
     */
    public ArrayList<Student> findStudentsByYear(int year){
        ArrayList<Student> result = new ArrayList<>();
        return result;
    }

    /**
     * Finds student by group
     * @param group Students' group
     * @return student or null if there is no such student
     */
    public ArrayList<Student> findStudentsByGroup(String group){
        ArrayList<Student> result = new ArrayList<>();
        return result;
    }

    /**
     * Finds teacher by name
     * @param name Teacher's name
     * @return teacher or null if there is no such teacher
     */
    public Teacher findTeacherByName(String name){
        Teacher result = null;
        return result;
    }

}