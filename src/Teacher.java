public class Teacher extends Person{
    private Department department;

    public Teacher(String name, int age, Department department) {
        super(name, age);
        this.department = department;
    }
}
