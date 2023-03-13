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
        students.add(student);
        student.setDepartment(this);
    }

    /**
     * This method should add new teacher to this department(must be unique by name)
     * @param teacher New teacher
     */
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
        teacher.setDepartment(this);
    }

    /**
     * This method should delete a student from this department
     * @param student Student to delete
     */
    public void deleteStudent(Student student){
        students.remove(student);
    }

    /**
     * This method should delete a teacher from this department
     * @param teacher New teacher
     */
    public void deleteTeacher(Teacher teacher){
        teachers.remove(teacher);
    }

    /**
     * This method should edit a student from this department
     * @param oldStudent Student to edit
     * @param newStudent Parameters to change in student
     */
    public void editStudent(Student oldStudent, Student newStudent){
        oldStudent.setName(newStudent.getName());
        oldStudent.setAge(newStudent.getAge());
        oldStudent.setYear(newStudent.getYear());
        oldStudent.setGroup(newStudent.getGroup());
    }

    /**
     * This method should edit a teacher from this department
     * @param oldTeacher Teacher to edit
     * @param newTeacher Parameters to change in teacher
     */
    public void editTeacher(Teacher oldTeacher, Teacher newTeacher){
        oldTeacher.setName(newTeacher.getName());
        oldTeacher.setAge(newTeacher.getAge());
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

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
