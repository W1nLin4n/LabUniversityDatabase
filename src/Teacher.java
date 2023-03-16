public class Teacher extends Person{
    private Department department;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Teacher " + getName() + ", age: " + getAge() + ", department: " + getDepartment().getName();
    }
}
