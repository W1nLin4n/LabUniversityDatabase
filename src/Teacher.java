public class Teacher extends Person{
    private Department department;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
