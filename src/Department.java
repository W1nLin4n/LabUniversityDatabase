import java.util.ArrayList;
import java.util.List;

public class Department {
    private Faculty faculty;
    private String name;
    private List<Student> students;
    private List<Teacher> teachers;

    public Department(String name){
        this.name = name;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    /**
     * This method should add new student to this department(must be unique by name)
     * @param student New student
     */
    public void addStudent(Student student){
    }

    /**
     * This method should add new teacher to this department(must be unique by name)
     * @param teacher New teacher
     */
    public void addTeacher(Teacher teacher){
    }

    /**
     * This method should delete a student from this department
     * @param student Student to delete
     */
    public void deleteStudent(Student student){
    }

    /**
     * This method should delete a teacher from this department
     * @param teacher New teacher
     */
    public void deleteTeacher(Teacher teacher){
    }

    /**
     * This method should edit a student from this department
     * @param oldStudent Student to edit
     * @param newStudent Parameters to change in student
     */
    public void editStudent(Student oldStudent, Student newStudent){

    }

    /**
     * This method should edit a teacher from this department
     * @param oldTeacher Teacher to edit
     * @param newTeacher Parameters to change in teacher
     */
    public void editTeacher(Teacher oldTeacher, Teacher newTeacher){

    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
