import java.util.ArrayList;
import java.util.List;

public class Faculty{
    private String name;
    private List<Department> departments;

    public Faculty(String name){
        this.name = name;
        departments = new ArrayList<>();
    }

    /**
     * This method should add new Department to this faculty(must be unique by name)
     * @param department New department
     */
    public void addDepartment(Department department){
    }

    /**
     * This method should delete a department from this faculty
     * @param department Department to delete
     */
    public void deleteDepartment(Department department){

    }

    /**
     * This method should edit a department from this faculty
     * @param oldDepartment Department to edit
     * @param newDepartment Parameters to change in department
     */
    public void editDepartment(Department oldDepartment, Department newDepartment){
        oldDepartment.setName(newDepartment.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Student> getStudents(){
        List<Student> result = new ArrayList<>();
        for(Department department : departments){
            result.addAll(department.getStudents());
        }
        return result;
    }

    public List<Teacher> getTeachers(){
        List<Teacher> result = new ArrayList<>();
        for(Department department : departments){
            result.addAll(department.getTeachers());
        }
        return result;
    }
}
